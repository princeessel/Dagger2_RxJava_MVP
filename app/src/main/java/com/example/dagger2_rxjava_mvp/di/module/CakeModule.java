package com.example.dagger2_rxjava_mvp.di.module;

import com.example.dagger2_rxjava_mvp.api.CakeApiService;
import com.example.dagger2_rxjava_mvp.di.scope.PerActivity;
import com.example.dagger2_rxjava_mvp.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class CakeModule {
    private MainView mView;
    public CakeModule(MainView view){
        mView=view;
    }
    @PerActivity
    @Provides
    CakeApiService providesApiService(Retrofit retrofit){
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView(){
        return mView;
    }
}
