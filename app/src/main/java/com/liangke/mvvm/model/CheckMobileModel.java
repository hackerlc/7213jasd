package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.CheckMobileResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 * 检验短信验证码
 */

public class CheckMobileModel extends BaseModel {
    public CheckMobileModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void checkMobile(String mobile,String checkCode){

        RequestParams params = new RequestParams(mContext,"checkMobile");
        params.put("mobile",mobile);
        params.put("checkCode",checkCode);
        RetrofitUtils<CheckMobileResponse> utils = new RetrofitUtils<>(CheckMobileResponse.class);
        utils.enqueue(params, new RetrofitCallBack<CheckMobileResponse>() {
            @Override
            public void onResponse(CheckMobileResponse checkMobileResponse) {
                sendResult(checkMobileResponse);
            }

            @Override
            public void onFailure(CheckMobileResponse checkMobileResponse, Throwable throwable) {

            }
        });

    }
}
