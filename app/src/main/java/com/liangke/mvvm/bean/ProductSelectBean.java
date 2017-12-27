package com.liangke.mvvm.bean;

import java.io.Serializable;

/**
 * Created by LK on 2017/12/18.
 */

public class ProductSelectBean implements Serializable{


    /**
     * code : DTC
     * createTime : 1513906234000
     * deleted : 2
     * id : 089ca86e793b4dcf87a5ade922c5e7ef
     * name : 数字货币
     * sort : 6
     */

    private String code;
    private long createTime;
    private int deleted;
    private String id;
    private String name;
    private int sort;

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
