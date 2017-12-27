package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.HoldResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 持仓查询
 */

public class HoldModel extends BaseModel {
    public HoldModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void hold(String product,int type){

        RequestParams params = new RequestParams(mContext,"hold");
        params.put("product",product);
        params.put("type",type);
        params.put("pageSize","5");
        params.put("pageCur","1");
        RetrofitUtils<HoldResponse> utils = new RetrofitUtils<>(HoldResponse.class);
        utils.enqueue(params, new RetrofitCallBack<HoldResponse>() {
            @Override
            public void onResponse(HoldResponse holdResponse) {
                sendResult(holdResponse);
            }

            @Override
            public void onFailure(HoldResponse holdResponse, Throwable throwable) {

            }
        });

    }
}
