package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.CommoditySelectResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 交易品种查询
 */

public class CommodityQueryModel extends BaseModel {
    public CommodityQueryModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void commodityQuery(String classifierId){
        RequestParams params = new RequestParams(mContext,"commodityQuery",2);
        params.put("classifierId",classifierId);
        RetrofitUtils<CommoditySelectResponse> utils = new RetrofitUtils<>(CommoditySelectResponse.class);
        utils.enqueue(params, new RetrofitCallBack<CommoditySelectResponse>() {
            @Override
            public void onResponse(CommoditySelectResponse commoditySelectResponse) {
                sendResult(commoditySelectResponse);
            }

            @Override
            public void onFailure(CommoditySelectResponse commoditySelectResponse, Throwable throwable) {

            }
        });

    }


}
