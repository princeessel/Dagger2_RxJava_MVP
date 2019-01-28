package com.example.dagger2_rxjava_mvp.base;


import com.example.dagger2_rxjava_mvp.mvp.view.BaseView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;



public class BasePresenter<V extends BaseView> {
@Inject protected V mView;

    protected V getView() {
        return mView;
    }

    protected <T>void subscribe(Observable<T> observable, Observer<T> observer){
    observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
               .subscribe(observer);
    }
}
