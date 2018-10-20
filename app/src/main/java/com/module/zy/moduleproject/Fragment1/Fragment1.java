package com.module.zy.moduleproject.Fragment1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.module.zy.moduleproject.Fragment1.dataResponse.MainResponse;
import com.module.zy.moduleproject.Fragment1.dataResponse.User;
import com.module.zy.moduleproject.Fragment1.persenter.Fragment1Persenter;
import com.module.zy.moduleproject.Fragment1.view.MainView;
import com.module.zy.moduleproject.R;
import com.module.zy.moduleproject.adapter.TestAdapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import module.base.baseframwork.base.fragment.BaseFragment;
import module.base.baseframwork.base.recycleview.BaseLoadMoreHeaderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseFragment<Fragment1Persenter> implements MainView {

    Fragment1Persenter fragment1Persenter;
    private RecyclerView recyclerView;
    private TestAdapter testAdapter;
    private ArrayList<User> data;



    @Override
    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_fragment1, viewGroup, false);
        recyclerView = view.findViewById(R.id.f1_recyleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
//    BaseLoadMoreHeaderAdapter  OnLoadMoreListener=new BaseLoadMoreHeaderAdapter.OnLoadMoreListener() {
//        @Override
//        public void onLoadMore() {
//            testAdapter.addAll(data);
//        }
//    });
    @Override
    public void showdata( MainResponse response) {
        data = response.getData();
        testAdapter = new TestAdapter(mContext,recyclerView, data, R.layout.item_bt);
//        testAdapter.addAll(data);

        testAdapter.setOnLoadMoreListener(new BaseLoadMoreHeaderAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Toast.makeText(mContext,"hahahaha",Toast.LENGTH_SHORT).show();
                testAdapter.addAll(data);
                testAdapter.setLoading(false);
            }
        });
        testAdapter.setOnItemClickListener(new BaseLoadMoreHeaderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(mContext,i+data.get(i).getName(),Toast.LENGTH_SHORT).show();

            }
        });

        recyclerView.setAdapter(testAdapter);
    }
}
