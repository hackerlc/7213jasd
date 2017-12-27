package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.NewsclassifierResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/22.
 * 获取栏目分类
 */

public class NewsclassifierModel extends BaseModel {
    public NewsclassifierModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void newsclassifier(){
        RequestParams params = new RequestParams(mContext,"newsclassifier");
        params.put("position","2");
        RetrofitUtils<NewsclassifierResponse> utils = new RetrofitUtils<>(NewsclassifierResponse.class);
        utils.enqueue(params, new RetrofitCallBack<NewsclassifierResponse>() {
            @Override
            public void onResponse(NewsclassifierResponse newsclassifierResponse) {
                sendResult(newsclassifierResponse);
            }

            @Override
            public void onFailure(NewsclassifierResponse newsclassifierResponse, Throwable throwable) {

            }
        });
    }

}
