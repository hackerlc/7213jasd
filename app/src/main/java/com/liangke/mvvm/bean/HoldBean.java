package com.liangke.mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.liangke.comprehensive.BR;

/**
 * Created by LK on 2017/12/26.
 */

public class HoldBean extends BaseObservable {



    private String bid;
    /**
     * amount : 1
     * buy_deal_price : 1274.8
     * buy_price : 1274.8
     * contract : 1712
     * direction : B
     * exchange : 0e45b673e2ee4c3dbe3f9efb6d1343dd
     * id : bfba53d9c9244b0fbb43224ea8376877
     * orderType : 2
     * provider : f325f5572c30447c914390df30358374
     * quit_close_ratio : 20
     * quit_gain : 1374.8
     * quit_loss : 1272.8
     * status : 4
     * symbol : GC
     * type : 1
     */

    private int amount;
    private double buy_deal_price;
    private double buy_price;
    private String contract;
    private String direction;
    private String exchange;
    private String id;
    private String orderType;
    private String provider;
    private int quit_close_ratio;
    private double quit_gain;
    private double quit_loss;
    private int status;
    private String symbol;
    private int type;


    @Bindable
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
        notifyPropertyChanged(BR.bid);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getBuy_deal_price() {
        return buy_deal_price;
    }

    public void setBuy_deal_price(double buy_deal_price) {
        this.buy_deal_price = buy_deal_price;
    }

    public double getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(double buy_price) {
        this.buy_price = buy_price;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getQuit_close_ratio() {
        return quit_close_ratio;
    }

    public void setQuit_close_ratio(int quit_close_ratio) {
        this.quit_close_ratio = quit_close_ratio;
    }

    public double getQuit_gain() {
        return quit_gain;
    }

    public void setQuit_gain(double quit_gain) {
        this.quit_gain = quit_gain;
    }

    public double getQuit_loss() {
        return quit_loss;
    }

    public void setQuit_loss(double quit_loss) {
        this.quit_loss = quit_loss;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
