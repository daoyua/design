package com.module.zy.moduleproject.adapter;

import android.content.Context;

import com.module.zy.moduleproject.Fragment1.dataResponse.User;
import com.module.zy.moduleproject.R;
import com.module.zy.moduleproject.recycleview.BaseLoadMoreHeaderAdapter;
import com.module.zy.moduleproject.recycleview.BaseViewHolder;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter  extends BaseLoadMoreHeaderAdapter<User> {
    public TestAdapter(Context mContext, RecyclerView recyclerView, List<User> mDatas, int mLayoutId) {
        super(mContext, recyclerView, mDatas,mLayoutId);
    }

    @Override
    public void convert(Context context, RecyclerView.ViewHolder viewHolder, User user) {
        if (viewHolder instanceof BaseViewHolder){
            ((BaseViewHolder) viewHolder).setText(R.id.item_bt,user.getName());
        }
    }
}
