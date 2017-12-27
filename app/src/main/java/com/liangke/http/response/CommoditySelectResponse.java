package com.liangke.http.response;

import com.liangke.mvvm.bean.OtherChoiceBean;

import java.util.List;

/**
 * Created by LK on 2017/12/19.
 */

public class CommoditySelectResponse {


    /**
     * code : 200
     * data : [{"classifierId":"7ea0655814d849519c6399c9bd842ba","code":"DF","commodityList":[],"createTime":1513906736000,"direction":0,"exchangeCode":"DLCE","exchangeName":"大连商品交易所","id":"7ea0655814d849519c6399c9bd842ba","isTransaction":1,"name":"国内期货","sort":3,"tradeUnit":"手数"},{"classifierId":"7ea0655814d849519c6399c9bd842ba","code":"DF","commodityList":[],"createTime":1513906326000,"direction":0,"exchangeCode":"SHGX","exchangeName":"上海黄金交易所","id":"9afd0418bdee43dcb119c7c32ccbd732","isTransaction":1,"name":"国内期货","sort":3,"tradeUnit":"手数"},{"classifierId":"7ea0655814d849519c6399c9bd842ba","code":"DF","commodityList":[],"createTime":1513906326000,"direction":0,"exchangeCode":"ZZCE","exchangeName":"郑州商品交易所","id":"9afd0418bdee43dcb119c7c32ccbd7b1","isTransaction":1,"name":"国内期货","sort":3,"tradeUnit":"手数"},{"classifierId":"7ea0655814d849519c6399c9bd842ba","code":"DF","commodityList":[],"createTime":1513906326000,"direction":0,"exchangeCode":"SHFE","exchangeName":"上海期货交易所","id":"9afd0418bdee43dcb119c7c32ccbd7bd","isTransaction":1,"name":"国内期货","sort":3,"tradeUnit":"手数"}]
     * msg : 成功
     */

    private int code;
    private String msg;
    private List<OtherChoiceBean> data;

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

    public List<OtherChoiceBean> getData() {
        return data;
    }

    public void setData(List<OtherChoiceBean> data) {
        this.data = data;
    }


}
