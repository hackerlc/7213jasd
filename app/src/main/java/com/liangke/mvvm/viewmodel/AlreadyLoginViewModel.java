package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentAlreadyloginBinding;
import com.liangke.comprehensive.mine.AlreadyLoginFragment;

/**
 * Created by LK on 2017/12/19.
 */

public class AlreadyLoginViewModel extends BaseViewModel {
    private AlreadyLoginFragment fragment;
    private FragmentAlreadyloginBinding binding;
    public AlreadyLoginViewModel(AlreadyLoginFragment fragment,FragmentAlreadyloginBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        init();
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
