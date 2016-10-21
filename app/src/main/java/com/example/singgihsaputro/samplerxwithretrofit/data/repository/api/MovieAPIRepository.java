package com.example.singgihsaputro.samplerxwithretrofit.data.repository.api;

import com.jakewharton.retrofit.Ok3Client;

import okhttp3.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by singgihsaputro on 10/18/16.
 */

public class MovieAPIRepository {
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {

        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .build();
        T service = restAdapter.create(clazz);

        return service;
    }
}
