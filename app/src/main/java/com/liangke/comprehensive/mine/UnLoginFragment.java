package com.liangke.comprehensive.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentUnloginBinding;
import com.liangke.mvvm.viewmodel.UnLoginViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class UnLoginFragment extends BaseFragment {
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentUnloginBinding binding = FragmentUnloginBinding.inflate(inflater,container,false);
        UnLoginViewModel viewModel = new UnLoginViewModel(this,binding);
        binding.setViewmodel(viewModel);
        viewModel.init();
        return binding.getRoot();
    }
}
