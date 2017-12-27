package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivityFindpasswordBinding;
import com.liangke.comprehensive.register.FindPasswordActivity;
import com.liangke.mvvm.model.GetRegisterCodeModel;

/**
 * Created by LK on 2017/12/19.
 */

public class FindPasswordViewModel extends BaseViewModel {
    private FindPasswordActivity activity;
    private ActivityFindpasswordBinding binding;
    private GetRegisterCodeModel codeModel;
    public FindPasswordViewModel(FindPasswordActivity activity,ActivityFindpasswordBinding binding) {
        super(activity);
        this.activity = activity;
        this.binding = binding;
        codeModel = new GetRegisterCodeModel(mContext,observer);

        init();
    }

    @Override
    public void init() {

    }

    @Override
    public void onRxJavaNext(Object value) {

    }

    @Override
    public void onRxJavaError(Throwable e) {

    }

    @Override
    public void onRxJavaComplete() {

    }

    public void getRegisterCode(String phone){
        codeModel.getRegisterCode(phone);
    }

}
