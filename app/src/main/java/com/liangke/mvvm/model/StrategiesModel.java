package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.data.Preferences;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.StrategiesResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 开仓
 */

public class StrategiesModel extends BaseModel {
    public StrategiesModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void strategies(String product,int type,int orderType,String symbol,String amount,String direction,String contractCode,String quitCloseRatio,
                           String price,String tip,String quitLoss,String quitGain,String gainPrincipal,String lossPrincipal,String serviceCharge){

        RequestParams params = new RequestParams(mContext,"strategies");
        params.put("product",product);
        params.put("type",type);
        params.put("orderType",orderType);
        params.put("symbol",symbol);
        params.put("amount",amount);
        params.put("direction",direction);
        params.put("agentCode","");
        params.put("contractCode",contractCode);
        params.put("quitCloseRatio",quitCloseRatio);
        params.put("price",price);
        params.put("tip",tip);
        params.put("quitLoss",quitLoss);
        params.put("quitGain",quitGain);
        params.put("gainPrincipal",gainPrincipal);
        params.put("lossPrincipal",lossPrincipal);
        params.put("serviceCharge",serviceCharge);

        RetrofitUtils<StrategiesResponse> utils = new RetrofitUtils<>(StrategiesResponse.class);
        utils.enqueue(params, new RetrofitCallBack<StrategiesResponse>() {
            @Override
            public void onResponse(StrategiesResponse strategiesResponse) {
                sendResult(strategiesResponse);
            }

            @Override
            public void onFailure(StrategiesResponse strategiesResponse, Throwable throwable) {

            }
        });

    }
}
