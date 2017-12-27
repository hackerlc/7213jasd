package com.liangke.chart;

import android.content.Context;

import com.github.mikephil.charting.charts.CombinedChart;

import java.util.List;

/**
 * Created by LK on 2017/12/5.
 */

public class MPChartManager {

    private Context mContext;
    private ChartType.Type charType;
    private CombinedChart chart;
    private ChartDataManager dataManager;
    public MPChartManager(Context mContext, ChartType.Type type, CombinedChart chart) {
        this.mContext = mContext;
        this.charType = type;
        this.chart = chart;
        dataManager = new ChartDataManager(GraphType.Type.MA);
        float deltX = chart.getMeasuredWidth()/300;
        dataManager.setLineDeltX(deltX);
        init();
    }

    public MPChartManager(Context mContext,CombinedChart chart) {
        this.mContext = mContext;
        this.charType = ChartType.Type.FOREX;
        this.chart = chart;
        dataManager = new ChartDataManager(GraphType.Type.MA);
        float deltX = chart.getMeasuredWidth()/300;
        dataManager.setLineDeltX(deltX);
        init();
    }

    public MPChartManager(Context mContext, ChartType.Type type, GraphType.Type graphType,CombinedChart chart) {
        this.mContext = mContext;
        this.charType = type;
        this.chart = chart;
        dataManager = new ChartDataManager(graphType);
        float deltX = chart.getMeasuredWidth()/300;
        dataManager.setLineDeltX(deltX);
        init();
    }

    public void setGraphType(GraphType.Type graphType){
        dataManager.setGraphType(graphType);
    }
    //初始化
    public void init(){
        ChartInit chartInit = new ChartInit(mContext,charType,chart,dataManager);
        chartInit.init();
    }

    //添加历史数据
    public void setHistoryData(List<ChartData> chartDataList){
        dataManager.setHistoryData(chartDataList);
    }

    //添加实时数据
    public void addLiveData(ChartData data){
        dataManager.addLiveData(data);
    }



}
