package com.liangke.mvvm.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.FragmentOtherchoiceBinding;
import com.liangke.comprehensive.market.OtherChoiceFragment;
import com.liangke.http.response.CommoditySelectResponse;
import com.liangke.mvvm.bean.OtherChoiceBean;
import com.liangke.mvvm.bean.ProductBean;
import com.liangke.mvvm.model.CommodityQueryModel;
import com.liangke.mvvm.model.OtherChoiceModel;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.message.SubscribeMessage;
import com.liangke.tcp.packet.QuoteRealPushBody;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/21.
 */

public class OtherChoiceViewModel extends BaseViewModel {

    private final String TAG = OtherChoiceViewModel.class.getSimpleName();

    private OtherChoiceFragment fragment;
    private FragmentOtherchoiceBinding binding;
    private OtherChoiceModel model;
    private CommodityQueryModel queryModel;

    private String productId;
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

    public OtherChoiceViewModel(OtherChoiceFragment fragment, FragmentOtherchoiceBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        model = new OtherChoiceModel(fragment.getActivity(),observer);
        queryModel = new CommodityQueryModel(mContext,observer);

    }

    @Override
    public void init() {

        EventBus.getDefault().register(this);

        model.init(binding.rvList);

        commodityQuery();

    }

    public void commodityQuery(){
        queryModel.commodityQuery(productId);
    }

    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof CommoditySelectResponse){
            CommoditySelectResponse response = (CommoditySelectResponse) value;
            List<OtherChoiceBean> list = new ArrayList<>();
            if(response.getData()==null){
                return;
            }
            int total = 0;
            for(int i = 0;i<response.getData().size();i++){
                list.addAll(response.getData());
                total += list.get(i).getCommodityList().size();
            }
            model.setmList(list);

            Log.i(TAG,">>>>>>>>>>=="+total);

            List<SubscribeMessage.Subscribe> commodityList = new ArrayList<>();
            for(OtherChoiceBean choiceBean:list){
                for(ProductBean bean:choiceBean.getCommodityList()){
                    SubscribeMessage.Subscribe subscribe = new SubscribeMessage.Subscribe(bean.getCommodityNo(),bean.getProductId());
                    commodityList.add(subscribe);
                }
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
        Log.i(TAG,"list=="+commdityList.toString());
        SubscribeMessage.sendSubscribeMessage(commdityList);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
