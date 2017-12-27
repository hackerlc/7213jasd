package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/21.
 */

public class BannerBean {

    /**
     * bannerUrl : http://baidu.com/
     * beginTime : 1513689875000
     * contentUrl : http://baidu.com/
     * createTime : 1513689875000
     * deleted : 2
     * id : 4c79465dfcf44f7d940a5afc0f3c6d80
     * position : 1
     * sort : 1
     * title : 开户好礼
     */

    private String bannerUrl;
    private long beginTime;
    private String contentUrl;
    private long createTime;
    private int deleted;
    private String id;
    private int position;
    private int sort;
    private String title;

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
