package com.liangke.comprehensive.market;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentVerticalchartBinding;
import com.liangke.mvvm.viewmodel.VerticalChartViewModel;

/**
 * Created by LK on 2017/12/19.
 */

public class VerticalChartFragment extends BaseFragment {

    private final String TAG = VerticalChartFragment.class.getSimpleName();

    private VerticalChartViewModel viewModel;

    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentVerticalchartBinding binding = FragmentVerticalchartBinding.inflate(inflater,container,false);
        viewModel = new VerticalChartViewModel(this,binding);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestory();
    }

}
