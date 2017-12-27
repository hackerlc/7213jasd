package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.RegisterResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 * 用户注册
 */

public class RegisterModel extends BaseModel {

    public RegisterModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void register(String username,String password,String mobile){

//        {
//            "device": 1,
//                "username": "liuqw1",
//                "password": "123456",
//                "mobile": "17098151355"
//        }

        RequestParams params = new RequestParams(mContext,"register");
        params.put("username",username);
        params.put("password",password);
        params.put("mobile",mobile);
        RetrofitUtils<RegisterResponse> utils = new RetrofitUtils<>(RegisterResponse.class);
        utils.enqueue(params, new RetrofitCallBack<RegisterResponse>() {
            @Override
            public void onResponse(RegisterResponse registerResponse) {
                sendResult(registerResponse);
            }

            @Override
            public void onFailure(RegisterResponse registerResponse, Throwable throwable) {

            }
        });

    }
}
