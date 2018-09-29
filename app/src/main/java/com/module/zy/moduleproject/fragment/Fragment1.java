package com.module.zy.moduleproject.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import module.base.baseframwork.base.BaseFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.module.zy.moduleproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseFragment <Fragment1Persenter> {

    Fragment1Persenter fragment1Persenter;
    private RecyclerView recyclerView;


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragment1, container, false);
//    }

    @Override
    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_fragment1, viewGroup, false);
        recyclerView = view.findViewById(R.id.f1_recyleview);
        return view;
    }

    @Override
    public Fragment1Persenter initPresenter() {
        fragment1Persenter=new Fragment1Persenter();
        return fragment1Persenter;
    }

    @Override
    public void isNightMode(boolean b) {

    }
}
