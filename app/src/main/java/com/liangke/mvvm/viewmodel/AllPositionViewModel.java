package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentAllpositionBinding;
import com.liangke.comprehensive.position.AllPositionFragment;
import com.liangke.http.response.HoldResponse;
import com.liangke.mvvm.bean.HoldBean;
import com.liangke.mvvm.bean.OtherChoiceBean;
import com.liangke.mvvm.model.AllPositionModel;
import com.liangke.mvvm.model.HoldModel;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.message.SubscribeMessage;
import com.liangke.tcp.packet.QuoteRealPushBody;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/25.
 */

public class AllPositionViewModel extends BaseViewModel {
    private AllPositionFragment fragment;
    private FragmentAllpositionBinding binding;
    private HoldModel holdModel;
    private AllPositionModel model;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                QuoteRealPushBody body = (QuoteRealPushBody) msg.obj;

                model.update(body);

            }
        }
    };

    public AllPositionViewModel(AllPositionFragment fragment,FragmentAllpositionBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;

        model = new AllPositionModel(mContext,observer);
        holdModel = new HoldModel(mContext,observer);

        init();

    }

    @Override
    public void init() {

        EventBus.getDefault().register(this);

        model.init(binding.rvList);
        holdModel.hold("",1);


    }

    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof HoldResponse){
            HoldResponse response = (HoldResponse) value;
            model.setmList(response.getData().getRows());
            if(response.getData().getRows()==null){
                return;
            }
            List<SubscribeMessage.Subscribe> commodityList = new ArrayList<>();
            for(HoldBean bean:response.getData().getRows()){
                SubscribeMessage.Subscribe subscribe = new SubscribeMessage.Subscribe(bean.getSymbol(),bean.getExchange());
                commodityList.add(subscribe);
            }
            sendSubscribeMessage(commodityList);

        }
    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    private void sendSubscribeMessage(List<SubscribeMessage.Subscribe> commdityList){
        SubscribeMessage.sendSubscribeMessage(commdityList);
    }


    @Subscribe
    public void onEvent(QuoteRequestEvent event){

        Message msg = new Message();
        msg.what = 0;
        msg.obj = event.getQuoteList().get(0);
        handler.sendMessage(msg);

    }


    public void onDestory(){
        EventBus.getDefault().unregister(this);
    }

}
