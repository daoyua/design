package com.module.zy.moduleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = this.getLayoutInflater().inflate(R.layout.snackbar_layout, null);
        FrameLayout test_f = findViewById(R.id.test_f);
        Snackbar.make(test_f, "hello world", Snackbar.LENGTH_LONG).show();

        initview();
    }

    private void initview() {
        toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

    }
}
