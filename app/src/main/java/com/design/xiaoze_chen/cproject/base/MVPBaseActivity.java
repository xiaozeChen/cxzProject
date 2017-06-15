package com.design.xiaoze_chen.cproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.design.xiaoze_chen.cproject.presenter.BasePresenter;
import com.design.xiaoze_chen.cproject.view.MVPView;

import butterknife.ButterKnife;

/**
 * Created by xiaoze_chen on 2017/6/15.
 */

public abstract class MVPBaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attach((MVPView) this);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    public abstract T createPresenter();
    /**
     * 返回当前activity所显示的布局ID
     *
     * @return
     */
    public abstract int getContentViewId();

    /**
     * 初始化控件
     */
    protected void initView() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }
}
