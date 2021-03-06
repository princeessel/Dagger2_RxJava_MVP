package com.example.dagger2_rxjava_mvp.base;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.example.dagger2_rxjava_mvp.application.CakeApplication;
import com.example.dagger2_rxjava_mvp.di.component.ApplicationComponent;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

private ProgressDialog progressDialog;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        onViewReady(savedInstanceState,getIntent());

    }


@CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
  resolveDaggerDependency();
    }

    @Override
    protected void onDestroy() {
//        ButterKnife.unbind(this);
        super.onDestroy();
    }

    protected void resolveDaggerDependency() {

    }


    //    Show progrssDialog while fetching data
    protected void showDialog(String msg){
        if(progressDialog==null)
        {
            progressDialog=new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    protected void hideDialog() {
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
    }
    }
    protected ApplicationComponent getApplicationComponent(){

        return ((CakeApplication) getApplication()).getApplicationComponent();
    }
    protected abstract int getContentView();
}
