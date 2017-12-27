package com.liangke.http.request;

import android.content.Context;
import android.provider.SyncStateContract;

import com.liangke.constants.Constants;
import com.liangke.data.Preferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Created by LK on 2017/12/11.
 */

public class RequestParams {
    private Context mContext;
    private Map<String,Object> map = new HashMap();
    private String method = null;
    private int apiType = 0;//1:炜刚；2：龙哥
    public RequestParams(Context context,String method) {
        mContext = context;
        this.method = method;
        map.put("device", Constants.device);
        String token = Preferences.getInstance(mContext).getToken()==null?"C0EC5CED621DC2C384E0A44FE777E24C":Preferences.getInstance(mContext).getToken();
        map.put("token", token);
    }

    public RequestParams(Context context,String method,int apiType) {
        mContext = context;
        this.method = method;
        this.apiType = apiType;
        map.put("device", Constants.device);
        String token = Preferences.getInstance(mContext).getToken()==null?"C0EC5CED621DC2C384E0A44FE777E24C":Preferences.getInstance(mContext).getToken();
        map.put("token", token);
    }

    public void put(String key,Object value){
        map.put(key,value);
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Context getmContext() {
        return mContext;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getApiType() {
        return apiType;
    }

    public void setApiType(int apiType) {
        this.apiType = apiType;
    }
}
