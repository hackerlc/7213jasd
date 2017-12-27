package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.LoginResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/14.
 */

public class LoginModel extends BaseModel {
    public LoginModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void login(String username,String password){
//        username: 用户名或注册手机
//        password: 登入密码
//        agentCode: 代理商标识
        RequestParams params = new RequestParams(mContext,"login");
        params.put("username",username);
        params.put("password",password);
        params.put("agentCode","-1");
        RetrofitUtils<LoginResponse> utils = new RetrofitUtils<>(LoginResponse.class);
        utils.enqueue(params, new RetrofitCallBack<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse loginModel) {

                sendResult(loginModel);
            }

            @Override
            public void onFailure(LoginResponse loginModel, Throwable throwable) {

            }
        });

    }

}
