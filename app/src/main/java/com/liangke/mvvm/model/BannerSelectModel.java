package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.BannerSelectResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 */

public class BannerSelectModel extends BaseModel {


    public BannerSelectModel(Context context, Observer observer) {
        super(context, observer);

    }

    public void bannerSelect(){
        RequestParams params = new RequestParams(mContext,"bannerSelect");
        RetrofitUtils<BannerSelectResponse> utils = new RetrofitUtils<>(BannerSelectResponse.class);
        utils.enqueue(params, new RetrofitCallBack<BannerSelectResponse>() {
            @Override
            public void onResponse(BannerSelectResponse bannerSelectResponse) {
                sendResult(bannerSelectResponse);
            }

            @Override
            public void onFailure(BannerSelectResponse bannerSelectResponse, Throwable throwable) {

            }
        });
    }
}
