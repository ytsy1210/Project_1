package com.bawei.tianshuo.cehua.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.tianshuo.cehua.R;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/10
 */

public class Fragment1 extends Fragment {

    private TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment,null);
        initView(view);
        return  view;
    }
    public  void initView(View v){
         text= (TextView) v.findViewById(R.id.text);
        text.setText("界面");
        text.setTextColor(Color.BLUE);
    }
}
