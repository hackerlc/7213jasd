package com.liangke.http.retrofit;

import android.content.Context;
import android.util.Log;

import com.liangke.constants.Constants;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by LK on 2017/12/11.
 */

public class MyRetrofit02 {

    private static final String TAG = MyRetrofit02.class.getSimpleName();

    private static Retrofit retrofit;

    private MyRetrofit02(final Context context){
        MyHttpLoggingInterceptor logInterceptor = new MyHttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(TAG,message);
            }
        });

        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        ConnectionPool pool = new ConnectionPool(Integer.MAX_VALUE/2, 3, TimeUnit.MINUTES);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json;charset=UTF-8")
                                .addHeader("Accept-Encoding", "gzip,deflate")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("Accept", "application/json,text/plain,*/*")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .cache(new Cache(new File(context.getExternalCacheDir(), "http_cache"), 1024 * 1024 * 300))
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(logInterceptor)
                .connectionPool(pool)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.LongURL)
                .client(httpClient)
                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance(Context context){
        if(retrofit==null){
            new MyRetrofit02(context);
        }
        return retrofit;
    }

    public static void init(Context context){
        if(retrofit==null){
            new MyRetrofit02(context);
        }
    }

    public static  <T>T  create(Class<T> service){
        return retrofit.create(service);
    }

}
