package com.module.zy.moduleproject.retrofit2;

import com.module.zy.moduleproject.requestInterface.GetUser;
import com.module.zy.moduleproject.response.UserResponse;

import io.reactivex.Observable;
import module.base.baseframwork.base.retrofit.MyNetWorkObsrvable;
import module.base.baseframwork.base.retrofit.RetrofitFactory;
import retrofit2.Retrofit;

public  class  MynetworkManager {
    public static Retrofit retrofit=RetrofitFactory.getRetrofit();
   private static GetUser getUser = retrofit.create(GetUser.class);
    public  static Observable<UserResponse> getData(String address){
//        GetUser getUser = retrofit.create();

        Observable<UserResponse> aaa = MyNetWorkObsrvable.compose(getUser.getUserPostRxandroid(address));
        return  aaa;
    }
}
