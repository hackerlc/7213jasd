package com.liangke.base;

import android.content.Context;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by LK on 2017/12/12.
 */

public class BaseModel extends Common{

    public Observer mObserver;

    public BaseModel(Context context,Observer observer) {
        super(context);
        this.mObserver = observer;
    }


    public void sendResult(final Object object){
        if(mObserver!=null){
            Observable<Object> observable = new Observable<Object>() {

                @Override
                protected void subscribeActual(Observer<? super Object> observer) {

                    observer.onNext(object);
                    observer.onComplete();

                }
            };
            observable.subscribe(mObserver);
        }else{
            showToast("被观察者没有绑定");
        }

    }



}
