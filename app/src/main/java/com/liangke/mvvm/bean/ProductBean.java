package com.liangke.mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.liangke.comprehensive.BR;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.http.Body;

/**
 * Created by LK on 2017/12/14.
 */

public class ProductBean extends BaseObservable {


    /**
     * commodityCode : SH124146
     * commodityName : 13海发控
     * createTime : 1514256521000
     * deleted : 2
     * id : 0001e88139494991b1657a797e9df962
     * isTransaction : 0
     * productId : 6cdc65bd2fdd4c4bbe3792ba1af16550
     * tagWord : 13海发控
     */

    private String commodityNo;
    private String commodityName;
    private long createTime;
    private int deleted;
    private String id;
    private int isTransaction;
    private String productId;
    private String tagWord;
    private String exchangeCode;

    private String bid;
    private String change;
    private String chg;
    private String time;

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTagWord() {
        return tagWord;
    }

    public void setTagWord(String tagWord) {
        this.tagWord = tagWord;
    }

    @Bindable
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
        notifyPropertyChanged(BR.bid);
    }

    @Bindable
    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
        notifyPropertyChanged(BR.change);
    }

    @Bindable
    public String getChg() {
        return chg;
    }

    public void setChg(String chg) {
        this.chg = chg;
        notifyPropertyChanged(BR.chg);
    }

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        this.time = format.format(new Date(Long.parseLong(time)));
        notifyPropertyChanged(BR.time);
    }
}
