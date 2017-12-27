package com.liangke.mvvm.bean;

/**
 * Created by LK on 2017/12/21.
 */

public class SearchBean {


    /**
     * createTime : 1513757867000
     * id : 1
     * keyWord : 关键词
     * searchNum : 1
     * searchResult : 0
     * searchType : 1
     */

    private long createTime;
    private String id;
    private String keyWord;
    private int searchNum;
    private int searchResult;
    private int searchType;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(int searchNum) {
        this.searchNum = searchNum;
    }

    public int getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(int searchResult) {
        this.searchResult = searchResult;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }
}
