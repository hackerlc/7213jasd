package com.liangke.http.service;

import com.liangke.chart.MA;
import com.liangke.http.response.StrategiesResponse;
import com.liangke.mvvm.model.StrategiesModel;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by LK on 2017/12/11.
 */

public interface ApiService {

    @GET("/historyWeather/province")
    Call<String> province(@QueryMap Map<String,Object> map);


    @POST("/sms/getRegisterCode")
    Call<String> getRegisterCode(@Body Map<String,Object> map);

    @POST("/user/login")
    Call<String> login(@Body Map<String,Object> map);


    @GET("/quote/history")
    Call<String> history(@QueryMap Map<String,Object> map);

    //行情分类
    @GET("/product/classifier/list")
    Call<String> productQuery(@QueryMap Map<String,Object> map);

    //产品列表
    @POST("/product/list")
    Call<String> commodityQuery(@Body Map<String,Object> map);

    //开仓
    @POST("/strategies")
    Call<String> strategies(@Body Map<String,Object> map);

    //平仓
    @POST("/strategies/close")
    Call<String> close(@Body Map<String,Object> map);

    //修改止损止盈
    @POST("/strategies/lineGainLoss")
    Call<String> lineGainLoss(@Body Map<String,Object> map);

    //持仓查询
    @POST("/strategies/hold")
    Call<String> hold(@Body Map<String,Object> map);

    //已结算查询
    @POST("/strategies/settled")
    Call<String> settled(@Body Map<String,Object> map);

    //检验短信验证码
    @POST("/user/checkMobile")
    Call<String> checkMobile(@Body Map<String,Object> map);


    //用户注册
    @POST("/user/register")
    Call<String> register(@Body Map<String,Object> map);

    //搜索
    @POST("/word/search/list")
    Call<String> searchlist(@Body Map<String,Object> map);

    //banner图
    @GET("/banner/select")
    Call<String> bannerSelect(@QueryMap Map<String,Object> map);

    //专题咨询查询
    @POST("/news/subject/pages")
    Call<String> subjectPages(@Body Map<String,Object> map);

    //专题查询接口
    @POST("/subject/pages")
    Call<String> subject(@Body Map<String,Object> map);

    //获取首页栏目分类
    @GET("/newsclassifier/select")
    Call<String> newsclassifier(@QueryMap Map<String,Object> map);


    //咨询搜索
    @POST("/es/news/pages")
    Call<String> newsPages(@Body Map<String,Object> map);

    //新增用户收藏产品
    @POST("/user/addFavoriteCommodity")
    Call<String> addFavoriteCommodity(@Body Map<String,Object> map);

    //查询用户收藏产品接口
    @POST("/user/queryFavoriteCommodity")
    Call<String> queryFavoriteCommodity(@Body Map<String,Object> map);

    //查看更多交易品种
    @POST("/commodity/pages")
    Call<String> commodityPages(@Body Map<String,Object> map);



}
