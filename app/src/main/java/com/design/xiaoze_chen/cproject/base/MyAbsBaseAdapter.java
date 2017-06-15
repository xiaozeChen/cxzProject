package com.design.xiaoze_chen.cproject.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 适配器的封装
 * Created by Ken on 2016/7/25.
 */
public abstract class MyAbsBaseAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> datas = new ArrayList<>();
    private int resId;//布局id

    public MyAbsBaseAdapter(Context context, int resId) {
        this.context = context;
        this.resId = resId;
    }

    /**
     * 设置数据源
     */
    public void setDatas(List<T> datas) {
        if (datas != null) {
            this.datas = datas;
            this.notifyDataSetChanged();
        }
    }

    /**
     * 追加数据
     *
     * @param datas
     */
    public void addDatas(List<T> datas) {
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    /**
     * 删除数据源
     *
     * @param position
     */
    public void deleteDatas(int position) {
        this.datas.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (datas != null) {
            return datas.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler = null;
        if (convertView != null) {
            viewHodler = (ViewHodler) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(resId, parent, false);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);
        }

        //为控件设置值
        bindDatas(viewHodler, datas,position);

        return convertView;
    }

    /**
     * 绑定数据
     */
    public abstract void bindDatas(ViewHodler viewHodler, List<T> data,int position);

    protected class ViewHodler {
        private View layoutView;
        private Map<Integer, View> map = new HashMap<>();

        public ViewHodler(View layoutView) {
            this.layoutView = layoutView;
        }

        public View getView(int id) {
            View view = null;
            if (map.containsKey(id)) {
                view = map.get(id);
            } else {
                view = layoutView.findViewById(id);
                map.put(id, view);
            }
            return view;
        }

        /**
         * 设置TextView
         *
         * @param id
         */
        public ViewHodler setTextView(int id, String value) {
            TextView tv = (TextView) this.getView(id);
            tv.setText(value);
            return this;
        }

        /**
         * 设置ImageView
         *
         * @param id
         * @param url
         * @return
         */
        public ViewHodler setImageView(int id, String url) {
            ImageView iv = (ImageView) this.getView(id);
            Glide.with(context).load(url).fitCenter().into(iv);
            return this;
        }

        /**
         * 设置圆形ImageView
         *
         * @param id
         * @param url
         * @return
         */
        public ViewHodler setCircleImageView(int id, String url) {
            final ImageView iv = (ImageView) this.getView(id);
            Glide.with(context).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    iv.setImageDrawable(circularBitmapDrawable);
                }
            });
            return this;
        }

        /**
         * 设置CheckBox
         * @param id
         * @param isCheck
         * @return
         */
        public ViewHodler setCheckBox(int id, boolean isCheck) {
            CheckBox checkBox = (CheckBox) this.getView(id);
            checkBox.setChecked(isCheck);
            return this;
        }

    }
}
