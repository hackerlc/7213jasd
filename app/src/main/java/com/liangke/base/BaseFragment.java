package com.liangke.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LK on 2017/12/12.
 */

public abstract class BaseFragment extends Fragment implements Base {

    public BaseFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return bindView(inflater,container,savedInstanceState);
    }

    @Override
    public void showBufferDialog() {

    }

    @Override
    public void dismissBufferDialog() {

    }

    public abstract View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


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
}
