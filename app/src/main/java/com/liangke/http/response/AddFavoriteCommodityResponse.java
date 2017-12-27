package com.liangke.http.response;

/**
 * Created by LK on 2017/12/26.
 */

public class AddFavoriteCommodityResponse {


    /**
     * code : 200
     * msg : 新增成功
     */

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
