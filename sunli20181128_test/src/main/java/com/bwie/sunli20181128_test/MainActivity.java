package com.bwie.sunli20181128_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.sunli20181128_test.*;

public class MainActivity extends AppCompatActivity {

    private EditText edit_first, edit_second, edit_third;
    private Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_first = findViewById(R.id.EDIT_FIRST);
        edit_second = findViewById(R.id.EDIT_SECOND);
        edit_third = findViewById(R.id.EDIT_THIRD);
        btn_ok = findViewById(R.id.BTN_OK);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FIRST_VALUE = edit_first.getText().toString().trim();
                String SECOND_VALUE = edit_first.getText().toString().trim();
                String THIRD_VALUE = edit_first.getText().toString().trim();

                if (FIRST_VALUE.equals("") || SECOND_VALUE.equals("") || THIRD_VALUE.equals("")) {
                    Toast.makeText(MainActivity.this, "请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                    intent.putExtra("i1", FIRST_VALUE);
                    intent.putExtra("i2", SECOND_VALUE);
                    intent.putExtra("i3", THIRD_VALUE);
                    startActivityForResult(intent, 100);
                }
            }
        });

    }
}
