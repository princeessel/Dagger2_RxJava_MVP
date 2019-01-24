package com.example.dagger2_rxjava_mvp.di.component;

import android.content.Context;

import com.example.dagger2_rxjava_mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton
@Component(modules= ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();
    Context exposeContext();


}
