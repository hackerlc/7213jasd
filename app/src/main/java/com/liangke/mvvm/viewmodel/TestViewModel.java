package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivityTestBinding;

/**
 * Created by LK on 2017/12/12.
 */

public class TestViewModel extends BaseViewModel {
    ActivityTestBinding binding;
    public TestViewModel(ActivityTestBinding binding,Context context) {
        super(context);
    }

    @Override
    public void init() {

    }

    @Override
    public void onRxJavaNext(Object value) {

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

}
