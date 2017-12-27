package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.os.Bundle;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.FragmentFreechoiceBinding;
import com.liangke.comprehensive.market.ChoiceAssetActivity;
import com.liangke.mvvm.viewmodel.FreeChoiceViewModel;

import java.io.Serializable;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/15.
 */

public class FreeChoiceBing extends BaseRxBing {
    private FreeChoiceViewModel viewModel;
    private FragmentFreechoiceBinding binding;
    public FreeChoiceBing(Context context,FreeChoiceViewModel viewModel,FragmentFreechoiceBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();

    }

    @Override
    public void initAction() {
        RxView.clicks(binding.llAdd).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) viewModel.getClissifyerList());
                mStartActivity(ChoiceAssetActivity.class,bundle);
            }
        });
    }
}
