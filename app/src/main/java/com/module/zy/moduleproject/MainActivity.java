package com.module.zy.moduleproject;

import android.Manifest;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxbinding3.view.RxView;
import com.module.zy.moduleproject.Fragment1.Fragment1;
import com.module.zy.moduleproject.fragment.Fragment2;
import com.module.zy.moduleproject.fragment.Fragment3;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import module.base.baseframwork.base.activity.BaseActivity;
import module.base.baseframwork.base.activity.BaseActivityMVP;
import module.base.baseframwork.base.rxbus.Event;
import module.base.baseframwork.base.rxbus.RxBus;
import module.base.baseframwork.untils.LogUtils;

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


    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPersenter initPresenter() {
        mainPersenter = new MainPersenter();
        return mainPersenter;

    }
    public void getPermissions(FragmentActivity activity){
        RxPermissions rxPermissions=new RxPermissions(activity);
        RxView.clicks(findViewById(R.id.floading_button))
                .compose(rxPermissions.ensure(Manifest.permission.CAMERA,Manifest.permission.READ_PHONE_STATE))
                .subscribe(granted -> {
                    // R.id.enableCamera has been clicked
                    LogUtils.e(LogUtils.getThreadName()+"权限申请");
                });
    }


    @Override
    protected void onCreateActivity(Bundle bundle) {
        mainPersenter.getdata();
        mainPersenter.getdata1();
        mainPersenter.openRxbus();
        RxBus.getDefault().post(new Event(10001,LogUtils.getThreadName()+"aaaaaaaaaaaaaaa"));
        RxBus.getDefault().post(new Event(1000,LogUtils.getThreadName()+"bbbbb"));

        getPermissions(this);
    }


    @Override
    protected void initView() {
        rootlayout = findViewById(R.id.rootlayout);
        Snackbar.make(rootlayout, "helloword", Snackbar.LENGTH_SHORT).show();
        toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        snakerview = findViewById(R.id.container);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("Design Library");
        navigation = findViewById(R.id.navigation);
        LogUtils.e(LogUtils.getThreadName()+"测试log");

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
    }
    @Override
    protected BaseActivity getActivity() {
        return this;
    }



    private void initFragment() {
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

    @Override
    public void isNightMode(boolean isNight) {

    }
}
