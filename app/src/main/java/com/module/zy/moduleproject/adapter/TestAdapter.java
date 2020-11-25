package com.module.zy.moduleproject.adapter;

import android.content.Context;

import com.module.zy.moduleproject.Fragment1.dataResponse.User;
import com.module.zy.moduleproject.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import module.base.baseframwork.base.recycleview.BaseLoadMoreHeaderAdapter;
import module.base.baseframwork.base.recycleview.BaseViewHolder;

public class TestAdapter  extends BaseLoadMoreHeaderAdapter<User> {
    public TestAdapter(Context mContext, RecyclerView recyclerView, List<User> mDatas, int mLayoutId) {
        super(mContext, recyclerView, mDatas,mLayoutId);
    }

    @Override
    public void convert(Context context, RecyclerView.ViewHolder viewHolder, User user) {
        if (viewHolder instanceof BaseViewHolder){
            ((BaseViewHolder) viewHolder).setText(R.id.item_bt,user.getName());
            if(user!=null&&user.getId()==0){
                ((BaseViewHolder) viewHolder).setText(R.id.item_bt,"拖动测试");
            }
            if(user!=null&&user.getId()==1){
                ((BaseViewHolder) viewHolder).setText(R.id.item_bt,"测试自定义1");
            }
        }
    }

}
