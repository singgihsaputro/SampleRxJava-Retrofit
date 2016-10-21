package com.example.singgihsaputro.samplerxwithretrofit.data.repository;

import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;
import com.example.singgihsaputro.samplerxwithretrofit.data.repository.api.MoviesAPIDataSource;

import rx.Observable;

/**
 * Created by singgihsaputro on 10/19/16.
 */

public class Repository implements DataSource{
    private DataSource dataSource;

    public Repository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<MovieEntity> getMovies(String api_key) {
        return dataSource.getMovies(api_key);
    }
}
