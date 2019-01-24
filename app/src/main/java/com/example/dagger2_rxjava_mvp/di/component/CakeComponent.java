package com.example.dagger2_rxjava_mvp.di.component;


import com.example.dagger2_rxjava_mvp.di.module.CakeModule;
import com.example.dagger2_rxjava_mvp.modules.home.MainActivity;
import com.example.dagger2_rxjava_mvp.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules= CakeModule.class, dependencies= ApplicationComponent.class)
public interface CakeComponent {
    void inject(MainActivity activity);

}
