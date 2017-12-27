package com.liangke.comprehensive.community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangke.base.BaseFragment;
import com.liangke.comprehensive.databinding.FragmentCommunityBinding;
import com.liangke.mvvm.viewmodel.CommunityViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class CommunityFragment extends BaseFragment {


    @Override
    public View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentCommunityBinding binding = FragmentCommunityBinding.inflate(inflater,container,false);
        binding.setViewModel(new CommunityViewModel(this,binding));
        return binding.getRoot();
    }
}
