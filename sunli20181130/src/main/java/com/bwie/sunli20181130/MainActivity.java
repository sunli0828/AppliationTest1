package com.bwie.sunli20181130;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sunli20181130.sqlite.HistoryBean;
import com.bwie.sunli20181130.sqlite.HistoryDao;
import com.bwie.sunli20181130.week_test.CustomHotView;
import com.bwie.sunli20181130.week_test.CustomTitleBarView;
import com.bwie.sunli20181130.week_test.CustomWeekFlowView;
import com.bwie.sunli20181130.weektest.TitleBarView;
import com.bwie.sunli20181130.weektest.WeekFlowLayout;
import com.bwie.sunli20181130.weektest.WeekHotLayout;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private String hot[] = {"春风十里", "体测八百米", "海底两万里", "德芙巧克力", "香草味八喜",
            "可可布朗尼", "榴莲菠萝蜜", "芝士玉米粒", "鸡汁土豆泥", "黑椒牛里脊", "红烧排骨酱里脊"};
    private HistoryDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        final CustomWeekFlowView fl = findViewById(R.id.fl);

        CustomTitleBarView titleBar = findViewById(R.id.titleBar);
        titleBar.setmOnButtonClickListener(new CustomTitleBarView.onButtonClickListener() {
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

        final CustomHotView hl = findViewById(R.id.hl);
        for (int i = 0; i < hot.length; i++) {
            TextView tv1 = new TextView(MainActivity.this);
            tv1.setText(hot[i]);
            tv1.setTextColor(Color.BLACK);
            hl.addView(tv1);
        }

        dao = new HistoryDao(MainActivity.this);
        HistoryBean bean = new HistoryBean();
        dao.add(bean);
        findViewById(R.id.edit_delall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "已清空", Toast.LENGTH_SHORT).show();

            }
        });
    }
}