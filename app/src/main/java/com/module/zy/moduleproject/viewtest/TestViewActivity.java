package com.module.zy.moduleproject.viewtest;

import android.os.Bundle;
import android.widget.Button;

import com.module.zy.moduleproject.R;

import androidx.appcompat.app.AppCompatActivity;

public class TestViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
        TestMoveView  testview= findViewById(R.id.testview);
        Button button= findViewById(R.id.button);
        MyView myView=new MyView(button);
//        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(myView,"width",500).setDuration(3500);
//        objectAnimator.start();
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f);//旋转360度
//        animator1.setRepeatCount(-1);
//        animator1.start();
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(testview, "translationX", 0.0f, 500f);//旋转360度
//        animator2.setRepeatCount(-1);
//        animator2.start();
    }
}