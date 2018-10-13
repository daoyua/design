package com.module.zy.moduleproject;

import android.os.Bundle;

import com.module.zy.moduleproject.Fragment1.view.MainView;
import com.module.zy.moduleproject.response.UserResponse;
import com.module.zy.moduleproject.retrofit2.MynetworkManager;

import io.reactivex.disposables.Disposable;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.retrofit.CompositeDisposableInter;
import module.base.baseframwork.base.retrofit.SimpleSubscriber;
import module.base.baseframwork.untils.LogUtils;
import retrofit2.Retrofit;


public class MainPersenter extends BasePresenter<MainView> {
    private Retrofit retrofit;

    @Override
    public void onCreate() {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }


    public void getdata() {

        // 3 创建接口的代理对象
      MynetworkManager.getData("绵阳市")
                .subscribe(new SimpleSubscriber<UserResponse>() {
                    @Override
                    public CompositeDisposableInter initCompositeDisposableInter() {
                        return new CompositeDisposableInter() {
                            @Override
                            public void setDidposable(Disposable disposable) {
                                myCompositeDisposable.add(disposable);
                            }
                        };
                    }

                    @Override
                    public void call(UserResponse userResponse) {
                        LogUtils.e(userResponse.toString());
                    }
                });

    }


}
