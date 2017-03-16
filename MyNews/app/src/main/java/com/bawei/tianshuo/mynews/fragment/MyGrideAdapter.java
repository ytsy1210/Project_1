package com.bawei.tianshuo.mynews.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.bawei.tianshuo.mynews.R;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/15
 */

public class MyGrideAdapter  extends BaseAdapter{
    private Context context;
    private String[] topics;

    public MyGrideAdapter(Context context, String[] topics) {
        this.context = context;
        this.topics = topics;
    }

    @Override
    public int getCount() {
        return topics.length;
    }

    @Override
    public Object getItem(int position) {
        return topics[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_home_topic_gride,null);
            holder=new ViewHolder();
            holder.button= (Button) convertView.findViewById(R.id.button_home_topic_grid);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.button.setText(topics[position]);
        return convertView;
    }
    class ViewHolder{
        Button button;
    }
}
