package com.bawei.tianshuo.mynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.bawei.tianshuo.mynews.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/14
 */

public class Welcome extends AppCompatActivity {
    private int time=2;
    Timer timer=new Timer();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        timer.schedule(task,1000,1000);

      }
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time--;
                    if (time<0){
                        timer.cancel();
                        startActivity(new Intent(Welcome.this,MainActivity.class));
                    }
                }
            });
        }
    };

}
