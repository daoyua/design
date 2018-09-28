package com.module.zy.base_feature.Base;


import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.module.zy.base_feature.R;

import androidx.appcompat.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    /***是否显示标题栏*/
    private boolean isshowtitle = true;
    /***是否显示标题栏*/
    private boolean isshowstate = true;
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        if (!isshowtitle) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (isshowstate) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        //设置布局
        setContentView(intiLayout());
        // 初始化控件
        initView();
        //设置数据
        initData();


    }


    protected abstract void initView();

    protected abstract BaseActivity getActivity();

    public abstract int intiLayout();

    public abstract int initData();

    /**
     * 是否设置标题栏     *     * @return
     */
    public void setTitle(boolean ishow) {
        isshowtitle = ishow;
    }

    /**
     * 设置是否显示状态栏     * @param ishow
     */
    public void setState(boolean ishow) {
        isshowstate = ishow;
    }

    /**
     * 显示长toast     * @param msg
     */
    public void toastLong(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 显示短toast     * @param msg
     */
    public void toastShort(String msg) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

}
