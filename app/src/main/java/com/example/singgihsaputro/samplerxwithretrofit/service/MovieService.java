package com.example.singgihsaputro.samplerxwithretrofit.service;

import com.example.singgihsaputro.samplerxwithretrofit.model.Movie;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by singgihsaputro on 10/18/16.
 */

public interface MovieService {
    String SERVICE_ENDPOINT = "http://api.themoviedb.org";

    @GET("/3/movie/popular")
    Observable<Movie> getMoviesPopular(@Query("api_key") String apiKey);

}
