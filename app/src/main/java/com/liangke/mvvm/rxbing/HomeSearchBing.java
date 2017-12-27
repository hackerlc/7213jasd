package com.liangke.mvvm.rxbing;

import android.content.Context;

import com.jakewharton.rxbinding2.view.RxView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.databinding.ActivityHomesearchBinding;
import com.liangke.mvvm.viewmodel.HomeSearchViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by LK on 2017/12/22.
 */

public class HomeSearchBing extends BaseRxBing {
    private HomeSearchViewModel viewModel;
    private ActivityHomesearchBinding binding;
    public HomeSearchBing(Context context,HomeSearchViewModel viewModel,ActivityHomesearchBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {

        RxView.clicks(binding.tvOk).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {

                viewModel.newsPages(binding.etSearch.getText().toString().trim());
            }
        });

    }
}
