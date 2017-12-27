package com.liangke.chart;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.liangke.comprehensive.R;

import java.util.ArrayList;
import java.util.List;

import static com.liangke.comprehensive.R.id.chart;
import static com.liangke.comprehensive.R.id.masked;

/**
 * Created by LK on 2017/12/5.
 */

public class ChartInit {

    private final String TAG = ChartInit.class.getSimpleName();

    private Context mContext;
    private ChartType.Type type;
    private CombinedChart chart;
    private ChartDataManager manager;

    public static final int HISTORY = 2007;
    public static final int LIVE = 2098;

    private boolean isZoom = false;

    private ChartDataManager.OnChartDataChange onChartDataChange =
            new ChartDataManager.OnChartDataChange() {
        @Override
        public void notifyDataSetChanged(int status) {
            if(status==HISTORY){
                setHistoryData();
            }else if(status==LIVE){
                addLiveData();
            }
        }
    };


    public ChartInit(Context context,ChartType.Type type, CombinedChart chart, ChartDataManager manager) {
        this.mContext = context;
        this.type = type;
        this.chart = chart;
        this.manager = manager;
        this.manager.setOnChartDataChange(onChartDataChange);

        init();

    }

    public void init(){



        if(manager.getGraphType()== GraphType.Type.MA||manager.getGraphType()== GraphType.Type.BOLL){

            chart.setScaleEnabled(true);//启用图表缩放事件
            chart.setDrawBorders(true);//是否绘制边线
            chart.setBorderWidth(1);//边线宽度，单位dp
            chart.setDragEnabled(true);//启用图表拖拽事件
            chart.setScaleYEnabled(false);//启用Y轴上的缩放
            chart.setBorderColor(Color.parseColor("#A7ADBC"));//边线颜色
            Description description = new Description();
            description.setText("");
            chart.setDescription(description);//右下角对图表的描述信息
            chart.setMinOffset(0f);
            chart.setExtraOffsets(0f, 0f, 0f, 3f);

            Legend lineChartLegend = chart.getLegend();
            lineChartLegend.setEnabled(false);//是否绘制 Legend 图例
            lineChartLegend.setForm(Legend.LegendForm.CIRCLE);

            //bar x y轴
            XAxis xAxisKline = chart.getXAxis();
            xAxisKline.setDrawLabels(true); //是否显示X坐标轴上的刻度，默认是true
            xAxisKline.setDrawGridLines(false);//是否显示X坐标轴上的刻度竖线，默认是true
            xAxisKline.setDrawAxisLine(false); //是否绘制坐标轴的线，即含有坐标的那条线，默认是true
            xAxisKline.enableGridDashedLine(10f, 10f, 0f);//虚线表示X轴上的刻度竖线(float lineLength, float spaceLength, float phase)三个参数，1.线长，2.虚线间距，3.虚线开始坐标
            xAxisKline.setTextColor(Color.parseColor("#666666"));//设置字的颜色
            xAxisKline.setPosition(XAxis.XAxisPosition.BOTTOM);//设置值显示在什么位置
            xAxisKline.setAvoidFirstLastClipping(true);//设置首尾的值是否自动调整，避免被遮挡

            IAxisValueFormatter formatter = new IAxisValueFormatter() {

                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    int index = (int) (value/manager.getLineDeltX());
                    if(index<manager.getEntries().size()){
                        return manager.getTime(index);
                    }else if(index==manager.getEntries().size()){
                        return manager.getTime(index-1);
                    }
                    return "";
                }
                // we don't draw numbers, so no decimal digits needed
                public int getDecimalDigits() {  return 0; }
            };
            xAxisKline.setValueFormatter(formatter);

            YAxis axisLeftKline = chart.getAxisLeft();
            axisLeftKline.setDrawGridLines(true);
            axisLeftKline.setDrawAxisLine(false);
            axisLeftKline.setDrawZeroLine(false);
            axisLeftKline.setDrawLabels(true);
            axisLeftKline.enableGridDashedLine(10f, 10f, 0f);
            axisLeftKline.setTextColor(Color.parseColor("#666666"));
//        axisLeftKline.setGridColor(getResources().getColor(R.color.minute_grayLine));
            axisLeftKline.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
            axisLeftKline.setLabelCount(4, false); //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布
            axisLeftKline.setSpaceTop(10);//距离顶部留白

            YAxis axisRightKline = chart.getAxisRight();
            axisRightKline.setDrawLabels(false);
            axisRightKline.setDrawGridLines(false);
            axisRightKline.setDrawAxisLine(false);
            axisRightKline.setLabelCount(4, false); //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布

            chart.setDragDecelerationEnabled(true);
            chart.setDragDecelerationFrictionCoef(0.2f);

//          chart.animateXY(2000, 2000);

        }else{
            chart.setScaleEnabled(true);//启用图表缩放事件
            chart.setDrawBorders(true);//是否绘制边线
            chart.setBorderWidth(1);//边线宽度，单位dp
            chart.setDragEnabled(true);//启用图表拖拽事件
            chart.setScaleYEnabled(false);//启用Y轴上的缩放
            chart.setBorderColor(Color.parseColor("#A7ADBC"));//边线颜色
            Description description = new Description();
            description.setText("");
            chart.setDescription(description);//右下角对图表的描述信息
            chart.setMinOffset(0f);
            chart.setExtraOffsets(0f, 0f, 0f, 3f);

            Legend lineChartLegend = chart.getLegend();
            lineChartLegend.setEnabled(false);//是否绘制 Legend 图例

            //bar x y轴
            XAxis xAxisCharts = chart.getXAxis();
            xAxisCharts.setEnabled(false);

            YAxis axisLeftCharts = chart.getAxisLeft();
            axisLeftCharts.setDrawGridLines(true);
            axisLeftCharts.setDrawAxisLine(false);
            axisLeftCharts.setDrawLabels(true);
            axisLeftCharts.enableGridDashedLine(10f, 10f, 0f);
            axisLeftCharts.setTextColor(Color.parseColor("#666666"));
            axisLeftCharts.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
            axisLeftCharts.setLabelCount(1, false); //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布

            YAxis axisRightCharts = chart.getAxisRight();
            axisRightCharts.setDrawLabels(false);
            axisRightCharts.setDrawGridLines(false);
            axisRightCharts.setDrawAxisLine(false);

            chart.setDragDecelerationEnabled(true);
            chart.setDragDecelerationFrictionCoef(0.2f);

            chart.animateXY(2000, 2000);
        }


    }



    CombinedData combinedData = new CombinedData();

    private void setHistoryData(){

        if(manager.getGraphType()== GraphType.Type.MA||manager.getGraphType()== GraphType.Type.BOLL){
            combinedData.setData(manager.getLineData());
            combinedData.setData(manager.getCandleData());
        }else if(manager.getGraphType()== GraphType.Type.MACD){
            combinedData.setData(manager.getLineData());
            combinedData.setData(manager.getBarData());
        }else if(manager.getGraphType()== GraphType.Type.RSI){
            combinedData.setData(manager.getLineData());
            combinedData.setData(manager.getBarData());
        }else if(manager.getGraphType()== GraphType.Type.KDJ){
            combinedData.setData(manager.getLineData());
            combinedData.setData(manager.getBarData());
        }

        if(manager.getGraphType()== GraphType.Type.MA||manager.getGraphType()== GraphType.Type.BOLL){
            chart.getXAxis().setAxisMaximum(manager.getEntries().size()*manager.getLineDeltX()+100);
        }


        chart.setData(combinedData);

        if(!isZoom){
            isZoom = true;
            chart.zoom(3.8f,1, chart.getMeasuredWidth(), 0);
        }

        chart.invalidate();

    }

    private void addLiveData(){
        if(manager.getLastCharData()==null){
            return;
        }
        // 设置y轴的LimitLine
        LimitLine yLimitLine = new LimitLine(manager.getLastCharData().getClose(),""+manager.getLastCharData().getClose());
        yLimitLine.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_TOP);
        yLimitLine.setLineColor(Color.parseColor("#979797"));
        yLimitLine.setTextColor(Color.parseColor("#979797"));
        yLimitLine.setLineWidth(0.5f);
        yLimitLine.setTextSize(10f);
        // 获得左侧侧坐标轴
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(yLimitLine);

        chart.notifyDataSetChanged();
        chart.invalidate();

    }





}
