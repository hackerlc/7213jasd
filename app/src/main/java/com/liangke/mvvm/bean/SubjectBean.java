package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/22.
 */

public class SubjectBean {

    /**
     * createTime : 1513686302000
     * deleted : 2
     * id : 1
     * subjectBanner : https://cdn.jin10.com/pic/7b/6245f96e05921fa140fc1d5539208a15.png
     * title : 专题1
     */

    private long createTime;
    private int deleted;
    private String id;
    private String subjectBanner;
    private String title;

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

    public String getSubjectBanner() {
        return subjectBanner;
    }

    public void setSubjectBanner(String subjectBanner) {
        this.subjectBanner = subjectBanner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
