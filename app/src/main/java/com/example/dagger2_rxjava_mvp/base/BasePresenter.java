package com.example.dagger2_rxjava_mvp.base;

import com.example.dagger2_rxjava_mvp.mvp.model.CakeResponse;
import com.example.dagger2_rxjava_mvp.mvp.presenter.CakePresenter;
import com.example.dagger2_rxjava_mvp.mvp.view.BaseView;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Observer;
import rx.schedulers.Schedulers;

public class BasePresenter<V extends BaseView> {
@Inject protected V mView;

    protected V getView() {
        return mView;
    }

    protected <T>void subscribe(Observable<CakeResponse> observable, CakePresenter observer){
    observable.subscribeOn(Schedulers.newThread())
               .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(observer);
    }
}
