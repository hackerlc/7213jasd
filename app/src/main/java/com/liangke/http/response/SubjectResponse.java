package com.liangke.http.response;

import com.liangke.mvvm.bean.SubjectBean;

import java.util.List;

/**
 * Created by LK on 2017/12/22.
 */

public class SubjectResponse {

    /**
     * code : 200
     * data : {"rows":[{"createTime":1513686302000,"deleted":2,"id":"1","subjectBanner":"https://cdn.jin10.com/pic/7b/6245f96e05921fa140fc1d5539208a15.png","title":"专题1"}],"total":1}
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
         * rows : [{"createTime":1513686302000,"deleted":2,"id":"1","subjectBanner":"https://cdn.jin10.com/pic/7b/6245f96e05921fa140fc1d5539208a15.png","title":"专题1"}]
         * total : 1
         */

        private int total;
        private List<SubjectBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<SubjectBean> getRows() {
            return rows;
        }

        public void setRows(List<SubjectBean> rows) {
            this.rows = rows;
        }
    }
}
