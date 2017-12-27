package com.liangke.http.response;

import com.liangke.mvvm.bean.NewsclassifierBean;
import com.liangke.mvvm.bean.TopicBean;

import java.util.List;

/**
 * Created by LK on 2017/12/22.
 */

public class TopicsResponse {

    /**
     * code : 200
     * msg : 成功
     */

    private int code;
    private String msg;
    private List<TopicBean> data;

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

    public List<TopicBean> getData() {
        return data;
    }

    public void setData(List<TopicBean> data) {
        this.data = data;
    }
}
