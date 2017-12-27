package com.liangke.chart;

/**
 * Created by LK on 2017/12/5.
 */

public class ChartType {

    public enum Type{
        FUTURES,FOREX;
    }

    protected static boolean contain(Type type){
        boolean isContain = false;

        if(type==Type.FUTURES||type==Type.FOREX){
            isContain = true;
        }

        return isContain;
    }


}
