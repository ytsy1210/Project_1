package com.bawei.tianshuo.cehua.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.tianshuo.cehua.R;
import com.bawei.tianshuo.cehua.fragment.HomeFragment;
import com.bawei.tianshuo.cehua.fragment.Left;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlidingMenu menu=new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
       // 填上这一行代码就会与Viewpager滑动产生冲突
        // menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置阴影图片
        menu.setShadowDrawable(R.drawable.a);
        //设置阴影图片的宽度
        menu.setShadowWidth(10);
        //SlidingMenu划出时主页面显示的剩余宽度
        menu.setBehindOffset(200);
        menu.setBehindOffsetRes(R.dimen.ww);
        menu.setBehindWidth(400);
        menu.setFadeDegree(0.5f);
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);
        initFragment();
    }
    private void initFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.menu,new Left()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,new HomeFragment()).commit();
    }
}
