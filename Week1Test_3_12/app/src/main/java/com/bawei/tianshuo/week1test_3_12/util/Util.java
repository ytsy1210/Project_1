package com.bawei.tianshuo.week1test_3_12.util;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/3/12
 */

public class Util {
    public  static DisplayImageOptions displayImageOptions(int imageId){
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .showImageForEmptyUri(imageId)
                .showImageOnLoading(imageId)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        return  options;
    }
    public  static  String JsonResult(InputStream stream){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        int len=0;
        byte[] b=new byte[1024];
        try {
            while ((len=stream.read(b))!=-1){
                bos.write(b,0,len);
                bos.flush();
            }
            bos.close();
            stream.close();
            String str=bos.toString("utf-8").trim();
            return  str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
