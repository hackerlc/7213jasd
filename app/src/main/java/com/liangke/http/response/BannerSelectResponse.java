package com.liangke.http.response;

import com.liangke.mvvm.bean.BannerBean;

import java.util.List;

/**
 * Created by LK on 2017/12/21.
 */

public class BannerSelectResponse {

    /**
     * code : 200
     * data : [{"bannerUrl":"http://baidu.com/","beginTime":1513689875000,"contentUrl":"http://baidu.com/","createTime":1513689875000,"deleted":2,"id":"4c79465dfcf44f7d940a5afc0f3c6d80","position":1,"sort":1,"title":"开户好礼"}]
     * msg : 成功
     */

    private int code;
    private String msg;
    private List<BannerBean> data;

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

    public List<BannerBean> getData() {
        return data;
    }

    public void setData(List<BannerBean> data) {
        this.data = data;
    }
}
