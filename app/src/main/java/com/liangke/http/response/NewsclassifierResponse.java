package com.liangke.http.response;

import com.liangke.mvvm.bean.NewsclassifierBean;

import java.util.List;

/**
 * Created by LK on 2017/12/22.
 */

public class NewsclassifierResponse {

    /**
     * code : 200
     * data : [{"createTime":1513680131000,"deleted":2,"id":"201f0e191bb44c9b9020ed9e1c589446","name":"期货","sort":1}]
     * msg : 成功
     */

    private int code;
    private String msg;
    private List<NewsclassifierBean> data;

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

    public List<NewsclassifierBean> getData() {
        return data;
    }

    public void setData(List<NewsclassifierBean> data) {
        this.data = data;
    }
}
