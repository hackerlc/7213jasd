package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.CloseResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import org.json.JSONArray;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 平仓
 */

public class CloseModel extends BaseModel {
    public CloseModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void close(String product, int type, int orderType, JSONArray items){

        RequestParams params = new RequestParams(mContext,"close");
        params.put("product",product);
        params.put("type",type);
        params.put("orderType",orderType);
        params.put("items",items);
        RetrofitUtils<CloseResponse> utils = new RetrofitUtils<>(CloseResponse.class);
        utils.enqueue(params, new RetrofitCallBack<CloseResponse>() {
            @Override
            public void onResponse(CloseResponse closeResponse) {
                sendResult(closeResponse);
            }

            @Override
            public void onFailure(CloseResponse closeResponse, Throwable throwable) {

            }
        });

    }

}
