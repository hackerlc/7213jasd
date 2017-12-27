package com.liangke.http.response;

import com.liangke.mvvm.bean.SubjectPagesBean;

import java.util.List;

/**
 * Created by LK on 2017/12/21.
 */

public class SubjectPagesResponse {

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

        private int total;
        private List<SubjectPagesBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<SubjectPagesBean> getRows() {
            return rows;
        }

        public void setRows(List<SubjectPagesBean> rows) {
            this.rows = rows;
        }
    }
}
