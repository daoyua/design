package com.module.zy.moduleproject;

import android.os.Bundle;

import com.module.zy.moduleproject.Fragment1.view.MainView;
import com.module.zy.moduleproject.retrofit2.GetUser;
import com.module.zy.moduleproject.retrofit2.response.UserResponse;
import com.module.zy.moduleproject.retrofit2.MynetworkManager;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.retrofit.CompositeDisposableInter;
import module.base.baseframwork.base.retrofit.RetrofitFactory;
import module.base.baseframwork.base.retrofit.SimpleSubscriber;
import module.base.baseframwork.base.rxbus.Event;
import module.base.baseframwork.untils.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainPersenter extends BasePresenter<MainView> {
    private Retrofit retrofit;

    @Override
    public void onCreate() {

//        RxBus.getDefault().post(new Event(10001,"message"));


    }


    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void onEvent(Event event) {
        LogUtils.e("data: " + event.getData().toString());
    }


    public void getdata() {
        RetrofitFactory.getRetrofit().create(GetUser.class).getUser().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
LogUtils.e(response.toString());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                LogUtils.e(call.toString());
            }
        });
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


    public void getdata1() {

        // 3 创建接口的代理对象
        MynetworkManager.getData("绵阳市").filter(userResponse -> {
                    return userResponse.getCityName().length() > 2;//过滤长度大于2的才通过
                }

        ).throttleFirst(2, TimeUnit.SECONDS)//只有第一次点击有效
                .debounce(1000, TimeUnit.SECONDS)//myCompositeDisposable.add(disposable); userResponse LogUtils.e(userResponse.toString());
                .subscribe(new SimpleSubscriber<UserResponse>() {
                    @Override
                    public CompositeDisposableInter initCompositeDisposableInter() {
                        return disposable1 -> myCompositeDisposable.add(disposable1);
                    }

                    @Override
                    public void call(UserResponse userResponse) {
                        LogUtils.e(userResponse.toString());
                    }
                });

    }

}
