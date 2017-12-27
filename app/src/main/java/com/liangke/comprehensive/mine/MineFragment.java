package com.liangke.comprehensive.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentMineBinding;
import com.liangke.mvvm.viewmodel.MainViewModel;
import com.liangke.mvvm.viewmodel.MineViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class MineFragment extends BaseFragment {
    private final String TAG = MineFragment.class.getSimpleName();
    private MineViewModel viewModel;
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMineBinding binding = FragmentMineBinding.inflate(inflater,container,false);
        viewModel = new MineViewModel(this,binding);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }
}
