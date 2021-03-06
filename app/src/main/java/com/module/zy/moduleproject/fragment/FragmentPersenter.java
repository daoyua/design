package com.module.zy.moduleproject.fragment;

import android.os.Bundle;

import com.module.zy.moduleproject.Fragment1.view.MainView;
import com.module.zy.moduleproject.retrofit2.response.UserResponse;
import com.module.zy.moduleproject.retrofit2.MynetworkManager;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.retrofit.CompositeDisposableInter;
import module.base.baseframwork.base.retrofit.SimpleSubscriber;
import module.base.baseframwork.base.rxbus.Event;
import module.base.baseframwork.untils.LogUtils;
import retrofit2.Retrofit;


public class FragmentPersenter extends BasePresenter<MainView> {
    private Retrofit retrofit;

    @Override
    public void onCreate() {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void onEvent(Event event) {

    }


    public void getdata() {

        // 3 创建接口的代理对象
        MynetworkManager.getData("绵阳市").filter(new Predicate<UserResponse>() {
            @Override
            public boolean test(UserResponse userResponse) throws Exception {
                return userResponse.getCityName().length() > 2;//过滤长度大于2的才通过
            }
        }).throttleFirst(2, TimeUnit.SECONDS)//只有第一次点击有效
                .debounce(1000, TimeUnit.SECONDS)
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
