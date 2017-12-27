package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.ProductSelectResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 产品查询
 */

public class ProductQueryModel extends BaseModel {

    public ProductQueryModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void productQuery(){

        RequestParams params = new RequestParams(mContext,"productQuery");

        RetrofitUtils<ProductSelectResponse> utils = new RetrofitUtils<>(ProductSelectResponse.class);
        utils.enqueue(params, new RetrofitCallBack<ProductSelectResponse>() {
            @Override
            public void onResponse(ProductSelectResponse productSelectResponse) {
                sendResult(productSelectResponse);
            }

            @Override
            public void onFailure(ProductSelectResponse productSelectResponse, Throwable throwable) {

            }
        });

    }

}
