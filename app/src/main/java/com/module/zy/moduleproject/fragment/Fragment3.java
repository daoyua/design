package com.module.zy.moduleproject.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.module.zy.moduleproject.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment  recyle_list

        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        initView(view);
        return view;
    }
   ArrayList<String> data=new ArrayList<>();
    private void initView(View view) {
        RecyclerView recyle_list = view.findViewById(R.id.recyle_list);
        recyle_list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        recyle_list.addItemDecoration(new MyItemDecoration());
        recyle_list.setItemAnimator(new DefaultItemAnimator());

       for (int i=0;i<=20;i++){
           data.add("aaa"+i);
       }
        MyAdapter myAdapter=new MyAdapter(data);
        recyle_list.setAdapter(myAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        ArrayList<String> list = new ArrayList<>();
        public  MyAdapter(ArrayList<String> lists){
            list=lists;
        }
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.item_text, parent);
            MyAdapter.ViewHolder holder = new MyAdapter.ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.mText.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView mText;

            ViewHolder(View itemView) {
                super(itemView);
                mText = itemView.findViewById(R.id.item_tx);
            }
        }
    }

}
