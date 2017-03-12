package com.bawei.tianshuo.cehua.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.tianshuo.cehua.R;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/10
 */

public class HomeFragment extends Fragment {

    private ArrayList<Fragment1> list;
    private ArrayList<String> titles;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home,null);
        initView(view);
        return  view;
    }
    public void initView(View v){
        tabLayout = (TabLayout) v.findViewById(R.id.table);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        initData();
    }

    private void initData() {
        titles = new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
            titles.add("NO."+i+1);
        }
        list = new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
            Fragment1 fragment1=new Fragment1();
            list.add(fragment1);
        }

            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            //添加标签数据
        for (int i = 0; i < 7; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }

        MyAdapter adapter=new MyAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }
     class MyAdapter extends FragmentPagerAdapter{

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
             return titles.get(position);
         }
     }



}
