package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.SearchListResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 * 搜索列表
 */

public class SearchListModel extends BaseModel {

    public static final int KIND = 0;
    public static final int INFORMATION = 1;

    public SearchListModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void searchlist(int searchType){
        //searchType：搜索类别,0:搜索交易品种，1：搜索资讯
        RequestParams params = new RequestParams(mContext,"searchlist");
        params.put("searchType",searchType);
        RetrofitUtils<SearchListResponse> utils = new RetrofitUtils<>(SearchListResponse.class);
        utils.enqueue(params, new RetrofitCallBack<SearchListResponse>() {
            @Override
            public void onResponse(SearchListResponse searchListResponse) {
                sendResult(searchListResponse);
            }

            @Override
            public void onFailure(SearchListResponse searchListResponse, Throwable throwable) {

            }
        });
    }

}
