package com.liangke.comprehensive.market;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityChoiceassetBinding;
import com.liangke.mvvm.viewmodel.ChoiceAssetViewModel;

/**
 * Created by LK on 2017/12/15.
 */

public class ChoiceAssetActivity extends BaseAppCompatActivity {


    @Override
    public void bindView() {

        ActivityChoiceassetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_choiceasset);
        binding.setViewModel(new ChoiceAssetViewModel(this,binding));

    }
}
