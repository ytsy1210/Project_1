package com.bawei.tianshuo.mynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.tianshuo.mynews.R;
import com.bawei.tianshuo.mynews.activity.MainActivity;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/15
 */

public class HomeDisplay extends Fragment {
    private View view;
    private MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        activity= (MainActivity) getActivity();
        if (view==null){
            view=inflater.inflate(R.layout.viewpager_home_display,null);
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
        TextView textView= (TextView) view.findViewById(R.id.text_home_display);
        Bundle bundle=getArguments();
        textView.setText(bundle.getString("title"));
    }
}
