package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.NewsPagesResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/22.
 */

public class NewsPagesModel extends BaseModel {
    public NewsPagesModel(Context context, Observer observer) {
        super(context, observer);
    }



    public void newsPages(String classifierId,String keyWord){

        RequestParams params = new RequestParams(mContext,"newsPages");
        params.put("keyWord",keyWord);
        params.put("classifierId",classifierId);
        params.put("pageNo","1");
        params.put("pageSize","20");
        RetrofitUtils<NewsPagesResponse> utils = new RetrofitUtils<>(NewsPagesResponse.class);
        utils.enqueue(params, new RetrofitCallBack<NewsPagesResponse>() {
            @Override
            public void onResponse(NewsPagesResponse newsPagesResponse) {
                sendResult(newsPagesResponse);
            }

            @Override
            public void onFailure(NewsPagesResponse newsPagesResponse, Throwable throwable) {

            }
        });
    }
}
