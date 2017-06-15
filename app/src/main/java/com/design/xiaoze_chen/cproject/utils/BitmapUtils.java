package com.design.xiaoze_chen.cproject.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;

/**
 * Created by xiaoze on 2016/9/19.
 */
public class BitmapUtils {
    public LruCache<String, Bitmap> lruCache;
    static BitmapUtils bitmapUtils = new BitmapUtils();

    private BitmapUtils() {
        initLruCache();
    }

    public static BitmapUtils getBitmapUtilInstance() {
        return bitmapUtils;
    }

    private void initLruCache() {
        // 获取到可用内存的最大值，使用内存超出这个值会引起OutOfMemory异常。
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        // 一般情况，我们使用最大可用内存值的1/10作为缓存的大小即可。
        int cacheSize = maxMemory / 10;
        Log.e("CXZ", "类名:BitmapUtils , 方法名:initLruCache: cacheSize==" + cacheSize + "maxMemory==" + maxMemory);
        // LruCache通过构造函数传入缓存值，以KB为单位。
        lruCache = new LruCache<String, Bitmap>(cacheSize) {

            @Override
            protected int sizeOf(String key, Bitmap value) {
                // 重写此方法来衡量每张图片的大小。
                final int sizeOf = value.getByteCount();
                return sizeOf;
            }

            //强引用的缓存值达到预设定值之前，会从内存中移除最近较少用的对象。
            //这时候我们可以使用软引用保存起来被强引用移除的对象。留作备份。
            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                //被系统删除引起的才移到软引用。目前已不推荐使用
                if (evicted) {

                }
            }
        };
    }

    //添加Bitmap到LruCache中
    public void addBitmapToLruCache(String key, Bitmap bitmap) {
        if (getBitmapFromLruCache(key) == null) {
            lruCache.put(key, bitmap);
        }

    }

    //从Bitmap中取出Bitmap
    private Bitmap getBitmapFromLruCache(String key) {
        return lruCache.get(key);
    }

    /**
     * @param context 传入的上下文对象
     * @param id      图片资源的id
     * @return
     */
    public Bitmap getBitmap(Context context, int id, String key) {
        if (getBitmapFromLruCache(key) != null) {
            return getBitmapFromLruCache(key);
        }
        //获取屏幕宽高
        int newWidth = context.getResources().getDisplayMetrics().widthPixels;
        int newHight = context.getResources().getDisplayMetrics().heightPixels;
        //1.创建Options
        BitmapFactory.Options options = new BitmapFactory.Options();
        //2.解析BitMap的边缘
        options.inJustDecodeBounds = true;//设置只解析边缘
        /*
        * 三个参数：
        * 1.res
        * 2.图片id
        * 3.Options
        * */
        BitmapFactory.decodeResource(context.getResources(), id, options);
        //3.拿到图片的宽高
        int imageWidth = options.outWidth;
        int imageHeight = options.outHeight;
        //4.计算采样比
        int scaleX = imageWidth / newWidth;
        int scaleY = imageHeight / newHight;
        if (newHight > imageHeight || newWidth > imageHeight) {
            scaleX = 1;
            scaleY = 1;
        }
        //5.设置图片质量，及采样比
//        options.inPreferredConfig = Bitmap.Config.ALPHA_8;//8位的
//        options.inSampleSize = Math.min(scaleX, scaleY);
//        options.inSampleSize = 1;
        //真正解析
        options.inJustDecodeBounds = false;//真正解析内容
        //6.返回重新解析后的图片==========第二次采样=========
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id, options);
        Log.e("CXZ", "类名:BitmapUtils , 方法名:getBitmap: size" + bitmap.getByteCount());
        addBitmapToLruCache(key, bitmap);
        return bitmap;
    }

}
