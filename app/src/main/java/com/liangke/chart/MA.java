package com.liangke.chart;

import android.graphics.Color;
import android.graphics.Paint;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/19.
 */

public class MA {

    public static List<MABean> maList = new ArrayList<>();

    public List<ILineDataSet> dataSetList = new ArrayList<>();

    private CandleData candleData;//柱状图

    static {
        maList.add(new MABean("MA5",5, Color.parseColor("#FFAB40")));
        maList.add(new MABean("MA10",10, Color.parseColor("#F06292")));
        maList.add(new MABean("MA20",20, Color.parseColor("#82B1FF")));
    }


    public MA(List<Entry> list,List<ChartData> chartDataList) {

        getMALineList(list);

        getCandle(chartDataList);

    }

    public static LineDataSet getMALine(List<Entry> entryList, int days){

        MA.MABean bean = MA.getMAByValue(days);

        List<Entry> tempEntryList = new ArrayList<>();
        if(entryList.size()<days){
            for(int i = 0;i<entryList.size();i++){
                tempEntryList.add(entryList.get(i));
            }
        }else {

            for (int i = 0; i < days - 1; i++) {
                tempEntryList.add(entryList.get(i));
            }

            for (int i = days - 1; i < entryList.size(); i++) {
                float totalY = 0;
                for (int j = 0; j < days; j++) {
                    totalY += entryList.get(i - j).getY();
                }
                float maY = totalY / days;
                Entry entry = new Entry();
                entry.setX(entryList.get(i).getX());
                entry.setY(maY);
                tempEntryList.add(entry);

            }
        }

        LineDataSet lineDataSet = new LineDataSet(tempEntryList,bean.getLable());

        lineDataSet.setColor(bean.getColorValue());
        lineDataSet.setLineWidth(1f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setHighlightEnabled(false);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        return lineDataSet;
    }


    public static List<Entry> getMADayLine(List<Entry> entryList, int days){

        MA.MABean bean = MA.getMAByValue(days);

        List<Entry> tempEntryList = new ArrayList<>();
        if(entryList.size()<days){
            for(int i = 0;i<entryList.size();i++){
                tempEntryList.add(entryList.get(i));
            }
        }else {

            for (int i = 0; i < days - 1; i++) {
                tempEntryList.add(entryList.get(i));
            }

            for (int i = days - 1; i < entryList.size(); i++) {
                float totalY = 0;
                for (int j = 0; j < days; j++) {
                    totalY += entryList.get(i - j).getY();
                }
                float maY = totalY / days;
                Entry entry = new Entry();
                entry.setX(entryList.get(i).getX());
                entry.setY(maY);
                tempEntryList.add(entry);

            }
        }

        return tempEntryList;
    }


    private List<ILineDataSet> getMALineList(List<Entry> entryList){

        dataSetList.add(getMALine(entryList,5));

        dataSetList.add(getMALine(entryList,10));

        dataSetList.add(getMALine(entryList,20));

        return dataSetList;
    }


    public static class MABean{
        private String lable;
        private int maValue;
        private int colorValue;

        public MABean(String lable, int maValue, int colorValue) {
            this.lable = lable;
            this.maValue = maValue;
            this.colorValue = colorValue;
        }

        public String getLable() {
            return lable;
        }

        public void setLable(String lable) {
            this.lable = lable;
        }

        public int getMaValue() {
            return maValue;
        }

        public void setMaValue(int maValue) {
            this.maValue = maValue;
        }

        public int getColorValue() {
            return colorValue;
        }

        public void setColorValue(int colorValue) {
            this.colorValue = colorValue;
        }
    }

    public static MABean getMAByValue(int maValue){
        for(MABean bean:maList){
            if(bean.getMaValue()==maValue){
                return bean;
            }
        }
        return null;
    }


    private void getCandle(List<ChartData> chartDataList){

        List<CandleEntry> candleEntryList = new ArrayList<>();
        int x = 0;
        for (ChartData data:chartDataList) {
            // turn your data into Entry objects
            x+=5;
            CandleEntry candleEntry = new CandleEntry(x,(float)data.getHigh(),(float)data.getLow(),(float)data.getOpen(),(float)data.getClose());
            candleEntryList.add(candleEntry);
        }


        CandleDataSet set = new CandleDataSet(candleEntryList, "");
        set.setDrawHorizontalHighlightIndicator(false);
        set.setHighlightEnabled(true);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setShadowWidth(3f);
        set.setValueTextSize(10f);
        set.setDecreasingColor(Color.parseColor("#F5524F"));
        set.setDecreasingPaintStyle(Paint.Style.FILL);
        set.setIncreasingColor(Color.parseColor("#11C971"));
        set.setIncreasingPaintStyle(Paint.Style.FILL);
        set.setNeutralColor(Color.parseColor("#006400"));
        set.setShadowColorSameAsCandle(true);
        set.setHighlightLineWidth(1f);
        set.setHighLightColor(Color.parseColor("#000000"));
        set.setDrawValues(false);
        set.setValueTextColor(Color.parseColor("#000000"));
        candleData = new CandleData(set);

    }

    public  List<ILineDataSet> getDataSetList() {
        return dataSetList;
    }

    public void setDataSetList(List<ILineDataSet> dataSetList) {
        this.dataSetList = dataSetList;
    }

    public CandleData getCandleData() {
        return candleData;
    }

    public void setCandleData(CandleData candleData) {
        this.candleData = candleData;
    }
}
