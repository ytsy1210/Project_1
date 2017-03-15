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

public class FragmentView extends Fragment {
    private  View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (view==null){
           view=inflater.inflate(R.layout.fragment_view,null);
       }
       ViewGroup parent= (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        return view;
    }
}
