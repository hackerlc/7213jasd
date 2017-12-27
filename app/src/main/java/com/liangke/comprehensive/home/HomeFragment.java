package com.liangke.comprehensive.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentHomeBinding;
import com.liangke.mvvm.viewmodel.HomeViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class HomeFragment extends BaseFragment {
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater,container,false);
        binding.setViewModel(new HomeViewModel(this,binding));
        return binding.getRoot();
    }
}
