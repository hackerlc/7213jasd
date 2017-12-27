package com.liangke.comprehensive.position;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentQueryBinding;

/**
 * Created by LK on 2017/12/27.
 */

public class QueryFragment extends BaseFragment {
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentQueryBinding binding = FragmentQueryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

}
