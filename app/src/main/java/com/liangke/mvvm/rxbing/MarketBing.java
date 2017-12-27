package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.view.Gravity;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.FragmentMarketBinding;
import com.liangke.comprehensive.market.SearchActivity;
import com.liangke.comprehensive.market.SingleMarketActivity;
import com.liangke.mvvm.viewmodel.MarketViewModel;
import com.liangke.popupwindow.AddKindPopupWindow;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/14.
 */

public class MarketBing extends BaseRxBing {
    private MarketViewModel viewModel;
    private FragmentMarketBinding binding;
    public MarketBing(Context context,MarketViewModel viewModel,FragmentMarketBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {

        RxView.clicks(binding.ivAdd).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                AddKindPopupWindow addKindPopupWindow = new AddKindPopupWindow(mContext);
                addKindPopupWindow.setProductSelecteList(viewModel.getNewsclassifierBeen());
                addKindPopupWindow.showAtLocation(binding.llMain, Gravity.CENTER,0,0);
            }
        });


        //搜索
        RxView.clicks(binding.llSearch).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(SearchActivity.class);
            }
        });


    }
}
