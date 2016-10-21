package com.example.singgihsaputro.samplerxwithretrofit.data.repository;

import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;

import rx.Observable;

/**
 * Created by singgihsaputro on 10/19/16.
 */

public interface DataSource {
    Observable<MovieEntity> getMovies(String apiKey);
}
