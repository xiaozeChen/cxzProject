package com.design.xiaoze_chen.cproject.view.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.design.xiaoze_chen.cproject.R;
import com.design.xiaoze_chen.cproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_ptr_recycleView)
    Button btnPtrRecycleView;
    @BindView(R.id.btn_ptr_ListView)
    Button btnPtrListView;
    @BindView(R.id.btn_ptr_NestedScrollView)
    Button btnPtrNestedScrollView;
    @BindView(R.id.btn_ptr_scrollView)
    Button btnPtrScrollView;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {
        super.initData();

    }

    @OnClick({R.id.btn_ptr_recycleView, R.id.btn_ptr_ListView, R.id.btn_ptr_NestedScrollView, R.id.btn_ptr_scrollView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_ptr_recycleView:
                startActivity(new Intent(MainActivity.this, RecycleViewActivity.class));
                break;
            case R.id.btn_ptr_ListView:
                break;
            case R.id.btn_ptr_NestedScrollView:
                break;
            case R.id.btn_ptr_scrollView:
                break;
        }
    }
}
