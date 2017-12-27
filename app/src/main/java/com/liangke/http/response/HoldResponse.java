package com.liangke.http.response;

import com.liangke.mvvm.bean.HoldBean;

import java.util.List;

/**
 * Created by LK on 2017/12/19.
 */

public class HoldResponse {


    /**
     * code : 200
     * data : {"rows":[{"amount":1,"buyPriceDeal":27.5,"commodityNo":"etcusdt","contractNo":"","direction":"B","id":"181559ed70a64bf789fddc8b2ee88540","orderType":"2","status":4,"type":1},{"amount":1,"buyPriceDeal":265,"buyPriceOrder":1274.8,"commodityNo":"ltcusdt","contractNo":"1712","direction":"B","id":"c08d5f40958246f4accacdec34cd2e6c","orderType":"2","quitCloseRatio":20,"quitGain":1374.8,"quitLoss":1272.8,"status":4,"type":1},{"amount":1,"buyPriceDeal":1274.8,"buyPriceOrder":1274.8,"commodityNo":"ltcusdt","contractNo":"1712","direction":"B","id":"f00eb416b32a493199e5af24240e3c58","orderType":"2","quitCloseRatio":20,"quitGain":1374.8,"quitLoss":1272.8,"status":4,"type":1},{"amount":1,"buyPriceDeal":1274.8,"buyPriceOrder":1274.8,"commodityNo":"GC","contractNo":"1712","direction":"B","id":"bfba53d9c9244b0fbb43224ea8376877","orderType":"2","quitCloseRatio":20,"quitGain":1374.8,"quitLoss":1272.8,"status":4,"type":1},{"amount":1,"buyPriceDeal":1.53424,"buyPriceOrder":1.53424,"commodityNo":"EURAUD","direction":"B","id":"1b5ec46ef65944aaa3ef6ee7ad493c37","orderType":"2","quitGain":3.53424,"quitLoss":1.13424,"status":4,"type":1}],"total":6}
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
         * rows : [{"amount":1,"buyPriceDeal":27.5,"commodityNo":"etcusdt","contractNo":"","direction":"B","id":"181559ed70a64bf789fddc8b2ee88540","orderType":"2","status":4,"type":1},{"amount":1,"buyPriceDeal":265,"buyPriceOrder":1274.8,"commodityNo":"ltcusdt","contractNo":"1712","direction":"B","id":"c08d5f40958246f4accacdec34cd2e6c","orderType":"2","quitCloseRatio":20,"quitGain":1374.8,"quitLoss":1272.8,"status":4,"type":1},{"amount":1,"buyPriceDeal":1274.8,"buyPriceOrder":1274.8,"commodityNo":"ltcusdt","contractNo":"1712","direction":"B","id":"f00eb416b32a493199e5af24240e3c58","orderType":"2","quitCloseRatio":20,"quitGain":1374.8,"quitLoss":1272.8,"status":4,"type":1},{"amount":1,"buyPriceDeal":1274.8,"buyPriceOrder":1274.8,"commodityNo":"GC","contractNo":"1712","direction":"B","id":"bfba53d9c9244b0fbb43224ea8376877","orderType":"2","quitCloseRatio":20,"quitGain":1374.8,"quitLoss":1272.8,"status":4,"type":1},{"amount":1,"buyPriceDeal":1.53424,"buyPriceOrder":1.53424,"commodityNo":"EURAUD","direction":"B","id":"1b5ec46ef65944aaa3ef6ee7ad493c37","orderType":"2","quitGain":3.53424,"quitLoss":1.13424,"status":4,"type":1}]
         * total : 6
         */

        private int total;
        private List<HoldBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<HoldBean> getRows() {
            return rows;
        }

        public void setRows(List<HoldBean> rows) {
            this.rows = rows;
        }


    }
}
