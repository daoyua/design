package com.module.zy.moduleproject;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> listFragments;
    public TabFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        listFragments=list;

    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
