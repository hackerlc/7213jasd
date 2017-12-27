package com.liangke.comprehensive.register;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;

import com.liangke.base.BaseAppCompatActivity;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityFindpasswordBinding;
import com.liangke.mvvm.viewmodel.FindPasswordViewModel;

/**
 * Created by LK on 2017/12/19.
 */

public class FindPasswordActivity extends BaseAppCompatActivity {
    @Override
    public void bindView() {
        ActivityFindpasswordBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_findpassword,null);
        binding.setViewModel(new FindPasswordViewModel(this,binding));
    }
}
