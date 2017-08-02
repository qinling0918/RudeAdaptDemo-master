package com.bulong.demo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Caodongyao on 2017/7/28.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        resetDensity();
    }

    @Override
    //横竖屏的切换等Configuration变化会导致更新Resources，需要重新处理一下
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        resetDensity();
    }
    public final static float DESIGN_WIDTH = 750;
    //更改DisplayMetrics为我们想要的与屏幕宽度相关的比例
    public void resetDensity(){
    /*    Point size = new Point();
        WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            display.getSize(size);
        }else {
            size.x = display.getWidth();
            size.y = display.getHeight();
        }
        Log.e("SK","size,x:"+size.x+",y:"+size.y);
        Log.e("SK_old","xdpi:"+getResources().getDisplayMetrics().xdpi);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        dm.xdpi = size.x/DESIGN_WIDTH*72f;*/
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);

        getResources().getDisplayMetrics().xdpi = dm.widthPixels/DESIGN_WIDTH*72f;

        Log.e("SK+","xdpi:"+getResources().getDisplayMetrics().xdpi+"///"+dm.xdpi+"////"+getScreenWidthPix(this));
        //windowManager.getDefaultDisplay().getMetrics(dm);
        //Log.e("SK","xdpi:"+getResources().getDisplayMetrics().xdpi+"///"+dm.xdpi);
    }


    //将pt转换为px值
    public float pt2px(int value){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, value, getResources().getDisplayMetrics());
    }

    public static int getScreenWidthPix(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
    //dm.xdpi = (float) 14.400001;
}
