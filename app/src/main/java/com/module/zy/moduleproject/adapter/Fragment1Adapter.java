package com.module.zy.moduleproject.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.module.zy.moduleproject.Fragment1.dataResponse.MainResponse;
import com.module.zy.moduleproject.Fragment1.dataResponse.User;
import com.module.zy.moduleproject.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class Fragment1Adapter extends RecyclerView.Adapter<Fragment1Adapter.ViewHolder> {
    private  MainResponse datas ;
    private Activity activity ;
    public  Fragment1Adapter( Activity activitys){

        activity=activitys;
    }
    public void setData(MainResponse datass){
        datas=datass;
        notifyDataSetChanged();
    }
    @Override
    public Fragment1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_fragment1, parent,false);
        Fragment1Adapter.ViewHolder holder = new Fragment1Adapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Fragment1Adapter.ViewHolder holder, int position) {
        ArrayList<User> data = datas.getData();
        User user = data.get(position);
        holder.mText.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return datas.getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Button mText;

        ViewHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.item_bt);
        }
    }
}
