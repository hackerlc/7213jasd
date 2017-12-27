package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/22.
 */

public class NewsclassifierBean {

    /**
     * createTime : 1513680131000
     * deleted : 2
     * id : 201f0e191bb44c9b9020ed9e1c589446
     * name : 期货
     * sort : 1
     */

    private long createTime;
    private int deleted;
    private String id;
    private String name;
    private int sort;

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
