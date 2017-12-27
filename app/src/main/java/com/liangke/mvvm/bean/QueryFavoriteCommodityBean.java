package com.liangke.mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.liangke.comprehensive.BR;
import com.liangke.comprehensive.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LK on 2017/12/27.
 */

public class QueryFavoriteCommodityBean  extends BaseObservable{

    /**
     * commodityCode : etcusdt
     * commodityName : ETC/USDT
     * deleted : 2
     * id : 564b245e08c747879f87b8681c52f4f5
     * isTransaction : 0
     * productId : 089ca86e793b4dcf87a5ade922c5e7ef
     * tagWord : 以太经典
     * userid : 0e01df15de1d45679d8ee7a96fd43d6b
     */

    private String commodityCode;
    private String commodityName;
    private int deleted;
    private String id;
    private int isTransaction;
    private String productId;
    private String tagWord;
    private String userid;


    private String bid;
    private String change;
    private String chg;
    private String time;
    private int img = R.mipmap.icon_arrow_red;

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    @Bindable
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
        notifyPropertyChanged(BR.img);
    }
}
