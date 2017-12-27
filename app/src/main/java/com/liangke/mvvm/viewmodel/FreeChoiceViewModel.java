package com.liangke.mvvm.viewmodel;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentFreechoiceBinding;
import com.liangke.comprehensive.market.FreeChoiceFragment;
import com.liangke.comprehensive.market.MarketFragment;
import com.liangke.http.response.QueryFavoriteCommodityResponse;
import com.liangke.mvvm.bean.OtherChoiceBean;
import com.liangke.mvvm.bean.ProductBean;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.mvvm.bean.QueryFavoriteCommodityBean;
import com.liangke.mvvm.model.FreeChoiceModel;
import com.liangke.mvvm.model.QueryFavoriteCommodityModel;
import com.liangke.mvvm.rxbing.FreeChoiceBing;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.message.SubscribeMessage;
import com.liangke.tcp.packet.QuoteRealPushBody;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/14.
 */

public class FreeChoiceViewModel extends BaseViewModel {

    private FreeChoiceFragment fragment;
    private FragmentFreechoiceBinding binding;
    private FreeChoiceModel model;
    private QueryFavoriteCommodityModel commodityModel;

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

    public FreeChoiceViewModel(FreeChoiceFragment fragment, FragmentFreechoiceBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        model = new FreeChoiceModel(fragment.getActivity(),observer);

        commodityModel = new QueryFavoriteCommodityModel(mContext,observer);

        FreeChoiceBing bing = new FreeChoiceBing(fragment.getActivity(),this,binding);

    }

    @Override
    public void init() {

        EventBus.getDefault().register(this);

        queryFavoriteCommodity();

        model.init(binding.rvList);


    }

    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof QueryFavoriteCommodityResponse){
            QueryFavoriteCommodityResponse response = (QueryFavoriteCommodityResponse) value;
            model.setmList(response.getData());

            List<SubscribeMessage.Subscribe> commodityList = new ArrayList<>();
            for(QueryFavoriteCommodityBean bean:response.getData()){

                    SubscribeMessage.Subscribe subscribe = new SubscribeMessage.Subscribe(bean.getCommodityCode(),bean.getProductId());
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

    public List<ProductSelectBean> getClissifyerList(){
        return ((MarketFragment)fragment.getParentFragment()).getClissifyerList();
    }

    public void queryFavoriteCommodity(){
        commodityModel.queryFavoriteCommodity();
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

    private void sendSubscribeMessage(List<SubscribeMessage.Subscribe> commdityList){
        SubscribeMessage.sendSubscribeMessage(commdityList);
    }


}
