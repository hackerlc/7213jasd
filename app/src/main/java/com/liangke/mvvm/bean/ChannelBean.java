package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/18.
 */

public class ChannelBean {

    /**
     * code : DTC
     * createTime : 1513753862000
     * deleted : 2
     * direction : 1
     * exchangeCode : HUOBI
     * exchangeName : 火币
     * id : 089ca86e793b4dcf87a5ade922c5e7ef
     * name : 数字货币
     * providerName : 北京火币天下网络技术有限公司
     */

    private String code;
    private long createTime;
    private int deleted;
    private int direction;
    private String exchangeCode;
    private String exchangeName;
    private String id;
    private String name;
    private String providerName;

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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
