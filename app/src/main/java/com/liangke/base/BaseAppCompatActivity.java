package com.liangke.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

/**
 * Created by LK on 2017/12/12.
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity implements Base {

    public Activity mActivity;


    public BaseAppCompatActivity() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PushAgent.getInstance(this).onAppStart();

        bindView();

    }

    public abstract void bindView();

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public void showBufferDialog() {

    }

    @Override
    public void dismissBufferDialog() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void mStartActivity(Class<?> mClass) {

    }

    @Override
    public void mStartActivity(Class<?> mClass, Bundle bundle) {

    }

    @Override
    public void mStartActivityForResult(Class<?> mClass, Bundle bundle, int requestCode) {

    }

    @Override
    public void mStartActivityForResult(Class<?> mClass, int requestCode) {

    }

    public void onBackFinish(View view){
        finish();
    }

}
