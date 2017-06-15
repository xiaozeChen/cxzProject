package com.design.xiaoze_chen.cproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by xiaoze_chen on 2017/6/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
        initData();
    }

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
