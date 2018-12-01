package com.bwie.sunli20181130;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.sunli20181130.weektest.TitleBarView;
import com.bwie.sunli20181130.weektest.WeekFlowLayout;
import com.bwie.sunli20181130.weektest.WeekHotLayout;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private String hot[] = {"春风十里", "体测八百米", "海底两万里", "德芙巧克力", "香草味八喜",
            "可可布朗尼", "榴莲菠萝蜜", "芝士玉米粒", "鸡汁土豆泥", "黑椒牛里脊", "红烧排骨酱里脊"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        final WeekFlowLayout fl = findViewById(R.id.fl);

        TitleBarView titleBar = findViewById(R.id.titleBar);
        titleBar.setmOnButtonClickListener(new TitleBarView.OnButtonClickListener() {
            @Override
            public void onButtonClick(String str) {
                UUID uuid = UUID.randomUUID();
                TextView text_title = new TextView(MainActivity.this);
                text_title.setTag(uuid);
                text_title.setTextColor(Color.GRAY);
                text_title.setText(str);
                text_title.setBackgroundResource(R.drawable.edit_bg);
                fl.addView(text_title);

                text_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String uuid = String.valueOf(v.getTag());
                    }
                });
            }
        });

        final WeekHotLayout hl = findViewById(R.id.hl);
        for (int i = 0; i < hot.length; i++) {
            TextView tv1 = new TextView(MainActivity.this);
            tv1.setText(hot[i]);
            tv1.setTextColor(Color.BLACK);
          //  tv1.setPadding(10,10,10,10);
            hl.addView(tv1);
        }
    }
}





    /*final EditText editText = findViewById(R.id.et);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText(editText.getText());
                tv.setTextSize(18);
                tv.setTextColor(Color.GRAY);
                tv.setBackgroundResource(R.drawable.edit_bg);
                fl.addView(tv);
            }
        });*/
