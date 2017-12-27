package com.liangke.http.response;

/**
 * Created by LK on 2017/12/14.
 */

public class GetRegisterCodeResponse {

    /**
     * code : 200
     * data : 验证码成功
     * msg : 验证码成功
     */

    private int code;
    private String data;
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
