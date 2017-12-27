package com.liangke.base;

import android.os.Bundle;

/**
 * Created by LK on 2017/12/12.
 */

public interface Base {

    public void showBufferDialog();
    public void showToast(String message);
    public void dismissBufferDialog();
    public void mStartActivity(Class<?> mClass);
    public void mStartActivity(Class<?> mClass, Bundle bundle);
    public void mStartActivityForResult(Class<?> mClass,int requestCode);
    public void mStartActivityForResult(Class<?> mClass,Bundle bundle,int requestCode);

}
