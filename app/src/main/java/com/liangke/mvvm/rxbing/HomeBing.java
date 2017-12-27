package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.view.Gravity;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.FragmentHomeBinding;
import com.liangke.comprehensive.home.HomeSearchActivity;
import com.liangke.comprehensive.market.SearchActivity;
import com.liangke.mvvm.viewmodel.HomeViewModel;
import com.liangke.popupwindow.AddKindPopupWindow;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/22.
 */

public class HomeBing extends BaseRxBing {
    private HomeViewModel viewModel;
    private FragmentHomeBinding binding;
    public HomeBing(Context context,HomeViewModel viewModel,FragmentHomeBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {

        RxView.clicks(binding.llSearch).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(HomeSearchActivity.class);
            }
        });

        RxView.clicks(binding.llAdd).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                AddKindPopupWindow addKindPopupWindow = new AddKindPopupWindow(mContext);
                addKindPopupWindow.setChannelList(viewModel.getNewsclassifierBeanList());
                addKindPopupWindow.showAtLocation(binding.llMain, Gravity.CENTER,0,0);
            }
        });

    }
}
