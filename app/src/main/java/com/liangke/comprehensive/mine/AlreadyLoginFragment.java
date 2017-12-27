package com.liangke.comprehensive.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentAlreadyloginBinding;
import com.liangke.mvvm.viewmodel.AlreadyLoginViewModel;

/**
 * Created by LK on 2017/12/19.
 */

public class AlreadyLoginFragment extends BaseFragment {
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentAlreadyloginBinding binding = FragmentAlreadyloginBinding.inflate(inflater,container,false);
        binding.setViewModel(new AlreadyLoginViewModel(this,binding));

        return binding.getRoot();
    }
}
