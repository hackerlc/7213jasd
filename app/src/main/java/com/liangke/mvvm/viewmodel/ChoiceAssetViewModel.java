package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.liangke.adapter.ChoiceAssetAdapter;
import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityChoiceassetBinding;
import com.liangke.comprehensive.market.AssetListFragment;
import com.liangke.comprehensive.market.ChoiceAssetActivity;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.mvvm.rxbing.ChoiceAssetBing;
import com.liangke.utils.FragmentSwitchUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/15.
 */

public class ChoiceAssetViewModel extends BaseViewModel {
    private ChoiceAssetActivity activity;
    private ActivityChoiceassetBinding binding;
    public ChoiceAssetViewModel(ChoiceAssetActivity activity,ActivityChoiceassetBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;
        ChoiceAssetBing bing = new ChoiceAssetBing(activity,binding);
        init();
    }



    @Override
    public void init() {


        Bundle bundle = activity.getIntent().getExtras();
        List<ProductSelectBean> list = (List<ProductSelectBean>) bundle.getSerializable("list");


        List<Fragment> fragmentList = new ArrayList<>();
        for(int i = 1;i<list.size();i++){
            AssetListFragment fragment = new AssetListFragment();
            fragment.setBean(list.get(i));
            fragmentList.add(fragment);
        }

        ChoiceAssetAdapter adapter = new ChoiceAssetAdapter(activity.getSupportFragmentManager(),fragmentList);
        binding.vpFragment.setAdapter(adapter);
        binding.vpFragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.dllDot.setSelectedPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.dllDot.setSelectedRes(R.drawable.dot_selected);
        binding.dllDot.setUnSelectedRes(R.drawable.dot_unselected);
        binding.dllDot.setCount(list.size()-1);
        binding.dllDot.invalidate();

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
