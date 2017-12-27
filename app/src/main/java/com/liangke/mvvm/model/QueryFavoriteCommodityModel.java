package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.QueryFavoriteCommodityResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/27.
 */

public class QueryFavoriteCommodityModel extends BaseModel {
    public QueryFavoriteCommodityModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void queryFavoriteCommodity(){
        RequestParams params = new RequestParams(mContext,"queryFavoriteCommodity");
        RetrofitUtils<QueryFavoriteCommodityResponse> utils = new RetrofitUtils<>(QueryFavoriteCommodityResponse.class);
        utils.enqueue(params, new RetrofitCallBack<QueryFavoriteCommodityResponse>() {
            @Override
            public void onResponse(QueryFavoriteCommodityResponse queryFavoriteCommodityResponse) {
                sendResult(queryFavoriteCommodityResponse);
            }

            @Override
            public void onFailure(QueryFavoriteCommodityResponse queryFavoriteCommodityResponse, Throwable throwable) {

            }
        });
    }

}
