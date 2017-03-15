package com.bawei.tianshuo.mynews.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.tianshuo.mynews.R;
import com.bawei.tianshuo.mynews.activity.MainActivity;
import com.bawei.tianshuo.mynews.adapter.MyFragmentTabAdapter;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/15
 */

public class FragmentHome extends Fragment {
    private View view;
    private ImageView image_home_top_search;
    private TabLayout tabLayout_home_top;
    private ViewPager viewPager_home;
    private ArrayList<Fragment> homeList;
    private MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //对Fragment 进行判空处理，防止出现fragment错位,打出fragment布局
        if (view==null){
          view=inflater.inflate(R.layout.fragment_home,null);
      }
      ViewGroup parent= (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity= (MainActivity) getActivity();
        //初始化界面
        initView();
        //填充数据
        initData();
    }

    private void initData() {
        //标题栏
        String[] titles=new String[]{"推荐","热点","阳光宽频","北京","社会","头条号","问答","娱乐",
        "图片","科技","汽车","体育","财经","军事","国际","段子","趣图","美女","健康","正能量",
        "特卖","房价"};
        homeList = new ArrayList<>();
        tabLayout_home_top.setTabMode(TabLayout.MODE_SCROLLABLE);
        //添加标签数据
        for (int i = 0; i <titles.length; i++) {
            Bundle bundle =new Bundle();
            bundle.putString("title",titles[i]);
            HomeDisplay fragment=new HomeDisplay();
            fragment.setArguments(bundle);
            homeList.add(fragment);
            tabLayout_home_top.addTab(tabLayout_home_top.newTab().setText(titles[i]));
        }
        MyFragmentTabAdapter adapter=new MyFragmentTabAdapter(activity.getSupportFragmentManager());
        viewPager_home.setAdapter(adapter);
        tabLayout_home_top.setupWithViewPager(viewPager_home);
        tabLayout_home_top.setTabsFromPagerAdapter(adapter);
    }

    private void initView() {
        //找控件
        image_home_top_search = (ImageView) view.findViewById(R.id.image_home_top_search);
        //顶部导航
        tabLayout_home_top = (TabLayout) view.findViewById(R.id.tabLayout_home_top);
        //对应的viewPager
        viewPager_home = (ViewPager) view.findViewById(R.id.viewPager_home);
    }
}
