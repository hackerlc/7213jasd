package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.GetRegisterCodeResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/14.
 */

public class GetRegisterCodeModel extends BaseModel {

    public GetRegisterCodeModel(Context context,Observer observer) {
        super(context,observer);
    }

    public void getRegisterCode(String phone){

        RequestParams params = new RequestParams(mContext,"getRegisterCode");
        params.put("mobile",phone);
        RetrofitUtils<GetRegisterCodeResponse> utils = new RetrofitUtils<>(GetRegisterCodeResponse.class);
        utils.enqueue(params, new RetrofitCallBack<GetRegisterCodeResponse>() {
            @Override
            public void onResponse(GetRegisterCodeResponse getRegisterCodeResponse) {
                sendResult(getRegisterCodeResponse);
            }

            @Override
            public void onFailure(GetRegisterCodeResponse getRegisterCodeResponse, Throwable throwable) {

            }
        });

    }

}
