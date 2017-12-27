package com.liangke.http.response;

import java.util.List;

/**
 * Created by LK on 2017/12/15.
 */

public class HistoryResponse {


    /**
     * code : 200
     * msg : 成功
     * data : [{"id":"afbd9d3fce964c4ab1a8b55f7a6d7ab2","commodityNo":"EURAUD","contractNo":"","time":1513303800000,"open":1.5367300510406494,"close":1.536769986152649,"high":1.5368000268936157,"low":1.5367300510406494,"volume":0,"amount":0,"createTime":1513303945000,"deleted":2},{"id":"f8c5113aa5fc43289fff3ca7db19f928","commodityNo":"EURAUD","contractNo":"","time":1513303860000,"open":1.5368200540542603,"close":1.5367799997329712,"high":1.5368200540542603,"low":1.5368200540542603,"volume":0,"amount":0,"createTime":1513303945000,"deleted":2}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : afbd9d3fce964c4ab1a8b55f7a6d7ab2
         * commodityNo : EURAUD
         * contractNo :
         * time : 1513303800000
         * open : 1.5367300510406494
         * close : 1.536769986152649
         * high : 1.5368000268936157
         * low : 1.5367300510406494
         * volume : 0
         * amount : 0
         * createTime : 1513303945000
         * deleted : 2
         */

        private String id;
        private String commodityNo;
        private String contractNo;
        private long time;
        private double open;
        private double close;
        private double high;
        private double low;
        private int volume;
        private int amount;
        private long createTime;
        private int deleted;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCommodityNo() {
            return commodityNo;
        }

        public void setCommodityNo(String commodityNo) {
            this.commodityNo = commodityNo;
        }

        public String getContractNo() {
            return contractNo;
        }

        public void setContractNo(String contractNo) {
            this.contractNo = contractNo;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public double getOpen() {
            return open;
        }

        public void setOpen(double open) {
            this.open = open;
        }

        public double getClose() {
            return close;
        }

        public void setClose(double close) {
            this.close = close;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
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
    }
}
