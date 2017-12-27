package com.liangke.comprehensive.market;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.Window;
import android.view.WindowManager;


import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityMarketBinding;
import com.liangke.mvvm.viewmodel.SingleMarketViewModel;

/**
 * Created by LK on 2017/12/13.
 */

public class SingleMarketActivity extends BaseAppCompatActivity{

    private final String TAG = SingleMarketActivity.class.getSimpleName();

    private SingleMarketViewModel viewModel;


    @Override
    public void bindView() {

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setTheme(R.style.AppTheme2);
        }else{
            setTheme(R.style.AppTheme3);
        }

        ActivityMarketBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_market);
        viewModel = new SingleMarketViewModel(this,binding);
        binding.setViewModel(viewModel);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestory();
    }

    public SingleMarketViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(SingleMarketViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
