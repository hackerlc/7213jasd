package com.liangke.comprehensive.market;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentAssetlistBinding;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.mvvm.viewmodel.AssetListViewModel;

/**
 * Created by LK on 2017/12/15.
 */

public class AssetListFragment extends BaseFragment {

    private ProductSelectBean bean;

    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentAssetlistBinding binding = FragmentAssetlistBinding.inflate(inflater,container,false);
        binding.setViewModel(new AssetListViewModel(this,binding,bean));

        return binding.getRoot();
    }

    public void setBean(ProductSelectBean bean) {
        this.bean = bean;
    }
}
