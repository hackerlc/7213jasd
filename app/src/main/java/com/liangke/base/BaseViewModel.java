package com.liangke.base;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by LK on 2017/12/12.
 */

public abstract class BaseViewModel extends Common {

    private final String TAG = BaseViewModel.class.getSimpleName();


    public BaseViewModel(Context context) {
        super(context);


    }

    //创建一个下游 Observer
    public Observer<Object> observer = new Observer<Object>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.d(TAG, "subscribe");
        }

        @Override
        public void onNext(Object value) {
            onRxJavaNext(value);
        }

        @Override
        public void onError(Throwable e) {
            onRxJavaError(e);
        }

        @Override
        public void onComplete() {
            onRxJavaComplete();
        }
    };


    /**
     * 初始化
     */
    public abstract void init();

    public abstract void onRxJavaNext(Object value);

    public abstract void onRxJavaError(Throwable e);

    public abstract void onRxJavaComplete();


}
