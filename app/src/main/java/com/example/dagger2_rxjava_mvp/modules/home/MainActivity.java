package com.example.dagger2_rxjava_mvp.modules.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dagger2_rxjava_mvp.R;
import com.example.dagger2_rxjava_mvp.base.BaseActivity;
import com.example.dagger2_rxjava_mvp.di.component.DaggerCakeComponent;
import com.example.dagger2_rxjava_mvp.di.module.CakeModule;
import com.example.dagger2_rxjava_mvp.modules.home.adapter.CakeAdapter;
import com.example.dagger2_rxjava_mvp.mvp.model.Cake;
import com.example.dagger2_rxjava_mvp.mvp.presenter.CakePresenter;
import com.example.dagger2_rxjava_mvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements MainView {

@BindView(R.id.cake_list)protected RecyclerView mcakeList;
    @Inject protected CakePresenter presenter;
    private CakeAdapter mCakeAdapter;
    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        presenter.getCakes();
    }

//Method to initialize the recyclerview
    private void initializeList(){
        mcakeList.setHasFixedSize(true);
        mcakeList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mCakeAdapter=new CakeAdapter(getLayoutInflater());
        mcakeList.setAdapter(mCakeAdapter);


    }


    @Override
    protected int getContentView() {
            return R.layout.activity_main;
        }

    protected void resolveDaggerDependency() {

        DaggerCakeComponent.builder()
                            .applicationComponent(getApplicationComponent())
                            .cakeModule(new CakeModule(this))
                            .build().inject(this);

    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mCakeAdapter.addCakes(cakes);

    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowDialog(String message) {
         showDialog(message);

    }
}




