package com.liangke.mvvm.model;

import android.content.Context;

import com.liangke.base.BaseModel;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.LineGainLossResponse;
import com.liangke.http.retrofit.RetrofitUtils;

import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/19.
 * 修改止盈止损
 */

public class LineGainLossModel extends BaseModel {
    public LineGainLossModel(Context context, Observer observer) {
        super(context, observer);
    }

    public void lineGainLoss(String product,String type,String id,String orderType,String quitLoss,String quitGain){

        RequestParams params = new RequestParams(mContext,"lineGainLoss");
        params.put("product",product);
        params.put("type",type);
        params.put("id",id);
        params.put("orderType",orderType);
        params.put("quitLoss",quitLoss);
        params.put("quitGain",quitGain);
        RetrofitUtils<LineGainLossResponse> utils = new RetrofitUtils<>(LineGainLossResponse.class);
        utils.enqueue(params, new RetrofitCallBack<LineGainLossResponse>() {
            @Override
            public void onResponse(LineGainLossResponse lineGainLossResponse) {
                sendResult(lineGainLossResponse);
            }

            @Override
            public void onFailure(LineGainLossResponse lineGainLossResponse, Throwable throwable) {

            }
        });

    }
}
