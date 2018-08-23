package com.module.zy.moduleproject;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.module.zy.moduleproject.fragment.Fragment1;
import com.module.zy.moduleproject.fragment.Fragment2;
import com.module.zy.moduleproject.fragment.Fragment3;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar1;
    private CoordinatorLayout rootlayout;
    private NavigationView navigation;
    private CoordinatorLayout snakerview;
    private ViewPager viewpageer;
    private ArrayList<Fragment> listFragments = new ArrayList<>();
    private TabFragmentPagerAdapter fragmentPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        initFragment();
    }

    private void initview() {
        rootlayout = findViewById(R.id.rootlayout);
        Snackbar.make(rootlayout, "helloword", Snackbar.LENGTH_SHORT).show();

        toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

        snakerview = findViewById(R.id.container);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("tab3"));
        tabLayout.setupWithViewPager(new ViewPager(this));


        viewpageer = findViewById(R.id.viewpageer);


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

    }

    private void initFragment() {
        Fragment f1 = new Fragment1();
        Fragment f2 = new Fragment2();
        Fragment f3 = new Fragment3();
        listFragments.add(f1);
        listFragments.add(f2);
        listFragments.add(f3);

        fragmentPagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), listFragments);
        viewpageer.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewpageer);
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

    private void pageScrolled(int po) {
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
}
