package com.liangke.http.service;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Joker on 2017/12/11.
 */

public interface ApiService2 {

    //查询动态(社区)列表
    @POST("/topics/list")
    Call<String> fetchTopics(@Body Map<String, Object> map);

}
