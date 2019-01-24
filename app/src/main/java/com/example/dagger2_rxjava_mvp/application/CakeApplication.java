package com.example.dagger2_rxjava_mvp.application;

import android.app.Application;

import com.example.dagger2_rxjava_mvp.di.component.ApplicationComponent;
import com.example.dagger2_rxjava_mvp.di.component.DaggerApplicationComponent;

public class CakeApplication extends Application {

    ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent=DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
