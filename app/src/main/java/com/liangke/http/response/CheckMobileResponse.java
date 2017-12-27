package com.liangke.http.response;

/**
 * Created by LK on 2017/12/21.
 */

public class CheckMobileResponse {


    /**
     * code : 200
     * data : 手机可用
     */

    private int code;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
