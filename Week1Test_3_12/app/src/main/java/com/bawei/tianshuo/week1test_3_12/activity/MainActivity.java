package com.bawei.tianshuo.week1test_3_12.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.tianshuo.week1test_3_12.R;
import com.bawei.tianshuo.week1test_3_12.fragment.Fragment1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] title;
    private String[] url;
    private TabLayout tab;
    private ViewPager viewPager;
    private ArrayList<Fragment1> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        title = new String[] { "头条", "社会", "国际", "国内",
                "娱乐", "体育", "军事"};
        url = new String[]{"http://v.juhe.cn/toutiao/index?type=toutiao&key=32b9973df2e6ee0c2bf094b61c7d7844"
        ,"http://v.juhe.cn/toutiao/index?type=shehui&key=32b9973df2e6ee0c2bf094b61c7d7844"
        ,"http://v.juhe.cn/toutiao/index?type=guonei&key=32b9973df2e6ee0c2bf094b61c7d7844"
        ,"http://v.juhe.cn/toutiao/index?type=guoji&key=32b9973df2e6ee0c2bf094b61c7d7844"
        ,"http://v.juhe.cn/toutiao/index?type=yule&key=32b9973df2e6ee0c2bf094b61c7d7844"
        ,"http://v.juhe.cn/toutiao/index?type=tiyu&key=32b9973df2e6ee0c2bf094b61c7d7844"
        ,"http://v.juhe.cn/toutiao/index?type=junshi&key=32b9973df2e6ee0c2bf094b61c7d7844"};
     initView();
     initData();

    }

    private void initData() {

        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        //添加标签数据
        for (int i = 0; i <title.length; i++) {
            Bundle bundle =new Bundle();
            bundle.putString("arg",url[i]);
            Fragment1 fragment=new Fragment1();
            fragment.setArguments(bundle);
            list.add(fragment);
            tab.addTab(tab.newTab().setText(title[i]));
        }
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
        tab.setTabsFromPagerAdapter(adapter);
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.table);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

}
