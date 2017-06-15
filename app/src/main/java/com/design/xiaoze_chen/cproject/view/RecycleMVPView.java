package com.design.xiaoze_chen.cproject.view;

import com.design.xiaoze_chen.cproject.bean.WeatherBean;

/**
 * Created by xiaoze_chen on 2017/6/15.
 * View接口定义
 */

public interface RecycleMVPView extends MVPView {
    void showView(WeatherBean weatherBean);

    void onError(Exception e);
}
