package com.example.singgihsaputro.samplerxwithretrofit.base;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by singgihsaputro on 10/19/16.
 */

public abstract class UseCase {
    private Subscription subscription = Subscriptions.empty();

    protected abstract Observable buildUseCaseObservable();

    public void execute(Subscriber useCaseSubcriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(useCaseSubcriber);
    }

    public void unsubscribe() {
        subscription.unsubscribe();
    }
}
