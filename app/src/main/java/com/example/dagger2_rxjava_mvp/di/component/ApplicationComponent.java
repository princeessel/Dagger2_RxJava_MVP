package com.example.dagger2_rxjava_mvp.di.component;

import com.example.dagger2_rxjava_mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton
@Component(modules= ApplicationModule.class)
public interface ApplicationComponent {



}
