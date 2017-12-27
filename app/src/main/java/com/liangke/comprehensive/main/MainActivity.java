package com.liangke.comprehensive.main;

import android.databinding.DataBindingUtil;
import android.widget.Toast;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.ResponseBody;
import com.liangke.http.retrofit.RetrofitUtils;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityMainBinding;
import com.liangke.mvvm.viewmodel.MainViewModel;

public class MainActivity extends BaseAppCompatActivity {






    public void bindView() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new MainViewModel(this,binding);
        viewModel.init();

    }



}
