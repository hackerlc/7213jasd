package com.liangke.mvvm.rxbing;

import android.content.Context;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityLoginBinding;
import com.liangke.comprehensive.register.RegisterActivity;
import com.liangke.mvvm.viewmodel.LoginViewModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/14.
 */

public class LoginBing extends BaseRxBing {
    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private String phone,password;

    public LoginBing(Context context, LoginViewModel viewModel,ActivityLoginBinding binding) {
        super(context);
        this.binding = binding;
        this.viewModel = viewModel;
        initAction();

    }

    @Override
    public void initAction() {

        Observable<CharSequence> phoneObservable = RxTextView.textChanges(binding.etPhone);
        final Observable<CharSequence> passwordObservable = RxTextView.textChanges(binding.etPassword);
        Observable.combineLatest(phoneObservable, passwordObservable, new BiFunction<CharSequence, CharSequence, Boolean>() {

            @Override
            public Boolean apply(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2) throws Exception {

                phone = charSequence.toString().trim();
                password = charSequence2.toString().trim();
                return !charSequence.toString().trim().isEmpty()&&!charSequence2.toString().trim().isEmpty();
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(@NonNull Boolean aBoolean) throws Exception {
                binding.bLogin.setEnabled(aBoolean);
                if(aBoolean){
                    binding.bLogin.setBackgroundResource(R.drawable.bg_shape_cornor_solid_blue_02);
                }else{
                    binding.bLogin.setBackgroundResource(R.drawable.bg_shape_cornor_solid_gray);
                }
            }
        });

        //注册
        RxView.clicks(binding.tvRegister).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(RegisterActivity.class);
            }
        });
        //忘记密码
        RxView.clicks(binding.llForget).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(RegisterActivity.class);
            }
        });
        //登陆
        RxView.clicks(binding.bLogin).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                viewModel.login(phone,password);
            }
        });
    }
}
