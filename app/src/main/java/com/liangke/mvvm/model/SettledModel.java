package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.SettledResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 已结算查询
 */

public class SettledModel extends BaseModel {
    public SettledModel(Context context, Observer observer) {
        super(context, observer);
    }


    public void settled(String product,int type){

        RequestParams params = new RequestParams(mContext,"settled");
        params.put("product",product);
        params.put("type",type);
        params.put("pageSize","5");
        params.put("pageCur","1");
        RetrofitUtils<SettledResponse> utils = new RetrofitUtils<>(SettledResponse.class);
        utils.enqueue(params, new RetrofitCallBack<SettledResponse>() {
            @Override
            public void onResponse(SettledResponse settledResponse) {
                sendResult(settledResponse);
            }

            @Override
            public void onFailure(SettledResponse settledResponse, Throwable throwable) {

            }
        });

    }
}
