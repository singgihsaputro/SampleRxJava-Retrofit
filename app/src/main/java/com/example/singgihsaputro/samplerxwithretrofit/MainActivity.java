package com.example.singgihsaputro.samplerxwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.singgihsaputro.samplerxwithretrofit.adapter.RvAdapter;
import com.example.singgihsaputro.samplerxwithretrofit.model.Movie;
import com.example.singgihsaputro.samplerxwithretrofit.service.MovieService;
import com.example.singgihsaputro.samplerxwithretrofit.service.ServiceFactory;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set up Android CardView/RecycleView
         */
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RvAdapter mCardAdapter = new RvAdapter();
        mRecyclerView.setAdapter(mCardAdapter);

        /**
         * START: button set up
         */
        Button bClear = (Button) findViewById(R.id.button_clear);
        Button bFetch = (Button) findViewById(R.id.button_fetch);
        bClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCardAdapter.clear();
            }
        });

        bFetch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MovieService service = ServiceFactory.createRetrofitService(MovieService.class, MovieService.SERVICE_ENDPOINT);
                    service.getMoviesPopular(BuildConfig.POPULAR_MOVIES_API_KEY)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<Movie>() {
                                @Override
                                public final void onCompleted() {
                                    // do nothing
                                }

                                @Override
                                public final void onError(Throwable e) {
                                    Log.e("MoviesDemo", e.getMessage());
                                }

                                @Override
                                public void onNext(Movie results) {
                                    List<Movie.Results> rs = results.getResults();
                                    Log.d("Size data json", String.valueOf(rs.size()));
                                    mCardAdapter.addData(rs);
                                }
                            });

            }
        });
        /**
         * END: button set up
         */
    }

}
