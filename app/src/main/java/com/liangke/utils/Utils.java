package com.liangke.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LK on 2017/12/11.
 */

public class Utils {

    // 网络状态
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }


    /*
     * 将时间转换为时间戳
     */
    public static long dateToStamp(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long ts = date.getTime();
        return ts;
    }

    public static float getFontScale(Context context, float spValue) {
        float fontSize = context.getResources().getDisplayMetrics().scaledDensity;
        float value = spValue * fontSize + 0.5f;
        return value;
    }

    public static int getScaleByDensity(Context context, int dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        int value = (int) (dpValue * scale + 0.5f);
        return value;
    }

}
