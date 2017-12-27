package com.liangke.mvvm.viewmodel;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.liangke.base.BaseViewModel;
import com.liangke.chart.ChartData;
import com.liangke.chart.ChartType;
import com.liangke.chart.GraphType;
import com.liangke.chart.MPChartManager;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityMarketBinding;
import com.liangke.comprehensive.market.HorizontalChartFragment;
import com.liangke.comprehensive.market.SingleMarketActivity;
import com.liangke.comprehensive.market.VerticalChartFragment;
import com.liangke.constants.Constants;
import com.liangke.data.Preferences;
import com.liangke.http.response.AddFavoriteCommodityResponse;
import com.liangke.http.response.HistoryResponse;
import com.liangke.mvvm.model.AddFavoriteCommodityModel;
import com.liangke.mvvm.model.HistoryModel;
import com.liangke.mvvm.model.StrategiesModel;
import com.liangke.mvvm.rxbing.SingleMarketBing;
import com.liangke.popupwindow.BuyPopupWindow;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.message.SubscribeMessage;
import com.liangke.tcp.packet.QuoteRealPushBody;
import com.liangke.utils.FragmentSwitchUtils;
import com.liangke.widget.TabContent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LK on 2017/12/13.
 */

public class SingleMarketViewModel extends BaseViewModel {

    private final String TAG = SingleMarketViewModel.class.getSimpleName();

    private ActivityMarketBinding binding;
    private SingleMarketActivity activity;
    private FragmentSwitchUtils utils;

    private MPChartManager manager,upManager,downManager;

    private HistoryModel historyModel;

    private BuyPopupWindow buyPopupWindow;
    private AddFavoriteCommodityModel addFavoriteCommodityModel;

    private String commdity = "ltcusdt";
    private String productId;
    private String price = "--";

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                QuoteRealPushBody body = (QuoteRealPushBody) msg.obj;
                price = body.getBid();
                binding.tvReal.setText(getNum(""+body.getBid())+"");
                binding.tvClose.setText(body.getClose());
                binding.tvOpen.setText(body.getOpen());
                binding.tvHigh.setText(body.getHigh());
                binding.tvLow.setText(body.getLow());

                float bid = Float.parseFloat(body.getBid());
                float settle = Float.parseFloat(body.getSettle());
                float change = bid-settle;
                float chg = (bid-settle)/settle;
                binding.tvChang2.setText(change+"");
                binding.tvChg.setText(chg+"");

                ChartData chartData = new ChartData();
                chartData.setTime(getTime(body.getTime()));
                chartData.setClose(getNum(body.getBid()));
                chartData.setHigh(0);
                chartData.setLow(0);
                chartData.setOpen(0);
                if(binding.chart!=null){
                    manager.addLiveData(chartData);
                }else{
                    upManager.addLiveData(chartData);
                }

                if(buyPopupWindow!=null){
                    if(buyPopupWindow.isShow()){
                        buyPopupWindow.setPrice(price);
                    }
                }
            }
        }
    };

    public SingleMarketViewModel(SingleMarketActivity activity, ActivityMarketBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;

        historyModel = new HistoryModel(mContext,observer);
        addFavoriteCommodityModel = new AddFavoriteCommodityModel(mContext,observer);
        SingleMarketBing bing = new SingleMarketBing(mContext,this,binding);

        init();

    }

    @Override
    public void init() {


        commdity = activity.getIntent().getStringExtra("commodityCode");
        productId = activity.getIntent().getStringExtra("productId");

        EventBus.getDefault().register(this);

        if(binding.chart!=null){
            manager = new MPChartManager(mContext, ChartType.Type.FOREX,binding.chart);
        }else{
            upManager = new MPChartManager(mContext, ChartType.Type.FOREX,binding.chartUp);
            downManager = new MPChartManager(mContext, ChartType.Type.FOREX, GraphType.Type.MACD,binding.chartDown);
        }

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
                chartData.setOpen((float) bean.getOpen());
                dataList.add(chartData);
            }
            if(binding.chart!=null){
                manager.setHistoryData(dataList);
            }else{
                upManager.setHistoryData(dataList);
                downManager.setHistoryData(dataList);
            }

            sendSubscribeMessage();

        }else if(value instanceof AddFavoriteCommodityResponse){
            AddFavoriteCommodityResponse response = (AddFavoriteCommodityResponse) value;
            if(response.getCode()== Constants.SUCCESS_CODE){
                binding.ivFocus.setVisibility(View.GONE);
                binding.tvFocus.setText("已添加");
            }
        }

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void change(){
        if(activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            activity.setTheme(R.style.AppTheme3);
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else{
            activity.setTheme(R.style.AppTheme2);
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }


    public void history(int index){
        historyModel.history(HistoryModel.typeList.get(index),"089ca86e793b4dcf87a5ade922c5e7ef",commdity, "",System.currentTimeMillis(),"");
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
        for(QuoteRealPushBody body:event.getQuoteList()){

            if(commdity.equals(body.getCommodityNo())){
                Message msg = new Message();
                msg.what = 0;
                msg.obj = event.getQuoteList().get(0);
                handler.sendMessage(msg);
            }

        }

    }

    private void sendSubscribeMessage(){
        SubscribeMessage.sendSubscribeMessage(commdity,productId);
    }

    public void onSelectedPosition(int position){
        history(position);
    }


    public void changChartKind(int index){
        switch (index){
            case 0:
                upManager.setGraphType(GraphType.Type.MA);
                break;
            case 1:
                upManager.setGraphType(GraphType.Type.BOLL);
                break;
            case 2:
                downManager.setGraphType(GraphType.Type.MACD);
                break;
            case 3:
                downManager.setGraphType(GraphType.Type.RSI);
                break;
            case 4:
                downManager.setGraphType(GraphType.Type.KDJ);
                break;
        }
    }

    public void buy(){
        BuyPopupWindow buyPopupWindow = new BuyPopupWindow(mContext,observer);
        buyPopupWindow.setCommdity(commdity);
        buyPopupWindow.setProductId(productId);
        buyPopupWindow.setPrice(price);
        buyPopupWindow.showAtLocation(binding.llMain, Gravity.BOTTOM,0,0);
    }


    public void focus(){
        addFavoriteCommodityModel.addFavoriteCommodity(productId,commdity);
    }

}
