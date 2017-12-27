package com.liangke.chart;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

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
 * Created by LK on 2017/12/20.
 * 布林线
 */

public class BOLL {

    private static final String TAG = BOLL.class.getSimpleName();

    private List<ILineDataSet> dataSetList = new ArrayList<>();

    private CandleData candleData;//柱状图

    public List<ILineDataSet> getBollDataSet(List<Entry> list) {

        dataSetList.add(MA.getMALine(list, 20));

        getStandardDeviation(list, 20);

        return dataSetList;
    }

    public BOLL(List<Entry> list,List<ChartData> dataList) {
        getBollDataSet(list);
        getCandle(dataList);

        Log.i(TAG,">>>>>===BOLL");

    }

    private void getStandardDeviation(List<Entry> list, int days) {

        List<Entry> maDayList = MA.getMADayLine(list,20);

        List<Entry> tempList = new ArrayList<>();
        List<Entry> upList = new ArrayList<>();
        List<Entry> dnList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
               float totalNum = 0;
               if(i<20){
                   for(int j = 0;j<i;j++){
                       totalNum += Math.pow((list.get(j).getY()-maDayList.get(j).getY()),2);
                   }
               }else{
                    for(int j = i-20;j<i;j++){
                        totalNum += Math.pow((list.get(j).getY()-maDayList.get(j).getY()),2);
                    }
               }

                float boll = 0;
                if(i<20){
                    boll = (float) (Math.sqrt(totalNum)/i);
                }else{
                    boll = (float) (Math.sqrt(totalNum)/20);
                }

                Entry entry = new Entry(list.get(i).getX(), boll);
                tempList.add(entry);

        }


        for(int i = 20;i<tempList.size();i++){

            Entry upEntry = new Entry();
            upEntry.setX(maDayList.get(i).getX());
            upEntry.setY(maDayList.get(i).getY()+2*tempList.get(i).getY());
            upList.add(upEntry);

            Entry dnEntry = new Entry();
            dnEntry.setX(maDayList.get(i).getX());
            dnEntry.setY(maDayList.get(i).getY()-2*tempList.get(i).getY());
            dnList.add(dnEntry);

        }


        LineDataSet lineDataSet = new LineDataSet(upList,"");

        lineDataSet.setColor(Color.parseColor("#FFAB40"));
        lineDataSet.setLineWidth(1f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setHighlightEnabled(false);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);

        dataSetList.add(lineDataSet);

        LineDataSet dnLineDataSet = new LineDataSet(dnList,"");

        dnLineDataSet.setColor(Color.parseColor("#F06292"));
        dnLineDataSet.setLineWidth(1f);
        dnLineDataSet.setDrawCircles(false);
        dnLineDataSet.setDrawCircleHole(false);
        dnLineDataSet.setDrawValues(false);
        dnLineDataSet.setHighlightEnabled(false);
        dnLineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        dataSetList.add(dnLineDataSet);

    }

    private void getCandle(List<ChartData> chartDataList){

        Log.i(TAG,"space==getCandle");

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
        set.setShadowWidth(4f);
        set.setValueTextSize(10f);
        set.setShowCandleBar(true);
        set.setDecreasingColor(Color.parseColor("#F5524F"));
        set.setDecreasingPaintStyle(Paint.Style.FILL);
        set.setIncreasingColor(Color.parseColor("#11C971"));
        set.setIncreasingPaintStyle(Paint.Style.FILL);
        set.setNeutralColor(Color.parseColor("#006400"));
        set.setShadowColorSameAsCandle(true);
        set.setHighlightLineWidth(1f);
        set.setHighLightColor(Color.parseColor("#000000"));
        set.setDrawValues(true);
        set.setValueTextColor(Color.parseColor("#000000"));
        candleData = new CandleData(set);

        Log.i(TAG,"space=="+set.getBarSpace());

    }

    public List<ILineDataSet> getDataSetList() {
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
