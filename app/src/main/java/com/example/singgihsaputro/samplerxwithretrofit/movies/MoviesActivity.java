package com.example.singgihsaputro.samplerxwithretrofit.movies;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.singgihsaputro.samplerxwithretrofit.R;
import com.example.singgihsaputro.samplerxwithretrofit.adapter.RvAdapter;
import com.example.singgihsaputro.samplerxwithretrofit.base.BaseActivity;
import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MoviesActivity extends BaseActivity implements MoviesContract.View{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    RvAdapter mCardAdapter;
    private MoviesContract.Presenter moviesPresenter;
    private ProgressDialog pDialog;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setup() {
        mCardAdapter = new RvAdapter();
        initRecyclerView(mCardAdapter);
        initProgressDialog();
        initPresenter();
    }

    private void initPresenter() {
        new MoviesPresenter(this);
    }

    private void initRecyclerView(RvAdapter mCardAdapter) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCardAdapter);
    }

    private void initProgressDialog() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCanceledOnTouchOutside(false);
    }

    @OnClick(R.id.button_clear)
    public void clearMovies(){
        mCardAdapter.clear();
    }

    @OnClick(R.id.button_fetch)
    public void fetchMovies(){
        moviesPresenter.subscribe();
    }

    @Override
    public void onLoading() {
        pDialog.show();
    }

    @Override
    public void onLoadSuccess() {
        pDialog.hide();
    }

    @Override
    public void onLoadFailed() {
        pDialog.hide();
    }

    @Override
    public void addData(List<MovieEntity.Results> rs) {
        mCardAdapter.addData(rs);
    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        this.moviesPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviesPresenter.unsubscribe();
    }
}
