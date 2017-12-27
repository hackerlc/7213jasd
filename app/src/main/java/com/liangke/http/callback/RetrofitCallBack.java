package com.liangke.http.callback;

import com.liangke.http.response.ResponseBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LK on 2017/12/11.
 */

public interface RetrofitCallBack<T>{

    void onResponse(T t);

    void onFailure(T t, Throwable throwable);

}
