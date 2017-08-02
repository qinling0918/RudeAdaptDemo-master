package com.bulong.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Caodongyao on 2017/7/28.
 */

public class RudeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rude);
        Log.e("SK_rude","xdpi:"+getResources().getDisplayMetrics().xdpi+"..."+getScreenWidthPix(this));
        Log.e("SK_rude","xdpi:"+getResources().getDisplayMetrics().xdpi+"..."+getScreenWidthPix(this));

    }

    public void gotoWebView(View view){
        startActivity(new Intent(this, WebViewActivity.class));
    }

    public static int getScreenWidthPix(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
