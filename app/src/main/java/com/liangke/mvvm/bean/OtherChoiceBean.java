package com.liangke.mvvm.bean;

import android.databinding.BaseObservable;

import java.util.List;

/**
 * Created by LK on 2017/12/14.
 */

public class OtherChoiceBean extends BaseObservable {


    /**
     * classifierId : 089ca86e793b4dcf87a5ade922c5e7ef
     * code : DTC
     * commodityList : [{"commodityCode":"etcusdt","commodityName":"ETC/USDT","deleted":2,"id":"0c0decbf6919462a865967951ec80dab","isTransaction":0,"productId":"089ca86e793b4dcf87a5ade922c5e7ef","tagWord":"以太经典"},{"commodityCode":"ethusdt","commodityName":"ETH/USDT","deleted":2,"id":"386b197750c94a0a9df6d51dccb2539e","isTransaction":0,"productId":"089ca86e793b4dcf87a5ade922c5e7ef","tagWord":"以太坊"},{"commodityCode":"btcusdt","commodityName":"BTC/USDT","deleted":2,"id":"76fa7c911cc84488ad84a55051c44111","isTransaction":0,"productId":"089ca86e793b4dcf87a5ade922c5e7ef","tagWord":"比特币"},{"commodityCode":"ltcusdt","commodityName":"LTC/USDT","createTime":1513599685000,"deleted":2,"id":"fa9d25a70b214c6f9dad05196406f3b0","isTransaction":0,"productId":"089ca86e793b4dcf87a5ade922c5e7ef","tagWord":"莱特币"}]
     * createTime : 1513906248000
     * direction : 1
     * exchangeCode : HUOBI
     * exchangeName : 火币
     * id : 089ca86e793b4dcf87a5ade922c5e7ef
     * isTransaction : 1
     * name : 数字货币
     * sort : 5
     * tradeUnit : 个数
     */

    private String classifierId;
    private String code;
    private long createTime;
    private int direction;
    private String exchangeCode;
    private String exchangeName;
    private String id;
    private int isTransaction;
    private String name;
    private int sort;
    private String tradeUnit;
    private List<ProductBean> commodityList;

    public String getClassifierId() {
        return classifierId;
    }

    public void setClassifierId(String classifierId) {
        this.classifierId = classifierId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsTransaction() {
        return isTransaction;
    }

    public void setIsTransaction(int isTransaction) {
        this.isTransaction = isTransaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTradeUnit() {
        return tradeUnit;
    }

    public void setTradeUnit(String tradeUnit) {
        this.tradeUnit = tradeUnit;
    }

    public List<ProductBean> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<ProductBean> commodityList) {
        this.commodityList = commodityList;
    }


}
