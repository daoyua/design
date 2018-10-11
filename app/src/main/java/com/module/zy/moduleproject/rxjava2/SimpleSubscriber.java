package com.module.zy.moduleproject.rxjava2;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import retrofit2.HttpException;

public  abstract class SimpleSubscriber<T> implements Observer<T> {


    @Override
    public void onNext(T t) {//这里的是获得了数据,方法意思很明显,下一步干啥
        if (t != null) {//这里最好判断一下是否为null.
            call(t);
        } else {
            Log.e("请求失败:",  "连接失败");
        }
    }
    /**
     *因为具体的处理这里无法得知,所以抽象.
     */
    public abstract void call(T t);

    @Override
    public void onError(Throwable e) {
         if (e instanceof UnknownHostException) {
             Log.e("请求失败:",  "请打开网络");
        } else if (e instanceof SocketTimeoutException) {
             Log.e("请求失败:",  "请求超时");
        } else if (e instanceof ConnectException) {
             Log.e("请求失败:",  "连接失败");
        } else if (e instanceof HttpException) {
             Log.e("请求失败:",  "请求超时");
        }else {
             Log.e("请求失败:",  e.toString());
        }
        e.printStackTrace();

    }

    @Override
    public void onComplete() {

    }

}
