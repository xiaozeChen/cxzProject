package com.design.xiaoze_chen.cproject.model;

import com.design.xiaoze_chen.cproject.bean.WeatherBean;
import com.design.xiaoze_chen.cproject.server.RetrofitInstance;
import com.design.xiaoze_chen.cproject.server.RetrofitServer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xiaoze_chen on 2017/6/14.
 */

public class RecycleModel implements MVPModel {

    public void loadCityWeatherData(Consumer<WeatherBean> action, String city) throws Exception {
        //真正的异步加载数据，加载完成后需要回调返回
            RetrofitServer service = RetrofitInstance.getService(RetrofitServer.class);
           service.getWeatherData(city).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(action);
    }
}
