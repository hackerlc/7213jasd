package com.liangke.mvvm.rxbing;

import android.content.Context;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.FragmentPositionBinding;
import com.liangke.comprehensive.position.ActionActivity;
import com.liangke.mvvm.viewmodel.PositionViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/26.
 */

public class PositionBing extends BaseRxBing {

    private PositionViewModel viewModel;
    private FragmentPositionBinding binding;

    public PositionBing(Context context,PositionViewModel viewModel,FragmentPositionBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {

        //买入
        RxView.clicks(binding.llBuy).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                mStartActivity(ActionActivity.class);
            }
        });

        //切换账户
        RxView.clicks(binding.llSwitch).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                viewModel.switchAccount();
            }
        });

    }
}
