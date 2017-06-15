package com.design.xiaoze_chen.cproject.presenter;

import com.design.xiaoze_chen.cproject.model.MVPModel;
import com.design.xiaoze_chen.cproject.view.MVPView;

import java.lang.ref.WeakReference;

/**
 * Created by xiaoze_chen on 2017/6/15.
 * 实现view和model的绑定和解绑
 */

public abstract class BasePresenter<V extends MVPView, M extends MVPModel> {
    private WeakReference<V> weakReferenceView;
    public M model;

    public BasePresenter() {
        model = createModel();
    }

    /**
     * 创建Mode
     *
     * @return
     */
    public abstract M createModel();

    /**
     * 绑定View
     *
     * @param v
     */
    public void attach(V v) {
        weakReferenceView = new WeakReference<V>(v);
    }

    /**
     * 解绑View
     */
    public void detach() {
        if (weakReferenceView != null) {
            weakReferenceView.clear();
            weakReferenceView = null;
        }
    }

    public V getView() {
        return weakReferenceView == null ? null : weakReferenceView.get();
    }

}
