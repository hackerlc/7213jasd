package com.liangke.chart;

import android.graphics.Color;
import android.util.Log;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/21.
 * 随机指标KDJ一般是用于股票分析的统计体系，根据统计学原理，
 * 通过一个特定的周期（常为9日、9周等）内出现过的最高价、
 * 最低价及最后一个计算周期的收盘价及这三者之间的比例关系，
 * 来计算最后一个计算周期的未成熟随机值RSV，
 * 然后根据平滑移动平均线的方法来计算K值、D值与J值，并绘成曲线图来研判股票走势。
 */

public class KDJ {
    private final String TAG = KDJ.class.getSimpleName();
    private List<ILineDataSet> dataSetList = new ArrayList<>();
    private List<Entry> rsvList = new ArrayList<>();

    private int day = 9;

    public KDJ(List<Entry> list,List<ChartData> chartDataList) {

            for(int i = 0;i<list.size();i++){
                if(i<day-1){
                    rsvList.add(list.get(i));
                }else{
                    float high = Float.MIN_VALUE;
                    float low = Float.MAX_VALUE;
                    for(int j = i-day+1;j<i;j++){
                        float highValue = chartDataList.get(j).getHigh();
                        float lowValue = chartDataList.get(j).getLow();
                        if(high<highValue){
                            high = highValue;
                        }
                        if(low>lowValue){
                            low = lowValue;
                        }
                    }
                    float bid = list.get(i).getY();
                    float rsv = (bid-low)/(high-low)*100;
                    Entry entry = new Entry();
                    entry.setX(list.get(i).getX());
                    entry.setY(rsv);
                    rsvList.add(entry);
                }

            }

            List<Entry> kList = new ArrayList<>();
            List<Entry> dList = new ArrayList<>();
            List<Entry> jList = new ArrayList<>();
            float preK = 50;
            float preD = 50;
            for(int i = day-1;i<list.size();i++){
                float k = (float) preK*2/3+(float) rsvList.get(i).getY()*1/3;
                float d = (float) preD*2/3+k*1/3;
                float j = 3*k-2*d;
                Log.i(TAG,">>>k="+k+",d="+d+",j="+j);

                preK = k;
                preD = d;

                Entry kentry = new Entry();
                kentry.setX(rsvList.get(i).getX());
                kentry.setY(k);
                kList.add(kentry);

                Entry dentry = new Entry();
                dentry.setX(rsvList.get(i).getX());
                dentry.setY(d);
                dList.add(dentry);

                Entry jentry = new Entry();
                jentry.setX(rsvList.get(i).getX());
                jentry.setY(j);
                jList.add(jentry);

            }

            LineDataSet kSet = new LineDataSet(kList,"");
            kSet.setColor(Color.parseColor("#F06292"));
            kSet.setLineWidth(1f);
            kSet.setDrawCircles(false);
            kSet.setDrawCircleHole(false);
            kSet.setDrawValues(false);
            kSet.setHighlightEnabled(false);
            kSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        dataSetList.add(kSet);

            LineDataSet dSet = new LineDataSet(dList,"");
        dSet.setColor(Color.parseColor("#FFAB40"));
        dSet.setLineWidth(1f);
        dSet.setDrawCircles(false);
        dSet.setDrawCircleHole(false);
        dSet.setDrawValues(false);
        dSet.setHighlightEnabled(false);
        dSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        dataSetList.add(dSet);


        LineDataSet jSet = new LineDataSet(jList,"");
        jSet.setColor(Color.parseColor("#82B1FF"));
        jSet.setLineWidth(1f);
        jSet.setDrawCircles(false);
        jSet.setDrawCircleHole(false);
        jSet.setDrawValues(false);
        jSet.setHighlightEnabled(false);
        jSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        dataSetList.add(jSet);

    }

    public List<ILineDataSet> getDataSetList() {
        return dataSetList;
    }

    public void setDataSetList(List<ILineDataSet> dataSetList) {
        this.dataSetList = dataSetList;
    }
}
