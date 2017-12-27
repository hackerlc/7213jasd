package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.util.Log;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentAssetlistBinding;
import com.liangke.comprehensive.market.AssetListFragment;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.mvvm.model.AssetListModel;

/**
 * Created by LK on 2017/12/15.
 */

public class AssetListViewModel extends BaseViewModel {

    private final String TAG = AssetListViewModel.class.getSimpleName();

    private AssetListFragment fragment;
    private FragmentAssetlistBinding binding;
    private AssetListModel model;
    private ProductSelectBean bean;
    public AssetListViewModel(AssetListFragment fragment, FragmentAssetlistBinding binding, ProductSelectBean bean) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        this.bean = bean;
        model = new AssetListModel(mContext,observer);

        init();
    }

    @Override
    public void init() {

        binding.tvTitle.setText(bean.getName());

        model.init(binding.rvList);


    }

    @Override
    public void onRxJavaNext(Object value) {

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }
}
