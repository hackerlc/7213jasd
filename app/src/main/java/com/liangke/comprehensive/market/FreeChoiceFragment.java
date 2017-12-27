package com.liangke.comprehensive.market;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.FragmentFreechoiceBinding;
import com.liangke.mvvm.viewmodel.FreeChoiceViewModel;

/**
 * Created by LK on 2017/12/14.
 */

public class FreeChoiceFragment extends BaseFragment {
    private String productId;
    private FreeChoiceViewModel viewModel;
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentFreechoiceBinding binding = FragmentFreechoiceBinding.inflate(inflater,container,false);
        viewModel = new FreeChoiceViewModel(this,binding);
        binding.setViewModel(viewModel);
        viewModel.init();

        return binding.getRoot();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestory();
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
