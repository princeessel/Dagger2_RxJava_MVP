package com.example.dagger2_rxjava_mvp.mvp.view;

import com.example.dagger2_rxjava_mvp.mvp.model.Cake;

import java.util.List;

public interface MainView extends BaseView {
    void onCakeLoaded(List<Cake> cakes);
    void onHideDialog();

    void onShowToast(String message);


    void onShowDialog(String message);
}
