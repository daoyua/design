package com.module.zy.moduleproject;

import android.os.Bundle;
import android.service.autofill.UserData;

import com.module.zy.moduleproject.Fragment1.view.MainView;
import com.module.zy.moduleproject.retrofit2.GetUser;
import com.module.zy.moduleproject.retrofit2.response.UserResponse;
import com.module.zy.moduleproject.retrofit2.MynetworkManager;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.retrofit.CompositeDisposableInter;
import module.base.baseframwork.base.retrofit.MyNetWorkObsrvable;
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

    public void getServer() {
        Observable<UserResponse> myObservable = RetrofitFactory.getRetrofit().create(GetUser.class).getUserPostRxandroid("绵阳");
        MyNetWorkObsrvable.compose(myObservable).subscribe(new SimpleSubscriber<UserResponse>() {
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
                LogUtils.e("获取数据成功:" + userResponse.toString());
            }
        });
    }


}
