package com.bwie.sunli20181128_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sunli20181128_test.view.CustomView;

public class ImageActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent i1 = new Intent(getIntent());
        String first_value = i1.getStringExtra("i1");
        String second_value = i1.getStringExtra("i2");
        String third_value = i1.getStringExtra("i3");

        CustomView customView = findViewById(R.id.custom_view);
        customView.setData(first_value, second_value, third_value);
    }
}
