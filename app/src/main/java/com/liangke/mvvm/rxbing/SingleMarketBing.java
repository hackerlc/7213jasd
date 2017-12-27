package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityMarketBinding;
import com.liangke.mvvm.viewmodel.SingleMarketViewModel;
import com.liangke.widget.TabManager;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/21.
 */

public class SingleMarketBing extends BaseRxBing {
    private SingleMarketViewModel viewModel;
    private ActivityMarketBinding binding;
    public SingleMarketBing(Context context, SingleMarketViewModel viewModel, ActivityMarketBinding binding) {
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

        if(binding.tvChange!=null){
            //切换
            RxView.clicks(binding.tvChange).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    viewModel.change();
                }
            });

            //买入
            RxView.clicks(binding.llBuy).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    viewModel.buy();
                }
            });

            //关注
            RxView.clicks(binding.llAdd).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    viewModel.focus();
                }
            });


        }else{

            RxView.clicks(binding.llBack).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    viewModel.change();
                }
            });

            RxView.clicks(binding.tvMa).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    binding.tvMa.setTextColor(ContextCompat.getColor(mContext, R.color.black_01));
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

            RxView.clicks(binding.tvMacd).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    binding.tvMacd.setTextColor(ContextCompat.getColor(mContext,R.color.black_01));
                    binding.tvRsi.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                    binding.tvKdj.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                    viewModel.changChartKind(2);
                }
            });

            RxView.clicks(binding.tvRsi).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    binding.tvMacd.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                    binding.tvRsi.setTextColor(ContextCompat.getColor(mContext,R.color.black_01));
                    binding.tvKdj.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                    viewModel.changChartKind(3);
                }
            });
            RxView.clicks(binding.tvKdj).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    binding.tvMacd.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                    binding.tvRsi.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
                    binding.tvKdj.setTextColor(ContextCompat.getColor(mContext,R.color.black_01));
                    viewModel.changChartKind(4);
                }
            });


        }


    }
}
