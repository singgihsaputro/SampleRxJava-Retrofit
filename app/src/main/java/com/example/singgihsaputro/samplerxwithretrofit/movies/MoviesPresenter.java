package com.example.singgihsaputro.samplerxwithretrofit.movies;

import android.util.Log;
import android.widget.Toast;

import com.example.singgihsaputro.samplerxwithretrofit.base.Injector;
import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;
import com.example.singgihsaputro.samplerxwithretrofit.data.repository.api.MovieAPIRepository;
import com.example.singgihsaputro.samplerxwithretrofit.data.repository.api.MovieService;
import com.example.singgihsaputro.samplerxwithretrofit.domain.usecase.GetMovies;
import com.example.singgihsaputro.samplerxwithretrofit.util.Constant;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by singgihsaputro on 10/20/16.
 */

public class MoviesPresenter implements MoviesContract.Presenter{

    private MoviesContract.View view;

    private GetMovies getMovies;

    public MoviesPresenter(MoviesContract.View view) {
        this.view = view;
        getMovies = new GetMovies(Injector.provideRepository());
        view.setPresenter(this);

    }

    @Override
    public void getListMovies() {
        getMovies.setApiKey(Constant.API_KEY);
        getMovies.execute(new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
                // do nothing
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MoviesDemo", e.getMessage());
            }

            @Override
            public void onNext(MovieEntity results) {
                List<MovieEntity.Results> rs = results.getResults();
                Log.d("Size data json", String.valueOf(rs.size()));
                view.addData(rs);
            }

        });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
