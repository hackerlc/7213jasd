package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.CommodityPagesResponse;
import com.liangke.http.response.CommoditySelectResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/27.
 */

public class CommodityPagesModel extends BaseModel {
    public CommodityPagesModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void commodityPages(String productId){
//        pageNo：页码
//        pageSize：每页大小
//        productId：交易所id
        RequestParams params = new RequestParams(mContext,"commodityPages");
        params.put("pageNo","1");
        params.put("pageSize","20");
        params.put("productId",productId);
        RetrofitUtils<CommodityPagesResponse> utils = new RetrofitUtils<>(CommodityPagesResponse.class);
        utils.enqueue(params, new RetrofitCallBack<CommodityPagesResponse>() {
            @Override
            public void onResponse(CommodityPagesResponse commodityPagesResponse) {
                sendResult(commodityPagesResponse);
            }

            @Override
            public void onFailure(CommodityPagesResponse commodityPagesResponse, Throwable throwable) {

            }
        });

    }

}
