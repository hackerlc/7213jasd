package com.liangke.mvvm.viewmodel;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.liangke.adapter.ChoiceAssetAdapter;
import com.liangke.base.BaseViewModel;
import com.liangke.chart.ChartData;
import com.liangke.comprehensive.databinding.FragmentMarketBinding;
import com.liangke.comprehensive.market.FreeChoiceFragment;
import com.liangke.comprehensive.market.MarketFragment;
import com.liangke.comprehensive.market.OtherChoiceFragment;
import com.liangke.http.response.ProductSelectResponse;
import com.liangke.mvvm.bean.ProductSelectBean;
import com.liangke.mvvm.model.CommodityQueryModel;
import com.liangke.mvvm.model.MarketModel;
import com.liangke.mvvm.model.ProductQueryModel;
import com.liangke.mvvm.rxbing.MarketBing;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.packet.QuoteRealPushBody;
import com.liangke.utils.FragmentSwitchUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/14.
 */

public class MarketViewModel extends BaseViewModel {
    private MarketFragment fragment;
    private FragmentMarketBinding binding;
    private ProductQueryModel selectModel;
    private MarketModel model;

    private List<ProductSelectBean> newsclassifierBeen = new ArrayList<>();

    public MarketViewModel(MarketFragment fragment, FragmentMarketBinding binding) {
        super(fragment.getActivity());
        this.fragment = fragment;
        this.binding = binding;
        MarketBing bing = new MarketBing(mContext,this,binding);

        model = new MarketModel(mContext,observer);
        selectModel = new ProductQueryModel(mContext,observer);

    }

    @Override
    public void init() {

        productSelect();

    }

    public void productSelect(){
        selectModel.productQuery();
    }


    @Override
    public void onRxJavaNext(Object value) {
        if(value instanceof ProductSelectResponse){

            ProductSelectResponse response = (ProductSelectResponse) value;
            if(response.getData()==null){
                return;
            }
            ProductSelectBean selectBean = new ProductSelectBean();
            selectBean.setName("自主");
            selectBean.setId("0");
            response.getData().add(0,selectBean);
            newsclassifierBeen.addAll(response.getData());
            model.initClassify(newsclassifierBeen,binding.hllList);
            model.initFragment(newsclassifierBeen,binding.flFragment.getId(),fragment);
        }
    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }


    public List<ProductSelectBean> getNewsclassifierBeen() {
        return newsclassifierBeen;
    }

    public void setNewsclassifierBeen(List<ProductSelectBean> newsclassifierBeen) {
        this.newsclassifierBeen = newsclassifierBeen;
    }
}
