package com.module.zy.moduleproject.rxjava2;

import android.text.TextUtils;
import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public  class RetrofitFactory {

    private  final String Tag ="RetrofitFactory错误" ;
    // 将构造函数改成private类型 避免外部创建对象 实现单例思想
    private  OkHttpClient.Builder builder;
    private  static String hostUrl;

    private static Retrofit retrofit;
    public static void setHostUrl(String URL){
        hostUrl=URL;
    }
    /**
     * 设置okhttp
     *
     * @param built
     */
    private void setOkhttpBuilt(OkHttpClient.Builder built) {
        builder = built;
    }

    public static Retrofit getRetrofit() {

        if(retrofit==null){
            if(TextUtils.isEmpty(hostUrl)){
                Log.e("错误","hostUrl没有设置");
            }

//            retrofit=  Rxtrofit2Instance.getInstanace(hostUrl);
            retrofit= Rxtrofit2Instance.getInstanace(hostUrl);
        }
        return  retrofit;
    }


}
