package com.liangke.comprehensive.position;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.adapter.AllPositionAdapter;
import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentAllpositionBinding;
import com.liangke.mvvm.viewmodel.AllPositionViewModel;

/**
 * Created by LK on 2017/12/25.
 */

public class AllPositionFragment extends BaseFragment {
    private AllPositionViewModel viewModel;
    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAllpositionBinding binding = FragmentAllpositionBinding.inflate(inflater,container,false);

        viewModel = new AllPositionViewModel(this,binding);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestory();
    }
}
