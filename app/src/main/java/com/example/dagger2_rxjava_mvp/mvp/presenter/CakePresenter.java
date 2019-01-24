package com.example.dagger2_rxjava_mvp.mvp.presenter;

import com.example.dagger2_rxjava_mvp.api.CakeApiService;
import com.example.dagger2_rxjava_mvp.base.BasePresenter;
import com.example.dagger2_rxjava_mvp.mapper.CakeMapper;
import com.example.dagger2_rxjava_mvp.mvp.model.Cake;
import com.example.dagger2_rxjava_mvp.mvp.model.CakeResponse;
import com.example.dagger2_rxjava_mvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakeResponse> {
 @Inject protected CakeApiService apiService;
 @Inject protected CakeMapper cakeMapper;
    @Inject
    public CakePresenter() {
    }

    public void getCakes() {
        getView().onShowDialog("Wait a Minutes, Cakes Loading...");
        Observable<CakeResponse> cakesResponseObservable = apiService.getCakes();
         subscribe(cakesResponseObservable,this);

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(CakeResponse response) {
        List<Cake> cakes = cakeMapper.mapCakes(response);
        getView().onCakeLoaded(cakes);
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error" +e.getMessage());


    }

    @Override
    public void onComplete() {
        getView().onHideDialog();
        getView().onShowToast("Cakes Loading Completed");


    }
}
