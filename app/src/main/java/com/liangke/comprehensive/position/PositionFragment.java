package com.liangke.comprehensive.position;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentPositionBinding;
import com.liangke.mvvm.viewmodel.PositionViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class PositionFragment extends BaseFragment {
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPositionBinding binding = FragmentPositionBinding.inflate(inflater,container,false);
        binding.setViewModel(new PositionViewModel(this,binding));
        return binding.getRoot();
    }
}
