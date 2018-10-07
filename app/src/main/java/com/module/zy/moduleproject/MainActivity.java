package com.module.zy.moduleproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.module.zy.moduleproject.Fragment1.Fragment1;
import com.module.zy.moduleproject.fragment.Fragment2;
import com.module.zy.moduleproject.fragment.Fragment3;
import com.module.zy.moduleproject.requestInterface.GetUser;
import com.module.zy.moduleproject.response.UserResponse;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import module.base.baseframwork.base.activity.BaseActivity;
import module.base.baseframwork.base.activity.BaseActivityMVP;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivityMVP<MainPersenter> {



    private Toolbar toolbar1;

    private CoordinatorLayout rootlayout;
    private NavigationView navigation;
    private CoordinatorLayout snakerview;
    private ViewPager viewpageer;
    private ArrayList<Fragment> listFragments = new ArrayList<>();
    private TabFragmentPagerAdapter fragmentPagerAdapter;
    private TabLayout tabLayout;
    private MainPersenter mainPersenter;
    private Retrofit retrofit;


    @Override
                public int intiLayout () {
                    return R.layout.activity_main;
                }
                @Override
                protected MainPersenter initPresenter () {
                    mainPersenter = new MainPersenter();
                    return mainPersenter;

                }

    @Override
    protected void onCreateActivity(Bundle bundle) {

    }


    @Override
                protected void initView () {

                    rootlayout = findViewById(R.id.rootlayout);
                    Snackbar.make(rootlayout, "helloword", Snackbar.LENGTH_SHORT).show();

                    toolbar1 = findViewById(R.id.toolbar);
                    setSupportActionBar(toolbar1);

                    snakerview = findViewById(R.id.container);

                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
                    collapsingToolbarLayout.setTitle("Design Library");


                    navigation = findViewById(R.id.navigation);

                    navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            int id = menuItem.getItemId();

                            switch (id) {
                                case R.id.navItem1:

                                    Snackbar.make(snakerview, "hello 1", Snackbar.LENGTH_SHORT).show();
                                    break;
                                case R.id.navItem2:
                                    Snackbar.make(snakerview, "hello 2", Snackbar.LENGTH_SHORT).show();
                                    break;
                                case R.id.navItem3:
                                    Snackbar.make(snakerview, "hello 3", Snackbar.LENGTH_SHORT).show();
                                    break;
                                case R.id.navItem4:
                                    Snackbar.make(snakerview, "hello 4", Snackbar.LENGTH_SHORT).show();
                                    break;
                            }
                            return false;


                        }
                    });


                    initFragment();
        //test网路链接
        RetrofitFactory();
//            testRrtrofit();

    }

    private void testRrtrofit() {

        retrofit = new Retrofit.Builder().baseUrl("http://gc.ditu.aliyun.com").addConverterFactory(GsonConverterFactory.create()).build();
        GetUser getUser = retrofit.create(GetUser.class);
//        Call<UserResponse> user = getUser.getUser();
//        Call<UserResponse> user = getUser.getUser("绵阳市");
        Call<UserResponse> user = getUser.getUserPost("绵阳市");
        user.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.e("success:",response.body().toString());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("failed:",call.toString());
            }
        });
    }

    // 将构造函数改成private类型 避免外部创建对象 实现单例思想
    private void RetrofitFactory() {

        //OKHttp进行超时设置
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS); // 连接超时时间阈值
        builder.readTimeout(10, TimeUnit.SECONDS);   // 数据获取时间阈值
        builder.writeTimeout(10, TimeUnit.SECONDS);  // 写数据超时时间阈值

        builder.retryOnConnectionFailure(true);              //错误重连

        // Debug时才设置Log拦截器，才可以看到
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
                    // 添加json数据拦截
                    new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            if (TextUtils.isEmpty(message)) return;
                            //如果收到响应是json才打印
                            String s = message.substring(0, 1);
                            if ("{".equals(s) || "[".equals(s)) {
                                Log.e("收到响应:", message);
                            }
                        }
                    }
            );
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        // 设置 公共请求参数 如 token 设备版本 软件版本 语言
//        builder.addInterceptor(new AddQueryParameterInterceptor());

        // 设置请求头 也是通过拦截器

        // 创建okhttpClient 将builder建立
        OkHttpClient okHttpClient = builder.build();

        // 2 创建 Retrofit实例
//        String baseUrl = GlobalVariable.SERVERDOMAIN;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gc.ditu.aliyun.com")         //  *** baseUrl 中的路径(baseUrl)必须以 / 结束 ***
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        // 3 创建接口的代理对象
        GetUser getUser = retrofit.create(GetUser.class);
        Call<UserResponse> user = getUser.getUserPost("绵阳市");
        user.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                Log.e("success:",response.body().toString());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
//                Log.e("failed:",call.toString());
            }
        });
    }



    @Override
                protected BaseActivity getActivity () {
                    return this;
                }


                @Override
                public int initData () {
                    return 0;
                }


                private void initFragment () {
                    Fragment f1 = new Fragment1();
                    Fragment f2 = new Fragment2();
                    Fragment f3 = new Fragment3();
                    listFragments.add(f1);
                    listFragments.add(f2);
                    listFragments.add(f3);
                    viewpageer = findViewById(R.id.viewpageer);


                    fragmentPagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), listFragments);
                    viewpageer.setAdapter(fragmentPagerAdapter);

                    tabLayout = findViewById(R.id.tabLayout);

                    tabLayout.setupWithViewPager(viewpageer);
                    for (int i = 0; i < tabLayout.getTabCount(); i++) {
                        TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                        tabAt.setText("Tab" + i);
                    }

                    viewpageer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
//                viewpageer.setCurrentItem(position);
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
//        viewpageer.setCurrentItem(0);
                }

                private void pageScrolled ( int po){
                    switch (po) {
                        case 0:

                            break;
                        case 1:
                            break;
                        case 2:
                            break;

                    }
                    ;

                }

                @Override
                public void isNightMode ( boolean isNight){

                }
            }
