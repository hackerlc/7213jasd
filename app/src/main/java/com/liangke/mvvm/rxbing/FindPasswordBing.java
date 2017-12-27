package com.liangke.mvvm.rxbing;

import android.content.Context;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityFindpasswordBinding;
import com.liangke.constants.Constants;
import com.liangke.mvvm.viewmodel.FindPasswordViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/19.
 */

public class FindPasswordBing extends BaseRxBing {

    private FindPasswordViewModel viewModel;
    private ActivityFindpasswordBinding binding;

    public FindPasswordBing(Context context,FindPasswordViewModel viewModel,ActivityFindpasswordBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {
        RxView.clicks(binding.tvSendCode).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {

                String phone = binding.etPhone.getText().toString().trim();
                if(phone.isEmpty()){
                    showToast("请输入手机号");
                    return;
                }
                viewModel.getRegisterCode(binding.etPhone.getText().toString().trim());
                binding.tvSendCode.setBackgroundResource(R.drawable.bg_shape_cornor_solid_gray);
                binding.tvSendCode.setEnabled(false);
                Observable.interval(0,1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .take(Constants.COUNTDOWN)
                        .subscribe(new Observer<Long>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull Long aLong) {
                                binding.tvSendCode.setText(""+(Constants.COUNTDOWN-aLong-1)+"s");
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                binding.tvSendCode.setBackgroundResource(R.drawable.bg_shape_cornor_solid_blue);
                                binding.tvSendCode.setText("获取验证码");
                                binding.tvSendCode.setEnabled(true);
                            }
                        });

            }
        });
    }
}
