package com.module.zy.moduleproject.retrofit2;

import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import module.base.baseframwork.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {
    // 将构造函数改成private类型 避免外部创建对象 实现单例思想
    private static OkHttpClient.Builder builder;

    /**
     * 设置okhttp
     *
     * @param built
     */
    private void setOkhttpBuilt(OkHttpClient.Builder built) {
        builder = built;
    }
    private static Retrofit getInstanace(String url) {

        if (builder == null) {
            //OKHttp进行超时设置
            builder = new OkHttpClient().newBuilder();
            builder.connectTimeout(10, TimeUnit.SECONDS); // 连接超时时间阈值
            builder.readTimeout(10, TimeUnit.SECONDS);   // 数据获取时间阈值
            builder.writeTimeout(10, TimeUnit.SECONDS);  // 写数据超时时间阈值

            builder.retryOnConnectionFailure(true);              //错误重连
            // Debug时才设置Log拦截器，才可以看到
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                        // 添加json数据拦截
                        new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                if (TextUtils.isEmpty(message)) return;
                                //如果收到响应是json才打印
                                String s = message.substring(0, 1);
                                if ("{".equals(s) || "[".equals(s)) {
                                    Log.e("后台:", message);
                                }
                            }
                        }
                );
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(interceptor);
            }
        }


        // 设置 公共请求参数 如 token 设备版本 软件版本 语言
//        builder.addInterceptor(new AddQueryParameterInterceptor());

        // 设置请求头 也是通过拦截器

        // 创建okhttpClient 将builder建立
        OkHttpClient okHttpClient = builder.build();

        // 2 创建 Retrofit实例
//        String baseUrl = GlobalVariable.SERVERDOMAIN;

        Retrofit retrofits = new Retrofit.Builder()
                .baseUrl(url)         //  *** baseUrl 中的路径(baseUrl)必须以 / 结束 ***
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofits;
    }
}