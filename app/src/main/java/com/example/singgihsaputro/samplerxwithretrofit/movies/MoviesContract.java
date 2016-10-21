package com.example.singgihsaputro.samplerxwithretrofit.movies;

import com.example.singgihsaputro.samplerxwithretrofit.base.BasePresenter;
import com.example.singgihsaputro.samplerxwithretrofit.base.BaseView;
import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;

import java.util.List;

/**
 * Created by singgihsaputro on 10/20/16.
 */

public interface MoviesContract {

    interface  Presenter extends BasePresenter{

        void getListMovies();
    }

    interface  View extends BaseView<Presenter> {

        void onLoading();

        void onLoadSuccess();

        void onLoadFailed();

        void addData(List<MovieEntity.Results> rs);
    }
}
