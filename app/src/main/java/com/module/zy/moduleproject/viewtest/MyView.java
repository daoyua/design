package com.module.zy.moduleproject.viewtest;

import android.view.View;

public  class MyView {
    private View target;

    public MyView(View target) {
        this.target = target;
    }
    public int getWidth(){
        return target.getLayoutParams().width;
    }
    public void setWidth(int width){
        target.getLayoutParams().width=width;
        target.requestLayout();
    }
}
