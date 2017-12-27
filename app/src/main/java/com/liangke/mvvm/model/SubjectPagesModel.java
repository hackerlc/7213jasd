package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.SubjectPagesResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/21.
 * 主题咨询查询
 */

public class SubjectPagesModel extends BaseModel {
    public SubjectPagesModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void subjectPages(String subjectId){

        RequestParams params = new RequestParams(mContext,"subjectPages");
        params.put("pageNo","1");
        params.put("pageSize","20");
        params.put("subjectId",subjectId);
        RetrofitUtils<SubjectPagesResponse> utils = new RetrofitUtils<>(SubjectPagesResponse.class);
        utils.enqueue(params, new RetrofitCallBack<SubjectPagesResponse>() {
            @Override
            public void onResponse(SubjectPagesResponse subjectPagesResponse) {
                sendResult(subjectPagesResponse);
            }

            @Override
            public void onFailure(SubjectPagesResponse subjectPagesResponse, Throwable throwable) {

            }
        });

    }
}
