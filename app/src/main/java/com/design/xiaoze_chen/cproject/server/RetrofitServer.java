package com.design.xiaoze_chen.cproject.server;

import com.design.xiaoze_chen.cproject.bean.BrandBean;
import com.design.xiaoze_chen.cproject.bean.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xiaoze_chen on 2017/6/14.
 */

public interface RetrofitServer {
    /**
     * 获取城市的天气数据
     *
     * @param city 城市的名称
     * @return
     */
    @GET("weather_mini")
    Observable<WeatherBean> getWeatherData(@Query("city") String city);

    @GET("car/brand")
    Observable<BrandBean> getBrandBeanData(@Query("Authorization") String appCode);
}
