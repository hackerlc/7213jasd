package com.liangke.comprehensive.market;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentOtherchoiceBinding;
import com.liangke.mvvm.viewmodel.OtherChoiceViewModel;

/**
 * Created by LK on 2017/12/14.
 */

public class OtherChoiceFragment extends BaseFragment {


    private String productId;

    private OtherChoiceViewModel viewModel;

    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentOtherchoiceBinding binding = FragmentOtherchoiceBinding.inflate(inflater,container,false);
        viewModel = new OtherChoiceViewModel(this,binding);
        viewModel.setProductId(productId);
        viewModel.init();
        binding.setViewModel(viewModel);

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
