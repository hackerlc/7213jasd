package com.liangke.comprehensive.market;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivitySearchBinding;
import com.liangke.mvvm.viewmodel.SearchViewModel;

/**
 * Created by LK on 2017/12/21.
 */

public class SearchActivity extends BaseAppCompatActivity {
    @Override
    public void bindView() {

        ActivitySearchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search,null);
        binding.setViewModel(new SearchViewModel(this,binding));


    }
}
