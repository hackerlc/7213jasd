package com.liangke.http.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.liangke.http.callback.RetrofitCallBack;
import com.liangke.http.request.RequestParams;
import com.liangke.http.response.ResponseBody;
import com.liangke.http.service.ApiService;
import com.liangke.http.service.ApiService2;
import com.liangke.http.util.GenericsUtils;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LK on 2017/12/11.
 */

public class RetrofitUtils<T>{
    private final String TAG = RetrofitUtils.class.getSimpleName();
    private RetrofitUtils utils;

    private  Class<T> classOfT;

    public RetrofitUtils(Class<T> classOfT) {
       this.classOfT = classOfT;
    }


    public void enqueue(RequestParams params, final RetrofitCallBack<T> callBack){


        ApiService service  = null;
        ApiService2 service2 = null;
        if(params.getApiType()==0){
            service2 = MyRetrofit.create(ApiService2.class);
            service = MyRetrofit.create(ApiService.class);
        }else if(params.getApiType()==2){
            service2 = MyRetrofit02.create(ApiService2.class);
            service = MyRetrofit02.create(ApiService.class);
        }

        Call<String> call = null;


        Method method = getMethodParamTypes(service,params.getMethod());


        try {

            if(method!=null){
                call = (Call<String>) method.invoke(service,params.getMap());
            }else{
                method = getMethodParamTypes(service2,params.getMethod());
                call = (Call<String>) method.invoke(service2,params.getMap());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG,"Ex=="+e.getMessage());
        }

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    Object o = new Gson().fromJson(response.body(), classOfT);
                    callBack.onResponse((T) o);
            }
            @Override
            public void onFailure(Call<String> call, Throwable throwable) {

            }
        });
    }


    public static Method  getMethodParamTypes(Object classInstance, String methodName) {
        Method[]  methods = classInstance.getClass().getMethods();//全部方法
        for (int  i = 0;  i< methods.length; i++) {
            if(methodName.equals(methods[i].getName())){//和传入方法名匹配
              return methods[i];
            }
        }
        return null;
    }

}
