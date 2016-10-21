package com.example.singgihsaputro.samplerxwithretrofit.data.repository.api;

import android.util.Log;

import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;
import com.example.singgihsaputro.samplerxwithretrofit.data.repository.DataSource;
import com.example.singgihsaputro.samplerxwithretrofit.util.Constant;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by singgihsaputro on 10/21/16.
 */

public class MoviesAPIDataSource implements DataSource {
    @Override
    public Observable<MovieEntity> getMovies(final String apiKey) {
        return Observable.create(new Observable.OnSubscribe<MovieEntity>(){

            @Override
            public void call(Subscriber<? super MovieEntity> subscriber) {
                MovieService  service = MovieAPIRepository.createRetrofitService(MovieService.class, MovieService.SERVICE_ENDPOINT);
                MovieEntity movies = service.getMoviesPopular(apiKey);
                subscriber.onNext(movies);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread());

    }
}
