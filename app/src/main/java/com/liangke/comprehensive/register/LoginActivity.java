package com.liangke.comprehensive.register;

import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityLoginBinding;
import com.liangke.mvvm.viewmodel.LoginViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class LoginActivity extends BaseAppCompatActivity {



    @Override
    public void bindView() {
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel viewModel = new LoginViewModel(this,binding);
        binding.setViewmodel(viewModel);
    }
}
