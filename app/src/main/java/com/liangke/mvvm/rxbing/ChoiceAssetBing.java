package com.liangke.mvvm.rxbing;

import android.content.Context;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.ActivityChoiceassetBinding;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/15.
 */

public class ChoiceAssetBing extends BaseRxBing {
    private ActivityChoiceassetBinding binding;
    public ChoiceAssetBing(Context context,ActivityChoiceassetBinding binding) {
        super(context);
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {
        RxView.clicks(binding.bOk).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
                showToast("选好了");
            }
        });
    }
}
