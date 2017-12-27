package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.SubjectResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/22.
 */

public class SubjectModel extends BaseModel {
    public SubjectModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void subject(){
//        pageNo：页码，
//        pageSize：页大小
        RequestParams params = new RequestParams(mContext,"subject");
        params.put("pageNo","1");
        params.put("pageSize","20");
        RetrofitUtils<SubjectResponse> utils = new RetrofitUtils<>(SubjectResponse.class);
        utils.enqueue(params, new RetrofitCallBack<SubjectResponse>() {
            @Override
            public void onResponse(SubjectResponse subjectResponse) {
                sendResult(subjectResponse);
            }

            @Override
            public void onFailure(SubjectResponse subjectResponse, Throwable throwable) {

            }
        });

    }
}
