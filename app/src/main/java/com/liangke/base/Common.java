package com.liangke.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by LK on 2017/12/12.
 */

public class Common implements Base {

    public Context mContext;

    public Common(Context context) {
        mContext = context;
    }

    @Override
    public void showBufferDialog() {

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissBufferDialog() {

    }

    @Override
    public void mStartActivity(Class<?> mClass) {
        Intent intent = new Intent(mContext,mClass);
        mContext.startActivity(intent);
    }

    @Override
    public void mStartActivity(Class<?> mClass, Bundle bundle) {
        Intent intent = new Intent(mContext,mClass);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public void mStartActivityForResult(Class<?> mClass, int requestCode) {

    }

    @Override
    public void mStartActivityForResult(Class<?> mClass, Bundle bundle, int requestCode) {

    }
}
