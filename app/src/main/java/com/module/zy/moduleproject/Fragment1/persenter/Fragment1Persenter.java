package com.module.zy.moduleproject.Fragment1.persenter;

import android.os.Bundle;

import com.module.zy.moduleproject.Fragment1.dataResponse.MainResponse;
import com.module.zy.moduleproject.Fragment1.module.MainModuleImpl;
import com.module.zy.moduleproject.Fragment1.view.MainView;

import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.rxbus.Event;


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

    @Override
    public void onEvent(Event event) {

    }


}
