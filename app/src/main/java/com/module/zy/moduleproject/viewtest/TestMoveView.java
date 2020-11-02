package com.module.zy.moduleproject.viewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;

public class TestMoveView extends FloatingActionButton {
    int lastX;
    int lastY;
    public TestMoveView(Context context) {
        super(context);
    }

    public TestMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        switch(event.getAction()){
        case MotionEvent.ACTION_DOWN :
            lastX=x;
            lastY=y;
            break;
            case MotionEvent.ACTION_MOVE:
                //计算移动距离
                int offsetX=x-lastX;
                int offsetY=y-lastY;
                //调用layout方法重新放置它的位置
//                layout(getLeft()+offsetX,getTop()+offsetY
//                ,getRight()+offsetX,getBottom()+offsetY);
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
//                ((View)getParent()).scrollBy(-offsetX,-offsetY);
//                System.out.println(event.getRawX()+":"+event.getRawY());
        break;

        }
        return true;
    }

}
