package com.liangke.comprehensive.market;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityProductBinding;
import com.liangke.mvvm.viewmodel.ProductListViewModel;

/**
 * Created by LK on 2017/12/27.
 */

public class ProductListActivity extends BaseAppCompatActivity {
    @Override
    public void bindView() {
        ActivityProductBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        binding.setViewModel(new ProductListViewModel(this,binding));
    }
}
