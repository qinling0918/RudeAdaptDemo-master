package com.bulong.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Caodongyao on 2017/7/28.
 */

public class NormalActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);


    }

    public void gotoWebView(View view){
        startActivity(new Intent(this, WebViewActivity.class));
    }

}
