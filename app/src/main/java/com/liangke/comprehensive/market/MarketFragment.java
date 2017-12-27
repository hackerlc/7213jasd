package com.liangke.comprehensive.market;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentMarketBinding;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.mvvm.viewmodel.MarketViewModel;

import java.util.List;

/**
 * Created by LK on 2017/12/13.
 */

public class MarketFragment extends BaseFragment {
    private MarketViewModel viewModel;
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentMarketBinding binding = FragmentMarketBinding.inflate(inflater,container,false);
        viewModel = new MarketViewModel(this,binding);
        binding.setViewmodel(viewModel);
        viewModel.init();
        return binding.getRoot();
    }

    public List<ProductSelectBean> getClissifyerList(){
        return viewModel.getNewsclassifierBeen();
    }

}
