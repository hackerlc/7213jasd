package com.liangke.comprehensive.home;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityHomesearchBinding;
import com.liangke.mvvm.viewmodel.HomeSearchViewModel;

/**
 * Created by LK on 2017/12/22.
 */

public class HomeSearchActivity extends BaseAppCompatActivity {

    @Override
    public void bindView() {

        ActivityHomesearchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_homesearch,null);
        binding.setViewModel(new HomeSearchViewModel(this,binding));

    }
}
