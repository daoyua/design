package com.module.zy.moduleproject;

public  class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
//        RetrofitFactory.setHostUrl("http://gc.ditu.aliyun.com");
    }

    @Override
    public String initHostUrl() {
        return "http://gc.ditu.aliyun.com";
    }
}
