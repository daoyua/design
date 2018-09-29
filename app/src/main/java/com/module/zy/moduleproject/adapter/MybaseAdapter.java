package com.module.zy.moduleproject.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by zy on 2016/3/27.
 */
public class MybaseAdapter<T> extends BaseAdapter {
    ArrayList<T> list=new ArrayList<>();
    public void setData(ArrayList<T> list){

        this.list=list;
        notifyDataSetChanged();
    };
    public void addData(ArrayList<T> list){
        if(this.list==null){
            this.list=new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    };

    public ArrayList<T> getList(){
    return list;
    };
    public void clearData(){
        this.list.removeAll(list);
        notifyDataSetChanged();
    };
    @Override
    public int getCount() {
        if(list==null){
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if(list==null){
            return null;
        }
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
