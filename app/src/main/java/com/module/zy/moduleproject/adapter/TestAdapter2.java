package com.module.zy.moduleproject.adapter;

import android.content.Context;

import com.module.zy.moduleproject.Fragment1.dataResponse.User;
import com.module.zy.moduleproject.R;

import java.util.List;

import module.base.baseframwork.base.recycleview.BaseRecycleAdapter;
import module.base.baseframwork.base.recycleview.BaseViewHolder;

public class TestAdapter2 extends BaseRecycleAdapter<User> {
    public TestAdapter2(Context mContext, List<User> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
    }

    @Override
    protected void convert(Context context, BaseViewHolder baseViewHolder, User user) {
        baseViewHolder.setText(R.id.item_bt,user.getName());
    }
}
