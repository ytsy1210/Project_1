package com.bawei.tianshuo.mynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.bawei.tianshuo.mynews.R;
import com.bawei.tianshuo.mynews.fragment.MyGrideAdapter;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/15
 */

public class HomeTopic extends AppCompatActivity {

    private ImageButton button_home_topic_back;
    private GridView gridView_home_topic_my;
    private GridView gridView_home_topic_suggest;
    private String[] topicMy;
    private String[] topicSuggest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_top_topic_gride);
        topicMy = new String[]{"推荐","热点","阳光宽频","北京","社会","头条号","问答","娱乐",
                "图片","科技","汽车","体育","财经","军事","国际","段子","趣图","美女","健康","正能量",
                "特卖","房价"};
        topicSuggest=new String[]{"小说","时尚","历史","育儿","搞笑","数码","美食","养生",
                                    "电影","手机","旅行","宠物","情感","家居","教育","三农",
                                    "孕产","文化","游戏","股票","科学","动漫","故事","收藏",
                                    "精选","语录","星座","美图","政务","辟谣","中国新唱将","彩票"};
        //初始化控件
        initView();

    }

    private void initView() {
        button_home_topic_back = (ImageButton) findViewById(R.id.button_home_topic_back);
        gridView_home_topic_my = (GridView) findViewById(R.id.gridView_home_topic_My);
        gridView_home_topic_suggest = (GridView) findViewById(R.id.gridView_home_topic_suggest);
       gridView_home_topic_my.setAdapter(new MyGrideAdapter(HomeTopic.this,topicMy));
        gridView_home_topic_suggest.setAdapter(new MyGrideAdapter(HomeTopic.this,topicSuggest));
        button_home_topic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeTopic.this,MainActivity.class));
            }
        });
    }
}
