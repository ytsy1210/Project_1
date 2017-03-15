package com.bawei.tianshuo.mynews.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.bawei.tianshuo.mynews.R;
import com.bawei.tianshuo.mynews.fragment.FragmentAttention;
import com.bawei.tianshuo.mynews.fragment.FragmentHome;
import com.bawei.tianshuo.mynews.fragment.FragmentView;
import com.bawei.tianshuo.mynews.fragment.SlidingLeft;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton radioButton_home;
    private RadioButton radioButton_view;
    private RadioButton radioButton_attention;
    private FrameLayout frameLayout;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    private FragmentAttention fragmentAttention;
    private FragmentView fragmentView;
    private FragmentHome fragmentHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initSliding();
        initData();
    }

    private void initData() {
        fragmentHome = new FragmentHome();
        fragmentView = new FragmentView();
        fragmentAttention = new FragmentAttention();
        manager = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,fragmentHome);
        fragmentTransaction.add(R.id.frameLayout,fragmentView);
        fragmentTransaction.add(R.id.frameLayout,fragmentAttention);
        fragmentTransaction.show(fragmentHome);
        fragmentTransaction.hide(fragmentView);
        fragmentTransaction.hide(fragmentAttention);
        radioButton_home.setChecked(true);
        fragmentTransaction.commit();
    }

    private void initView() {
        radioButton_home = (RadioButton) findViewById(R.id.radioButton_home);
        radioButton_view = (RadioButton) findViewById(R.id.radioButton_view);
        radioButton_attention = (RadioButton) findViewById(R.id.radioButton_attention);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        radioButton_home.setOnClickListener(this);
        radioButton_view.setOnClickListener(this);
        radioButton_attention.setOnClickListener(this);
    }

    private void initSliding() {
        SlidingMenu menu=new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        //设置阴影
        menu.setShadowDrawable(R.drawable.a30);
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

    private void initFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.menu,new SlidingLeft()).commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.radioButton_home:
                fragmentTransaction.show(fragmentHome);
                fragmentTransaction.hide(fragmentView);
                fragmentTransaction.hide(fragmentAttention);
                fragmentTransaction.commit();
                break;
            case R.id.radioButton_view:
                fragmentTransaction.hide(fragmentHome);
                fragmentTransaction.show(fragmentView);
                fragmentTransaction.hide(fragmentAttention);
                fragmentTransaction.commit();
                break;
            case R.id.radioButton_attention:
                fragmentTransaction.hide(fragmentHome);
                fragmentTransaction.hide(fragmentView);
                fragmentTransaction.show(fragmentAttention);
                fragmentTransaction.commit();
                break;
        }
    }
}
