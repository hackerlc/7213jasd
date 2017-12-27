package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/21.
 */

public class SubjectPagesBean {

    /**
     * authorId : 发布者
     * classifierId : 0
     * classifierName : classifierName
     * commentCount : 2
     * deleted : 2
     * id : 05ab35e9f6324f438f506a5fa049e608
     * introduction : 简介
     * isVerify : 1
     * issueTime : 1513670225000
     * tagWord : 关,键,词
     * title : 标题
     * verifyTime : 1513670225000
     * voteCount : 1
     */

    private String authorId;
    private String classifierId;
    private String classifierName;
    private int commentCount;
    private int deleted;
    private String id;
    private String introduction;
    private int isVerify;
    private long issueTime;
    private String tagWord;
    private String title;
    private long verifyTime;
    private int voteCount;

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

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
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

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
