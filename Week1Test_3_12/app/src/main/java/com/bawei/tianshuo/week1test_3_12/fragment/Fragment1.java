package com.bawei.tianshuo.week1test_3_12.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bawei.tianshuo.week1test_3_12.R;
import com.bawei.tianshuo.week1test_3_12.activity.MainActivity;
import com.bawei.tianshuo.week1test_3_12.activity.Second;
import com.bawei.tianshuo.week1test_3_12.bean.Bean;
import com.bawei.tianshuo.week1test_3_12.util.Util;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/12
 */

public class Fragment1 extends android.support.v4.app.Fragment {


    private View contextView;
    private MainActivity context;
    private ListView listView;
    private ArrayList<Bean.ResultBean.DataBean> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       contextView=inflater.inflate(R.layout.fragment,null);
        context= (MainActivity) getActivity();
        //获取Activity传递过来的参数
        initView(contextView);
        return contextView;
    }
    private void initView(View v) {
        listView = (ListView) contextView.findViewById(R.id.listView);
        Bundle mBundle = getArguments();
        String url= mBundle.getString("arg");
        Log.d("------------",url);
        MyAsyncTask task=new MyAsyncTask();
        task.execute(url);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(context, Second.class);
                intent.putExtra("item",list.get(position).getUrl());
                startActivity(intent);
            }
        });

    }


    class MyAdapter extends BaseAdapter{
    ArrayList<Bean.ResultBean.DataBean> list;

        public MyAdapter(ArrayList<Bean.ResultBean.DataBean> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(context,R.layout.item,null);
                 holder.image= (ImageView) convertView.findViewById(R.id.image);
                holder.text1= (TextView) convertView.findViewById(R.id.text1);
                holder.text2= (TextView) convertView.findViewById(R.id.text2);
                convertView.setTag(holder);
               }else {
                holder= (ViewHolder) convertView.getTag();
            }
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder.image, Util.displayImageOptions(R.mipmap.ic_launcher));
            holder.text1.setText(list.get(position).getTitle());
            holder.text2.setText(list.get(position).getAuthor_name());
            return convertView;
        }
     class ViewHolder{


         ImageView image;
         TextView text1;
         TextView text2;
     }
    }
    public class MyAsyncTask extends AsyncTask<String,Integer,String >{
        @Override
        protected String doInBackground(String... params) {

            String u=params[0];
            HttpClient client=new DefaultHttpClient();
            HttpGet request=new HttpGet(u);
            try {
                HttpResponse response=client.execute(request);
                if (response.getStatusLine().getStatusCode()==200){
                    InputStream stream=response.getEntity().getContent();
                    String json= Util.JsonResult(stream);
                    Log.i("=============",json);
                    return  json;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            Bean bean=gson.fromJson(s,Bean.class);
            list = (ArrayList<Bean.ResultBean.DataBean>) bean.getResult().getData();
            Log.i("==========",""+list.size());
            listView.setAdapter(new MyAdapter(list));
        }
    }

}
