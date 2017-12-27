package com.liangke.chart;

import android.graphics.Color;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.liangke.comprehensive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/20.
 * 相对强弱指数RSI是根据一定时期内上涨点数和涨跌点数之和的比率制作出的一种技术曲线。
 */

public class RSI {



    private List<ILineDataSet> dataSetList = new ArrayList<>();

    private int[] days={6,12,24};
    private String[] colorRes = {"#F06292","#FFAB40","#82B1FF"};

    public RSI(List<Entry> list,List<ChartData> chartDataList) {

        for(int i = 0;i<days.length;i++){
            int day = days[i];
            List<Entry> tempEntryList = new ArrayList<>();
            for(int j = day-1;j<list.size();j++){
                float totalUp = 0;
                float totalDown = 0;

                for(int k = j-day+1;k<=j;k++){
                    float open = chartDataList.get(k).getOpen();
                    float close = chartDataList.get(k).getClose();
                    if(open<close){
                        totalUp +=(close-open);
                    }else{
                        totalDown +=(open-close);
                    }
                }
                Entry entry = new Entry();
                entry.setX(list.get(j).getX());
                entry.setY(getRsi(totalUp,totalDown));
                tempEntryList.add(entry);
            }
            LineDataSet set = new LineDataSet(tempEntryList,"");

            set.setColor(Color.parseColor(colorRes[i]));
            set.setLineWidth(1f);
            set.setDrawCircles(false);
            set.setDrawCircleHole(false);
            set.setDrawValues(false);
            set.setHighlightEnabled(false);
            set.setAxisDependency(YAxis.AxisDependency.RIGHT);

            dataSetList.add(set);
        }

    }

    private float getRsi(float up,float down){
        return 100-100/(1+(up/down)*100);
    }

    public List<ILineDataSet> getDataSetList() {
        return dataSetList;
    }

    public void setDataSetList(List<ILineDataSet> dataSetList) {
        this.dataSetList = dataSetList;
    }
}
