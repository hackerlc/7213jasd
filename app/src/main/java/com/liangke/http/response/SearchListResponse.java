package com.liangke.http.response;

import com.liangke.mvvm.bean.SearchBean;

import java.util.List;

/**
 * Created by LK on 2017/12/21.
 */

public class SearchListResponse {

    /**
     * code : 200
     * data : [{"createTime":1513757867000,"id":"1","keyWord":"关键词","searchNum":1,"searchResult":0,"searchType":1}]
     * msg : 成功
     */

    private int code;
    private String msg;
    private List<SearchBean> data;

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

    public List<SearchBean> getData() {
        return data;
    }

    public void setData(List<SearchBean> data) {
        this.data = data;
    }
}
