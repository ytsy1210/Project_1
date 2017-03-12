package com.bawei.tianshuo.cehua.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.tianshuo.cehua.R;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/10
 */

public class Left extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.left,null);
        return  view;
    }
}
