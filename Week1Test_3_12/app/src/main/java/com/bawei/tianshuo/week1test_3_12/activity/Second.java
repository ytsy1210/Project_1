package com.bawei.tianshuo.week1test_3_12.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.bawei.tianshuo.week1test_3_12.R;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/12
 */

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.webview);
        WebView web= (WebView) findViewById(R.id.web);
        Intent intent=getIntent();
        web.loadUrl(intent.getStringExtra("item"));
        
    }
}
