package com.liangke.mvvm.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.liangke.base.BaseModel;
import com.liangke.constants.Constants;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.HistoryResponse;
import com.liangke.http.retrofit.RetrofitUtils;
import com.liangke.http.retrofit.StringConverterFactory;
import com.liangke.http.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by LK on 2017/12/15.
 */

public class HistoryModel extends BaseModel {


    public static String CONTAINER_ONE_MIN = "CONTAINER_ONE_MIN";//1分
    public static String CONTAINER_THREE_MIN = "CONTAINER_THREE_MIN";//3分
    public static String CONTAINER_FIVE_MIN = "CONTAINER_FIVE_MIN";//5分
    public static String CONTAINER_FIFTEEN_MIN = "CONTAINER_FIFTEEN_MIN";//15分
    public static String CONTAINER_THIRTY_MIN = "CONTAINER_THIRTY_MIN";//30分
    public static String CONTAINER_DAY = "CONTAINER_DAY";//1天
    public static String CONTAINER_WEEK = "CONTAINER_WEEK";//1周
    public static String CONTAINER_MONTH = "CONTAINER_MONTH";//1月

    public static List<String> typeList = new ArrayList<>();

    static {
        typeList.add(CONTAINER_ONE_MIN);
        typeList.add(CONTAINER_THREE_MIN);
        typeList.add(CONTAINER_FIVE_MIN);
        typeList.add(CONTAINER_FIFTEEN_MIN);
        typeList.add(CONTAINER_THIRTY_MIN);
        typeList.add(CONTAINER_DAY);
        typeList.add(CONTAINER_WEEK);
        typeList.add(CONTAINER_MONTH);
    }

    public HistoryModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void history(String klineType,String productId,String commodityNo,String begin,long end,String contractNo){
        RequestParams params = new RequestParams(mContext,"history");
        params.put("klineType",klineType);
        params.put("commodityNo",commodityNo);
        params.put("productId",productId);
        params.put("begin",begin);
        params.put("end",end);
        params.put("contractNo",contractNo);
        Log.i("MyRetrofit",">>>===onRequest=="+params.getMap().toString());
//        RetrofitUtils<HistoryResponse> utils = new RetrofitUtils<>(HistoryResponse.class);
//        utils.enqueue(params, new RetrofitCallBack<HistoryResponse>() {
//            @Override
//            public void onResponse(HistoryResponse historyResponse) {
//                sendResult(historyResponse);
//            }
//
//            @Override
//            public void onFailure(HistoryResponse historyResponse, Throwable throwable) {
//
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.HistoryURL).addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<String> call = service.history(params.getMap());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("MyRetrofit",">>>===onResponse=="+response.body());
                HistoryResponse historyResponse = new Gson().fromJson(response.body(), HistoryResponse.class);
                sendResult(historyResponse);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
