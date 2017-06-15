package com.design.xiaoze_chen.cproject.view.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.design.xiaoze_chen.cproject.R;
import com.design.xiaoze_chen.cproject.base.MVPBaseActivity;
import com.design.xiaoze_chen.cproject.bean.WeatherBean;
import com.design.xiaoze_chen.cproject.presenter.RecycleViewPresent;
import com.design.xiaoze_chen.cproject.ptr.CustomSwipeRefreshLayout;
import com.design.xiaoze_chen.cproject.view.RecycleMVPView;

import butterknife.BindView;

/**
 * Created by xiaoze_chen on 2017/6/14.
 */

public class RecycleViewActivity extends MVPBaseActivity<RecycleViewPresent> implements RecycleMVPView {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srl)
    CustomSwipeRefreshLayout srl;

    @Override
    public RecycleViewPresent createPresenter() {
        return new RecycleViewPresent();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_recycleview;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {
        super.initData();
        presenter.getWeatherData("上海");
    }

    @Override
    public void showView(WeatherBean weatherBean) {
        Log.e("CXZ", "类名:RecycleViewActivity , 方法名:showView: " + weatherBean);
    }

    @Override
    public void onError(Exception e) {
        Log.e("CXZ", "类名:RecycleViewActivity , 方法名:onError: "+e);
    }
}
