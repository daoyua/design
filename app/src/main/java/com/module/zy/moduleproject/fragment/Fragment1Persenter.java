package com.module.zy.moduleproject.fragment;

import android.os.Bundle;

import com.module.zy.moduleproject.MainPage.dataResponse.MainResponse;
import com.module.zy.moduleproject.MainPage.module.MainModuleImpl;
import com.module.zy.moduleproject.MainPage.view.MainView;

import module.base.baseframwork.base.BasePresenter;

public class Fragment1Persenter extends BasePresenter<MainView> {
    MainModuleImpl mainModule = new MainModuleImpl();


    @Override
    public void onCreate() {
        if (mView != null) {
            MainResponse data = mainModule.getData();
            mView.showdata(data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
