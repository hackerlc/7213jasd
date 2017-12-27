package com.liangke.chart;

import android.graphics.Color;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ColorFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/20.
 * 指数平滑移动平均线
 */

public class MACD {


    private List<ILineDataSet> lineDataSetList = new ArrayList<>();
    private BarData barData;

    public MACD(List<Entry> list) {
        getMACDDataList(list);
    }

    public void getMACDDataList(List<Entry> list){

        List<Entry> shortEntry = MA.getMADayLine(list,12);
        List<Entry> longEntry = MA.getMADayLine(list,26);

        List<Entry> diffEntry = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            Entry entry = new Entry();
            entry.setX(list.get(i).getX());
            entry.setY(shortEntry.get(i).getY()-longEntry.get(i).getY());
            diffEntry.add(entry);
        }

        LineDataSet diffLineDataSet = new LineDataSet(diffEntry,"");

        diffLineDataSet.setColor(Color.parseColor("#FFAB40"));
        diffLineDataSet.setLineWidth(1f);
        diffLineDataSet.setDrawCircles(false);
        diffLineDataSet.setDrawCircleHole(false);
        diffLineDataSet.setDrawValues(false);
        diffLineDataSet.setHighlightEnabled(false);
        diffLineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        lineDataSetList.add(diffLineDataSet);

        List<Entry> deaEntry = MA.getMADayLine(diffEntry,9);
        LineDataSet deaLineDataSet = new LineDataSet(deaEntry,"");
        deaLineDataSet.setColor(Color.parseColor("#82B1FF"));
        deaLineDataSet.setLineWidth(1f);
        deaLineDataSet.setDrawCircles(false);
        deaLineDataSet.setDrawCircleHole(false);
        deaLineDataSet.setDrawValues(false);
        deaLineDataSet.setHighlightEnabled(false);
        deaLineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        lineDataSetList.add(deaLineDataSet);

        getMACDBar(diffEntry,deaEntry);

    }

    public void getMACDBar(List<Entry> diffEntry,List<Entry> defEntry){

        List<BarEntry> macdEntry = new ArrayList<>();
        for(int i = 0;i<diffEntry.size();i++){
            BarEntry barEntry = new BarEntry(diffEntry.get(i).getX(),diffEntry.get(i).getY()-defEntry.get(i).getY());
            macdEntry.add(barEntry);
        }


        BarDataSet set = new BarDataSet(macdEntry, "");
        set.setHighlightEnabled(true);
        set.setHighLightAlpha(255);
        set.setHighLightColor(Color.parseColor("#000000"));
        set.setDrawValues(false);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        List<Integer> list = new ArrayList<>();
        list.add(Color.parseColor("#F5524F"));
        list.add(Color.parseColor("#11C971"));
        set.setColors(list);

        barData = new BarData(set);

    }

    public List<ILineDataSet> getLineDataSetList() {
        return lineDataSetList;
    }

    public void setLineDataSetList(List<ILineDataSet> lineDataSetList) {
        this.lineDataSetList = lineDataSetList;
    }

    public BarData getBarData() {
        return barData;
    }

    public void setBarData(BarData barData) {
        this.barData = barData;
    }
}
