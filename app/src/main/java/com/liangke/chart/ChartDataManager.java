package com.liangke.chart;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.liangke.comprehensive.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.liangke.comprehensive.R.id.chart;

/**
 * Created by LK on 2017/12/5.
 */

public class ChartDataManager {

    private final String TAG = "Chart";

    private GraphType.Type graphType;

    private CandleData candleData;//柱状图

    private BarData barData;

    //点的集合
    private  List<Entry> entries = new ArrayList<Entry>();
    private List<String> timeList = new ArrayList<>();//时间集合

    private List<ChartData> dataList = new ArrayList<>();

    //显示线状图
    private List<ILineDataSet> lineDataSetList = new ArrayList<>();
    private LineData lineData ;

    private ChartData lastChartData;

    private float lineDeltX = 5;
    private float lastX = 0;
    private OnChartDataChange onChartDataChange;

    public ChartDataManager(GraphType.Type type) {
        this.graphType = type;
    }

    public void addLiveData(ChartData data){
//
        if(graphType== GraphType.Type.MA||graphType== GraphType.Type.BOLL){
            addLive(data);
            notifyDataSetChanged(ChartInit.LIVE);
        }
    }

    private void addLive(ChartData data){
        if(timeList.size()==0){
            return;
        }
        lastChartData = data;
        if(data.getTime().equals(timeList.get(timeList.size()-1))){
            Entry entry = new Entry(lastX,(float)data.getClose());
            lineDataSetList.get(0).removeLast();
            lineDataSetList.get(0).addEntry(entry);
            dataList.remove(dataList.size()-1);
            dataList.add(data);
        }else{
            lastX+=lineDeltX;
            Entry entry = new Entry(lastX,(float)data.getClose());
            lineDataSetList.get(0).addEntry(entry);
            timeList.add(data.getTime());
            entries.add(entry);
            dataList.add(data);
        }

    }



    public void setHistoryData(List<ChartData> chartDataList){
        dataList.clear();
        timeList.clear();
        entries.clear();

        dataList.addAll(chartDataList);

        lineDeltX = 5;
        int x = 0;

        for (ChartData data:chartDataList) {
            // turn your data into Entry objects
            x+=lineDeltX;
            float value = (float) data.getClose();
            Entry entry = new Entry(x,value);
            entries.add(entry);
            timeList.add(data.getTime()+"");
            lastX = x;
        }

        lastChartData = chartDataList.get(chartDataList.size()-1);

        setDataSet();

        notifyDataSetChanged(ChartInit.HISTORY);
    }

    private void setDataSet(){
        lineDataSetList.clear();
        if(graphType== GraphType.Type.MA){
            MA ma = new MA(entries,dataList);
            lineDataSetList.addAll(ma.getDataSetList());
            candleData = ma.getCandleData();
        }else if(graphType== GraphType.Type.BOLL){
            BOLL boll = new BOLL(entries,dataList);
            lineDataSetList.addAll(boll.getDataSetList());
            candleData = boll.getCandleData();
        }else if(graphType== GraphType.Type.MACD){
            MACD macd = new MACD(entries);
            lineDataSetList.addAll(macd.getLineDataSetList());
            barData = macd.getBarData();
        }else if(graphType== GraphType.Type.RSI){
            RSI rsi = new RSI(entries,dataList);
            lineDataSetList.addAll(rsi.getDataSetList());
            barData = new BarData();
        }else if(graphType== GraphType.Type.KDJ){
            KDJ kdj = new KDJ(entries,dataList);
            lineDataSetList.addAll(kdj.getDataSetList());
            barData = new BarData();
        }
    }


    public interface OnChartDataChange{
        public void notifyDataSetChanged(int status);
    }

    public OnChartDataChange getOnChartDataChange() {
        return onChartDataChange;
    }

    public void setOnChartDataChange(OnChartDataChange onChartDataChange) {
        this.onChartDataChange = onChartDataChange;
    }

    public void notifyDataSetChanged(int status){
        if(onChartDataChange!=null){
            onChartDataChange.notifyDataSetChanged(status);
        }
    }

    public GraphType.Type getGraphType() {
        return graphType;
    }

    public void setGraphType(GraphType.Type graphType) {
        if(this.graphType == graphType){
            return;
        }
        this.graphType = graphType;
        setDataSet();
        notifyDataSetChanged(ChartInit.HISTORY);
    }



    public float getLineDeltX() {
        return lineDeltX;
    }

    public void setLineDeltX(float lineDeltX) {
        this.lineDeltX = lineDeltX;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }


    public String getTime(int index){
        return timeList.get(index);
    }

    public CandleData getCandleData() {
        return candleData;
    }

    public void setCandleData(CandleData candleData) {
        this.candleData = candleData;
    }


    public LineData getLineData() {
        lineData = new LineData(lineDataSetList);

        return lineData;
    }

    public void setLineData(LineData lineData) {
        this.lineData = lineData;
    }


    public ChartData getLastCharData() {
        return lastChartData;
    }

    public void setLastCharData(ChartData lastCharData) {
        this.lastChartData = lastCharData;
    }

    public BarData getBarData() {
        return barData;
    }

    public void setBarData(BarData barData) {
        this.barData = barData;
    }
}
