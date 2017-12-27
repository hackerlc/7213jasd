package com.liangke.comprehensive.position;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityActionBinding;
import com.liangke.mvvm.viewmodel.ActionViewModel;

/**
 * Created by LK on 2017/12/26.
 */

public class ActionActivity extends BaseAppCompatActivity {
    @Override
    public void bindView() {
        ActivityActionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_action,null);
        binding.setViewModel(new ActionViewModel(this,binding));
    }
}
