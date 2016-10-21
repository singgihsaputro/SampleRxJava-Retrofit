package com.example.singgihsaputro.samplerxwithretrofit.base;

import com.example.singgihsaputro.samplerxwithretrofit.data.repository.Repository;
import com.example.singgihsaputro.samplerxwithretrofit.data.repository.api.MoviesAPIDataSource;

/**
 * Created by singgihsaputro on 10/21/16.
 */

public class Injector {
    private static Repository repository;

    private static MoviesAPIDataSource moviesAPIDataSource;

    public static final Repository provideRepository() {
        if (repository == null) {
            repository = new Repository(provideMoviesAPIDataSource());
        }
        return repository;
    }

    private static MoviesAPIDataSource provideMoviesAPIDataSource() {
        if (moviesAPIDataSource == null) {
            moviesAPIDataSource = new MoviesAPIDataSource();
        }
        return moviesAPIDataSource;
    }

}
