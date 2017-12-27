package com.liangke.mvvm.rxbing;

import android.content.Context;
import android.util.Log;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.liangke.base.BaseRxBing;
import com.liangke.comprehensive.R;
import com.liangke.comprehensive.databinding.ActivityRegisterBinding;
import com.liangke.constants.Constants;
import com.liangke.http.response.ResponseBody;
import com.liangke.mvvm.viewmodel.RegisterViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;

import static java.util.Calendar.SECOND;

/**
 * Created by LK on 2017/12/14.
 */

public class RegisterBing extends BaseRxBing {

    private final String TAG = RegisterBing.class.getSimpleName();

    private RegisterViewModel viewModel;
    private ActivityRegisterBinding binding;
    private String phone,code,passwoard,confirmPassword;
    public RegisterBing(Context context, RegisterViewModel viewModel,ActivityRegisterBinding binding) {
        super(context);
        this.viewModel = viewModel;
        this.binding = binding;
        initAction();
    }

    @Override
    public void initAction() {

        final Observable<CharSequence> phoneObservable = RxTextView.textChanges(binding.etPhone);
        Observable<CharSequence> codeObservale = RxTextView.textChanges(binding.etCode);
        final Observable<CharSequence> passwordObservable = RxTextView.textChanges(binding.etPassword);
        Observable<CharSequence> confirmPasswordObservale = RxTextView.textChanges(binding.etPasswordConfirm);
        Observable.combineLatest(phoneObservable, codeObservale, passwordObservable, confirmPasswordObservale, new Function4<CharSequence, CharSequence, CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean apply(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, @NonNull CharSequence charSequence3, @NonNull CharSequence charSequence4) throws Exception {
                phone = charSequence.toString().trim();
                code =  charSequence2.toString().trim();
                passwoard = charSequence3.toString().trim();
                confirmPassword = charSequence4.toString().trim();
                return !phone.isEmpty()&&!code.isEmpty()&&!passwoard.isEmpty()&&!confirmPassword.isEmpty();
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(@NonNull Boolean aBoolean) throws Exception {
                binding.bOk.setEnabled(aBoolean);
                if(aBoolean){
                    binding.bOk.setBackgroundResource(R.drawable.bg_shape_cornor_solid_blue_02);
                }else{
                    binding.bOk.setBackgroundResource(R.drawable.bg_shape_cornor_solid_gray);
                }
            }
        });

        RxView.clicks(binding.tvSendCode).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {

                  String phone = binding.etPhone.getText().toString().trim();
                  if(phone.isEmpty()){
                     showToast("请输入手机号");
                      return;
                  }
                  viewModel.getRegisterCode(binding.etPhone.getText().toString().trim());
                  binding.tvSendCode.setEnabled(false);
                  Observable.interval(0,1,TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                          .take(Constants.COUNTDOWN)
                          .subscribe(new Observer<Long>() {
                      @Override
                      public void onSubscribe(@NonNull Disposable d) {

                      }

                      @Override
                      public void onNext(@NonNull Long aLong) {
                          binding.tvSendCode.setText(""+(Constants.COUNTDOWN-aLong-1)+"s");
                      }

                      @Override
                      public void onError(@NonNull Throwable e) {

                      }

                      @Override
                      public void onComplete() {
                          binding.tvSendCode.setText("获取验证码");
                          binding.tvSendCode.setEnabled(true);
                      }
                  });

            }
        });

        RxView.clicks(binding.bOk).subscribe(new Consumer<Object>() {

            @Override
            public void accept(@NonNull Object o) throws Exception {
//                viewModel.checkMobile(phone,code);
                viewModel.register();
            }
        });

    }
}
