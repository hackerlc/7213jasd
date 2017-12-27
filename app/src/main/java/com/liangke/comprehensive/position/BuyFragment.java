package com.liangke.comprehensive.position;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentBuyBinding;

/**
 * Created by LK on 2017/12/26.
 */

public class BuyFragment extends BaseFragment {
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBuyBinding buyBinding = FragmentBuyBinding.inflate(inflater,container,false);
        return buyBinding.getRoot();
    }
}
