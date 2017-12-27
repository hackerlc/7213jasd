package com.liangke.mvvm.viewmodel;

import android.content.Context;

import com.liangke.base.BaseViewModel;
import com.liangke.comprehensive.databinding.ActivityRegisterBinding;
import com.liangke.comprehensive.register.RegisterActivity;
import com.liangke.constants.Constants;
import com.liangke.http.response.CheckMobileResponse;
import com.liangke.http.response.GetRegisterCodeResponse;
import com.liangke.mvvm.model.CheckMobileModel;
import com.liangke.mvvm.model.GetRegisterCodeModel;
import com.liangke.mvvm.model.RegisterModel;
import com.liangke.mvvm.rxbing.RegisterBing;

/**
 * Created by LK on 2017/12/14.
 */

public class RegisterViewModel extends BaseViewModel {

    private ActivityRegisterBinding binding;
    private GetRegisterCodeModel codeModel;
    private CheckMobileModel checkMobileModel;
    private RegisterModel registerModel;
    public RegisterViewModel(RegisterActivity activity, ActivityRegisterBinding binding) {
        super(activity);

        codeModel = new GetRegisterCodeModel(activity,observer);
        checkMobileModel = new CheckMobileModel(activity,observer);
        registerModel = new RegisterModel(activity,observer);

        RegisterBing bing = new RegisterBing(activity,this,binding);

        init();

    }

    @Override
    public void init() {

    }

    @Override
    public void onRxJavaNext(Object value) {

        if(value instanceof GetRegisterCodeResponse){
            GetRegisterCodeResponse response = (GetRegisterCodeResponse) value;
            if(response.getCode()== Constants.SUCCESS_CODE){
                showToast(response.getMsg());
            }
        }else if(value instanceof CheckMobileResponse){
            CheckMobileResponse response = (CheckMobileResponse) value;
            if(response.getCode()==Constants.SUCCESS_CODE){

            }
        }

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

    public void checkMobile(String mobile,String checkCode){
        checkMobileModel.checkMobile(mobile,checkCode);
    }

    public void register(){
        registerModel.register("测试","a123456","18368830317");
    }

}
