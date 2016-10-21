package com.example.singgihsaputro.samplerxwithretrofit.domain.usecase;

import android.util.Log;

import com.example.singgihsaputro.samplerxwithretrofit.base.UseCase;
import com.example.singgihsaputro.samplerxwithretrofit.data.repository.Repository;

import rx.Observable;

/**
 * Created by singgihsaputro on 10/20/16.
 */

public class GetMovies extends UseCase{

    private Repository repository;

    private String apiKey;

    public GetMovies(Repository repository) {
        this.repository = repository;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return repository.getMovies(apiKey);
    }
}
