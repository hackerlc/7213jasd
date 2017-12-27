package com.liangke.http.response;

import com.liangke.mvvm.bean.ProductSelectBean;

import java.util.List;

/**
 * Created by LK on 2017/12/19.
 */

public class ProductSelectResponse {


    /**
     * code : 200
     * data : [{"code":"DTC","createTime":1513906234000,"deleted":2,"id":"089ca86e793b4dcf87a5ade922c5e7ef","name":"数字货币","sort":6},{"code":"STOCK","createTime":1513906234000,"deleted":2,"id":"6cdc65bd2fdd4c4bbe3792ba1af16550","name":"沪深","sort":1},{"code":"DF","createTime":1513906234000,"deleted":2,"id":"7ea0655814d849519c6399c9bd842ba","name":"国内期货","sort":4},{"code":"FF","createTime":1513906234000,"deleted":2,"id":"9afd0418bdee43dcb119c7c32ccb27bd","name":"外盘期货","sort":5},{"code":"SI","createTime":1513906234000,"deleted":2,"id":"9afd0418bdee43dcb119c7c32ccbd1b0","name":"股指","sort":3},{"code":"AHKS","createTime":1513906234000,"deleted":2,"id":"9afd0418bdee43dcb119c7c32ccbd7s3","name":"美港股","sort":2}]
     * msg : 成功
     */

    private int code;
    private String msg;
    private List<ProductSelectBean> data;

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

    public List<ProductSelectBean> getData() {
        return data;
    }

    public void setData(List<ProductSelectBean> data) {
        this.data = data;
    }


}
