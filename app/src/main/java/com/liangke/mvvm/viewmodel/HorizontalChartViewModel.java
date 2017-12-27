package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.liangke.base.BaseViewModel;
import com.liangke.chart.ChartData;
import com.liangke.chart.ChartType;
import com.liangke.chart.GraphType;
import com.liangke.chart.MPChartManager;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.FragmentHorizontalchartBinding;
import com.liangke.comprehensive.market.HorizontalChartFragment;
import com.liangke.http.response.HistoryResponse;
import com.liangke.mvvm.model.HistoryModel;
import com.liangke.mvvm.rxbing.HorizontalChartBing;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.message.SubscribeMessage;
import com.liangke.tcp.packet.QuoteRealPushBody;
import com.liangke.utils.Utils;
import com.liangke.widget.TabContent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LK on 2017/12/15.
 */

public class HorizontalChartViewModel extends BaseViewModel {

    private final String TAG = HorizontalChartViewModel.class.getSimpleName();

    private HorizontalChartFragment fragment;
    private FragmentHorizontalchartBinding binding;
    private HistoryModel historyModel;

    private MPChartManager upManager;
    private MPChartManager downManager;

    private String commdity = "ltcusdt";

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                QuoteRealPushBody body = (QuoteRealPushBody) msg.obj;
                binding.tvReal.setText(getNum(""+body.getBid())+"");

                ChartData chartData = new ChartData();
                chartData.setTime(getTime(body.getTime()));
                chartData.setClose(getNum(body.getBid()));
                chartData.setHigh(0);
                chartData.setLow(0);
                chartData.setOpen(0);

                upManager.addLiveData(chartData);
            }
        }
    };

    public HorizontalChartViewModel(HorizontalChartFragment fragment,FragmentHorizontalchartBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        historyModel = new HistoryModel(mContext,observer);
        HorizontalChartBing bing = new HorizontalChartBing(fragment.getActivity(),this,binding);
        init();
    }

    @Override
    public void init() {

        EventBus.getDefault().register(this);

        upManager = new MPChartManager(mContext, ChartType.Type.FOREX,binding.chartUp);
        downManager = new MPChartManager(mContext, ChartType.Type.FOREX,GraphType.Type.MACD,binding.chartDown);

        String[] array = mContext.getResources().getStringArray(R.array.chartTypeArray);
        List<TabContent> list = new ArrayList<>();
        for(int i = 0;i<array.length;i++){
            TabContent tabContent = new TabContent();
            tabContent.tab_txt = array[i];
            tabContent.tab_txtColor_selected = R.color.black_01;
            tabContent.tab_txtColor_unslected = R.color.gray_01;
            tabContent.tab_txt_size = 12;
            list.add(tabContent);
        }
        binding.tllTab.getTabManager().setmList(list);

        history(0);

    }




    public void history(int index){
        historyModel.history(HistoryModel.typeList.get(index),"089ca86e793b4dcf87a5ade922c5e7ef",commdity,"",System.currentTimeMillis(),"");
    }

    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof HistoryResponse){
            HistoryResponse response = (HistoryResponse) value;
            if(response.getData()==null){
                return;
            }
            List<ChartData> dataList = new ArrayList<>();
            //5位小数
            for(HistoryResponse.DataBean bean:response.getData()){

                ChartData chartData = new ChartData();
                chartData.setTime(getTime(bean.getTime()));
                chartData.setClose(getNum(bean.getClose()+""));
                chartData.setHigh((float) bean.getHigh());
                chartData.setLow((float) bean.getLow());
                chartData.setOpen((float)bean.getOpen());
                dataList.add(chartData);
            }
            upManager.setHistoryData(dataList);
            downManager.setHistoryData(dataList);
            sendSubscribeMessage();

        }
    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    private float getNum(String number){

        double tempNum = Double.parseDouble(number);
        DecimalFormat df = new DecimalFormat("0.00");// 这样为保持5位
        String num = df.format(tempNum);

        return Float.parseFloat(num);
    }



        public static String getTime(long time){
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            Date date = new Date(time);
            res = simpleDateFormat.format(date);
            return res;
        }

        public void onDestory(){
            EventBus.getDefault().unregister(this);
        }

        @Subscribe
        public void onEvent(QuoteRequestEvent event){

            Message msg = new Message();
            msg.what = 0;
            msg.obj = event.getQuoteList().get(0);
            handler.sendMessage(msg);

        }

        private void sendSubscribeMessage(){
//            SubscribeMessage.sendSubscribeMessage(commdity);
        }

        public void changChartKind(int index){
            switch (index){
                case 0:
                    upManager.setGraphType(GraphType.Type.MA);
                    break;
                case 1:
                    upManager.setGraphType(GraphType.Type.BOLL);
                    break;
            }
        }

        public void onSelectedPosition(int position){

            history(position);

        }


}
