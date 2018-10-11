package com.module.zy.moduleproject.retrofit2;

import android.nfc.Tag;
import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import module.base.baseframwork.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitFactory {

    private static final String Tag ="RetrofitFactory错误" ;
    private RetrofitInstance
    private static  Retrofit retrofit = RetrofitInstance.(hostUrl);
    static String hostUrl;

   abstract String initHostUrl();



    public Retrofit getRetrofit(String host) {
        hostUrl =initHostUrl();
        return Instanace.retrofit;
    }

}
