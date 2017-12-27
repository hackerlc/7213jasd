package com.liangke.http.response;

import com.liangke.mvvm.bean.QueryFavoriteCommodityBean;

import java.util.List;

/**
 * Created by LK on 2017/12/27.
 */

public class QueryFavoriteCommodityResponse {


    /**
     * code : 200
     * data : [{"commodityCode":"etcusdt","commodityName":"ETC/USDT","deleted":2,"id":"564b245e08c747879f87b8681c52f4f5","isTransaction":0,"productId":"089ca86e793b4dcf87a5ade922c5e7ef","tagWord":"以太经典","userid":"0e01df15de1d45679d8ee7a96fd43d6b"},{"commodityCode":"etcusdt","commodityName":"ETC/USDT","deleted":2,"id":"21c99509affd4d9989720205757c5e82","isTransaction":0,"productId":"089ca86e793b4dcf87a5ade922c5e7ef","tagWord":"以太经典","userid":"0e01df15de1d45679d8ee7a96fd43d6b"},{"commodityCode":"SH124146","commodityName":"13海发控","createTime":1514256521000,"deleted":2,"id":"bdc92f7813384a79a16596b2065d3580","isTransaction":0,"productId":"6cdc65bd2fdd4c4bbe3792ba1af16550","tagWord":"13海发控","userid":"0e01df15de1d45679d8ee7a96fd43d6b"}]
     * msg : 新增成功
     */

    private int code;
    private String msg;
    private List<QueryFavoriteCommodityBean> data;

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

    public List<QueryFavoriteCommodityBean> getData() {
        return data;
    }

    public void setData(List<QueryFavoriteCommodityBean> data) {
        this.data = data;
    }


}
