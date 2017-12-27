package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.NewsPagesResponse;
import com.liangke.http.response.TopicsResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by Joker on 2017/12/22.
 */

public class TopicsPagesModel extends BaseModel {
    public TopicsPagesModel(Context context, Observer observer) {
        super(context, observer);
    }

    /**
     * 查询动态(社区)列表
     * @param isTopic true 表示动态 false 表示快讯
     * @param page 第几页
     */
    public void fetchTopics(boolean isTopic,int page){

        RequestParams params = new RequestParams(mContext,"fetchTopics");
        params.put("is_topic",isTopic?1:2);
        params.put("product","0e45b673e2ee4c3dbe3f9efb6d1343dd");
        params.put("pageCur",page);
        params.put("pageSize","20");
        RetrofitUtils<TopicsResponse> utils = new RetrofitUtils<>(TopicsResponse.class);
        utils.enqueue(params, new RetrofitCallBack<TopicsResponse>() {
            @Override
            public void onResponse(TopicsResponse newsPagesResponse) {
                sendResult(newsPagesResponse);
            }

            @Override
            public void onFailure(TopicsResponse newsPagesResponse, Throwable throwable) {

            }
        });
    }
}
