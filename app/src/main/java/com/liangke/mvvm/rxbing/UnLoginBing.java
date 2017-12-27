package com.liangke.mvvm.rxbing;

import android.content.Context;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.FragmentUnloginBinding;
import com.liangke.comprehensive.register.LoginActivity;
import com.liangke.comprehensive.register.RegisterActivity;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/13.
 */

public class UnLoginBing extends BaseRxBing {
    private final String TAG = UnLoginBing.class.getSimpleName();
    private FragmentUnloginBinding binding;
    public UnLoginBing( Context activity,FragmentUnloginBinding binding) {
        super(activity);
        this.binding = binding;
        initAction();
    }


    @Override
    public void initAction() {

        RxView.clicks(binding.tvLogin).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(LoginActivity.class);
            }
        });

        RxView.clicks(binding.tvRegister).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(RegisterActivity.class);
            }
        });

    }
}
