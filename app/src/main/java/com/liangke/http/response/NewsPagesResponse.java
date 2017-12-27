package com.liangke.http.response;

import com.liangke.mvvm.bean.NewsPagesBean;

import java.util.List;

/**
 * Created by LK on 2017/12/22.
 */

public class NewsPagesResponse {


    /**
     * code : 200
     * data : {"rows":[{"authorId":"发布者","classifierId":"0","classifierName":"classifierName","content":"<p>正文<\/p>","deleted":2,"id":"AWBt6gCIuxRYrScjbmsr","introduction":"简介","isVerify":1,"issueTime":1513672537696,"tagWord":"关,键,词","title":"标题","verifyTime":1513672538270},{"authorId":"发布者","classifierId":"0","classifierName":"classifierName","content":"<p>正文<\/p>","deleted":2,"id":"AWBt6YVjuxRYrScjbmsq","introduction":"简介","isVerify":1,"issueTime":1513672463240,"tagWord":"关,键,词","title":"标题","verifyTime":1513672464066},{"authorId":"发布者","classifierId":"0","classifierName":"classifierName","content":"<p>正文<\/p>","deleted":2,"id":"AWBt5_4uuxRYrScjbmsp","introduction":"简介","isVerify":1,"issueTime":1513672387321,"tagWord":"关,键,词","title":"标题","verifyTime":1513672388328}],"total":18}
     * msg : 成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * rows : [{"authorId":"发布者","classifierId":"0","classifierName":"classifierName","content":"<p>正文<\/p>","deleted":2,"id":"AWBt6gCIuxRYrScjbmsr","introduction":"简介","isVerify":1,"issueTime":1513672537696,"tagWord":"关,键,词","title":"标题","verifyTime":1513672538270},{"authorId":"发布者","classifierId":"0","classifierName":"classifierName","content":"<p>正文<\/p>","deleted":2,"id":"AWBt6YVjuxRYrScjbmsq","introduction":"简介","isVerify":1,"issueTime":1513672463240,"tagWord":"关,键,词","title":"标题","verifyTime":1513672464066},{"authorId":"发布者","classifierId":"0","classifierName":"classifierName","content":"<p>正文<\/p>","deleted":2,"id":"AWBt5_4uuxRYrScjbmsp","introduction":"简介","isVerify":1,"issueTime":1513672387321,"tagWord":"关,键,词","title":"标题","verifyTime":1513672388328}]
         * total : 18
         */

        private int total;
        private List<NewsPagesBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<NewsPagesBean> getRows() {
            return rows;
        }

        public void setRows(List<NewsPagesBean> rows) {
            this.rows = rows;
        }
    }
}
