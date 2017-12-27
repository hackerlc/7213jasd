package com.liangke.mvvm.viewmodel;

import android.util.Log;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivityLoginBinding;
import com.liangke.comprehensive.main.MainActivity;
import com.liangke.comprehensive.register.LoginActivity;
import com.liangke.constants.Constants;
import com.liangke.data.Preferences;
import com.liangke.http.response.LoginResponse;
import com.liangke.mvvm.model.LoginModel;
import com.liangke.mvvm.rxbing.LoginBing;
import com.liangke.widget.TabLinearLayout;

/**
 * Created by LK on 2017/12/13.
 */

public class LoginViewModel extends BaseViewModel {
    private final String TAG = LoginViewModel.class.getSimpleName();
    private LoginActivity activity;
    private ActivityLoginBinding binding;
    private  LoginModel loginModel;
    public LoginViewModel(LoginActivity activity, ActivityLoginBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;
        LoginBing bing = new LoginBing(activity,this,binding);

        loginModel = new LoginModel(mContext,observer);

        init();
    }

    @Override
    public void init() {



    }

    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof LoginResponse){
            LoginResponse response = (LoginResponse) value;
            if(response.getCode()== Constants.SUCCESS_CODE){
                Preferences.getInstance(mContext).setToken(response.getToken());
                mStartActivity(MainActivity.class);
            }
        }
    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void login(String username,String password){
        loginModel.login(username,password);
    }



}
