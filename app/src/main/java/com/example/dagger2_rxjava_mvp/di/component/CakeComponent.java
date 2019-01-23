package com.example.dagger2_rxjava_mvp.di.component;


import com.example.dagger2_rxjava_mvp.di.module.ApplicationModule;
import com.example.dagger2_rxjava_mvp.di.module.CakeModule;

import dagger.Component;
import dagger.Module;

@Module
@Component(modules= CakeModule.class, dependencies= ApplicationComponent.class)
public class CakeComponent {
}
