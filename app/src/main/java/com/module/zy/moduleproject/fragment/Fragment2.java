package com.module.zy.moduleproject.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import module.base.baseframwork.base.fragment.BaseFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.module.zy.moduleproject.MainPersenter;
import com.module.zy.moduleproject.R;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends BaseFragment <MainPersenter>{


    public Fragment2() {
        // Required empty public constructor
    }



    @Override
    public View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {

        testRxjava();

        return layoutInflater.inflate(R.layout.fragment_fragment2, viewGroup, false);
    }

    private void testRxjava() {

           Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                    emitter.onNext("连载1");
                    emitter.onNext("连载2");
                    emitter.onNext("连载3");
                    emitter.onComplete();
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.e(TAG,"onSubscribe");
                        }

                        @Override
                        public void onNext(String s) {
                            Log.e(TAG,"onNext:"+s);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG,"onError="+e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            Log.e(TAG,"onComplete()");
                        }
                    });

    }

    @Override
    public MainPersenter initPresenter() {
        return new MainPersenter();
    }

    @Override
    public void isNightMode(boolean b) {

    }
}
