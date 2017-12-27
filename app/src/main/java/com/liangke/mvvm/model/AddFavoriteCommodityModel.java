package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.AddFavoriteCommodityResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/26.
 */

public class AddFavoriteCommodityModel extends BaseModel {
    public AddFavoriteCommodityModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void addFavoriteCommodity(String productId,String commodityNo){
//        productId:交易所id
//        commodityNo:交易品种
//        token: 用户令牌
        RequestParams params = new RequestParams(mContext,"addFavoriteCommodity");
        params.put("productId",productId);
        params.put("commodityNo",commodityNo);
        RetrofitUtils<AddFavoriteCommodityResponse> utils = new RetrofitUtils<>(AddFavoriteCommodityResponse.class);
        utils.enqueue(params, new RetrofitCallBack<AddFavoriteCommodityResponse>() {
            @Override
            public void onResponse(AddFavoriteCommodityResponse addFavoriteCommodityResponse) {
                sendResult(addFavoriteCommodityResponse);
            }

            @Override
            public void onFailure(AddFavoriteCommodityResponse addFavoriteCommodityResponse, Throwable throwable) {

            }
        });


    }

}
