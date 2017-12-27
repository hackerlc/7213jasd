package com.liangke.comprehensive.market;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentHorizontalchartBinding;
import com.liangke.mvvm.viewmodel.HorizontalChartViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class HorizontalChartFragment extends BaseFragment {

    public HorizontalChartFragment() {

    }

    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        FragmentHorizontalchartBinding binding = FragmentHorizontalchartBinding.inflate(inflater,container,false);

        binding.setViewModel(new HorizontalChartViewModel(this,binding));

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
}
