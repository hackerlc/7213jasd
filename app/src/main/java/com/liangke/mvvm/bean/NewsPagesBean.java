package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/22.
 */

public class NewsPagesBean {


    /**
     * authorId : 发布者
     * classifierId : 0
     * classifierName : classifierName
     * content : <p>正文</p>
     * deleted : 2
     * id : AWBt6gCIuxRYrScjbmsr
     * introduction : 简介
     * isVerify : 1
     * issueTime : 1513672537696
     * tagWord : 关,键,词
     * title : 标题
     * verifyTime : 1513672538270
     */

    private String authorId;
    private String classifierId;
    private String classifierName;
    private String content;
    private int deleted;
    private String id;
    private String introduction;
    private int isVerify;
    private long issueTime;
    private String tagWord;
    private String title;
    private long verifyTime;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getClassifierId() {
        return classifierId;
    }

    public void setClassifierId(String classifierId) {
        this.classifierId = classifierId;
    }

    public String getClassifierName() {
        return classifierName;
    }

    public void setClassifierName(String classifierName) {
        this.classifierName = classifierName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(int isVerify) {
        this.isVerify = isVerify;
    }

    public long getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(long issueTime) {
        this.issueTime = issueTime;
    }

    public String getTagWord() {
        return tagWord;
    }

    public void setTagWord(String tagWord) {
        this.tagWord = tagWord;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(long verifyTime) {
        this.verifyTime = verifyTime;
    }
}
