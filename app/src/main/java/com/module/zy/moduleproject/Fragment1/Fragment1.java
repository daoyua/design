package com.module.zy.moduleproject.Fragment1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.module.zy.moduleproject.Fragment1.dataResponse.MainResponse;
import com.module.zy.moduleproject.Fragment1.view.MainView;
import com.module.zy.moduleproject.R;
import com.module.zy.moduleproject.adapter.Fragment1Adapter;
import com.module.zy.moduleproject.Fragment1.persenter.Fragment1Persenter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import module.base.baseframwork.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseFragment <Fragment1Persenter> implements MainView {

    Fragment1Persenter fragment1Persenter;
    private RecyclerView recyclerView;
    private Fragment1Adapter adapter;


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
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new Fragment1Adapter(getActivity());
        recyclerView.setAdapter(adapter);
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

    @Override
    public void showdata(MainResponse response) {
        adapter.setData(response);
    }
}