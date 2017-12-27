package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.FragmentHorizontalchartBinding;
import com.liangke.mvvm.viewmodel.HorizontalChartViewModel;
import com.liangke.widget.TabManager;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/20.
 */

public class HorizontalChartBing extends BaseRxBing {
    private HorizontalChartViewModel viewModel;
    private FragmentHorizontalchartBinding binding;
    public HorizontalChartBing(Context context, HorizontalChartViewModel viewModel, FragmentHorizontalchartBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {

        binding.tllTab.getTabManager().setOnSelectedPositionListener(new TabManager.OnSelectedPositionListener() {
            @Override
            public void onSelectedPositionListener(int position) {
                viewModel.onSelectedPosition(position);
            }
        });

        RxView.clicks(binding.tvMa).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                binding.tvMa.setTextColor(ContextCompat.getColor(mContext,R.color.black_01));
                binding.tvBoll.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                viewModel.changChartKind(0);
            }
        });

        RxView.clicks(binding.tvBoll).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                binding.tvMa.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                binding.tvBoll.setTextColor(ContextCompat.getColor(mContext,R.color.black_01));
                viewModel.changChartKind(1);
            }
        });

    }
}
