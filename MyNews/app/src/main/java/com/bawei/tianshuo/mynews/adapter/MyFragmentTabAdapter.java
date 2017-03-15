package com.bawei.tianshuo.mynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/15
 */

public class MyFragmentTabAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private String[] titles;

    public MyFragmentTabAdapter(FragmentManager fm) {
        super(fm);
        this.list = list;
        this.titles = titles;
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
        return titles[position];
    }
}
