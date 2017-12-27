package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentUnloginBinding;
import com.liangke.comprehensive.mine.UnLoginFragment;
import com.liangke.mvvm.rxbing.UnLoginBing;

/**
 * Created by LK on 2017/12/13.
 */

public class UnLoginViewModel extends BaseViewModel {
    private UnLoginFragment fragment;
    private FragmentUnloginBinding binding;
    private UnLoginBing bing;
    public UnLoginViewModel(UnLoginFragment fragment, FragmentUnloginBinding binding) {
        super(fragment.getActivity());
        bing = new UnLoginBing(fragment.getActivity(),binding);
        this.fragment = fragment;
        this.binding = binding;

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
