package com.module.zy.moduleproject;

import android.app.Application;

import com.module.zy.moduleproject.rxjava2.RetrofitFactory;

public abstract class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitFactory.setHostUrl(initHostUrl());
    }
    public abstract String initHostUrl();
}
