package com.liangke.comprehensive.main;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.liangke.greendao.gen.DaoMaster;
import com.liangke.greendao.gen.DaoSession;
import com.liangke.http.retrofit.MyRetrofit;
import com.liangke.http.retrofit.MyRetrofit02;
import com.liangke.tcp.message.HandMessage;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by LK on 2017/12/9.
 */

public class MyApplication extends Application {

    private final String TAG = MyApplication.class.getSimpleName();

    public static MyApplication application;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();


        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "5a3dfc00b27b0a24d9000100");


        MyRetrofit.init(this);
        MyRetrofit02.init(this);

        application = this;
        setDatabase();


        HandMessage.sendHandMessage();

        initUmeng();


    }


    public static MyApplication getApplication() {
        return application;
    }

    /**     * 设置greenDao     */

    private void setDatabase() {

        // 通过DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为greenDAO 已经帮你做了。
        // 注意：默认的DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this,"notes-db", null);
        db =mHelper.getWritableDatabase();
        // 注意：该数据库连接属于DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }


    private void initUmeng(){
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i(TAG,"deviceToken=="+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.i(TAG,"onFailure=="+s+","+s1);
            }
        });
    }



}
