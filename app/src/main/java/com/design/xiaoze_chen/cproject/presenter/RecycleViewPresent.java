package com.design.xiaoze_chen.cproject.presenter;

import com.design.xiaoze_chen.cproject.bean.WeatherBean;
import com.design.xiaoze_chen.cproject.model.RecycleModel;
import com.design.xiaoze_chen.cproject.view.RecycleMVPView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by xiaoze_chen on 2017/6/15.
 */

public class RecycleViewPresent extends BasePresenter<RecycleMVPView, RecycleModel> {
    @Override
    public RecycleModel createModel() {
        return new RecycleModel();
    }

    /**
     * 获取数据
     *
     * @param city
     */
    public void getWeatherData(String city) {
        try {
            model.loadCityWeatherData(new Consumer<WeatherBean>() {
                @Override
                public void accept(@NonNull WeatherBean weatherBean) throws Exception {
                    getView().showView(weatherBean);
                }

            }, city);
        } catch (Exception e) {
            getView().onError(e);
        }
    }
    //这里也可以写一些逻辑代码
}
