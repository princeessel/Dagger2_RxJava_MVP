package com.example.dagger2_rxjava_mvp.application;

import android.app.Application;

import com.example.dagger2_rxjava_mvp.di.component.DaggerApplicationComponent;

public class CakeApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        DaggerApplicationComponent.create();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
