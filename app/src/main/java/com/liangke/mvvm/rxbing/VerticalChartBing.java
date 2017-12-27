package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v4.content.ContextCompat;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.FragmentVerticalchartBinding;
import com.liangke.comprehensive.market.VerticalChartFragment;
import com.liangke.mvvm.viewmodel.VerticalChartViewModel;
import com.liangke.widget.TabManager;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/20.
 */

public class VerticalChartBing extends BaseRxBing {
    private VerticalChartViewModel viewModel;
    private FragmentVerticalchartBinding binding;
    public VerticalChartBing(Context context,VerticalChartViewModel viewModel,FragmentVerticalchartBinding binding) {
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
            RxView.clicks(binding.tvChange).subscribe(new Consumer<Object>() {

                @Override
                public void accept(@NonNull Object o) throws Exception {
                    viewModel.change();
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

        }

//        if(viewModel.getOrientation()==ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
//            RxView.clicks(binding.tvChange).subscribe(new Consumer<Object>() {
//
//                @Override
//                public void accept(@NonNull Object o) throws Exception {
//                    viewModel.change();
//                }
//            });
//        }else if(viewModel.getOrientation()==ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
//
//            RxView.clicks(binding.tvMa).subscribe(new Consumer<Object>() {
//
//                @Override
//                public void accept(@NonNull Object o) throws Exception {
//                    binding.tvMa.setTextColor(ContextCompat.getColor(mContext, R.color.black_01));
//                    binding.tvBoll.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
//                    viewModel.changChartKind(0);
//                }
//            });
//
//            RxView.clicks(binding.tvBoll).subscribe(new Consumer<Object>() {
//
//                @Override
//                public void accept(@NonNull Object o) throws Exception {
//                    binding.tvMa.setTextColor(ContextCompat.getColor(mContext,R.color.gray_01));
//                    binding.tvBoll.setTextColor(ContextCompat.getColor(mContext,R.color.black_01));
//                    viewModel.changChartKind(1);
//                }
//            });
//
//        }



    }
}
