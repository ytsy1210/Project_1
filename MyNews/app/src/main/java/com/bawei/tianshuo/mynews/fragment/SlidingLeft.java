package com.bawei.tianshuo.mynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.tianshuo.mynews.R;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/15
 */

public class SlidingLeft extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sliding,null);
        return  view;
    }
}
