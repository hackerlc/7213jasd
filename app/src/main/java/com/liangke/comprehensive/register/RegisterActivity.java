package com.liangke.comprehensive.register;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityRegisterBinding;
import com.liangke.mvvm.viewmodel.RegisterViewModel;

/**
 * Created by LK on 2017/12/14.
 */

public class RegisterActivity extends BaseAppCompatActivity {

    @Override
    public void bindView() {

        ActivityRegisterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setViewModel(new RegisterViewModel(this,binding));

    }
}
