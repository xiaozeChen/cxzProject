package com.design.xiaoze_chen.cproject.server;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaoze_chen on 2017/6/14.
 */

public class RetrofitInstance {
    private static Retrofit builder = new Retrofit.Builder()
            .baseUrl(API.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static  <T> T getService(Class<T> tClass) throws Exception {
        return builder.create(tClass) ;
    }
}
