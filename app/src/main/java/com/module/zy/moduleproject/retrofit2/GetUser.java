package com.module.zy.moduleproject.retrofit2;

import com.module.zy.moduleproject.retrofit2.response.UserResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetUser {

    //http://gc.ditu.aliyun.com/geocoding?a=苏州市"
    @GET("/geocoding?a=苏州市")
    Call<UserResponse>getUser();

    @GET("/geocoding")
    Call<UserResponse>getUser(@Query("a") String address);

    @FormUrlEncoded
    @POST("/geocoding")
    Call<UserResponse>getUserPost(@Field("a")String address);

    @FormUrlEncoded
    @POST("/geocoding")
    Observable<UserResponse> getUserPostRxandroid(@Field("a")String address);

}
