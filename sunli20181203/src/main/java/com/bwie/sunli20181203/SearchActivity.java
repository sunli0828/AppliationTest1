package com.bwie.sunli20181203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.sunli20181203.bean.SearchBean;
import com.bwie.sunli20181203.dao.SearchDao;
import com.bwie.sunli20181203.view.FindView;
import com.bwie.sunli20181203.view.HistoryView;
import com.bwie.sunli20181203.view.TitleBarView;

import java.util.List;
import java.util.UUID;

public class SearchActivity extends AppCompatActivity {

    private SearchDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();//定义一个加载视图的方法
    }

    private void initView() {

        final HistoryView historyView = findViewById(R.id.history_view);
        TitleBarView titleBarView = findViewById(R.id.titlebar_view);

        //搜索发现
        for (int i = 0; i < 30; i++) {
            TextView textView2 = new TextView(SearchActivity.this);
            textView2.setText("发现"+i);

            findViewById(R.id.find_view);
        }

        //连接数据库
        dao = new SearchDao(getBaseContext());
        //添加
        final List<SearchBean> select = dao.select();
        for (int i = 0; i < select.size(); i++) {
            TextView textView = new TextView(SearchActivity.this);
            textView.setText(select.get(i).getTitle());
            historyView.addView(textView);
            final int index = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this, select.get(index).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        findViewById(R.id.text_delall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // dao.delAll(select.get(index).getUuid());
                historyView.removeAllViews();
            }
        });

        titleBarView.setClickListener(new TitleBarView.onButtonClickListener() {
            @Override
            public void onButtonClick(String str) {
                UUID uuid = UUID.randomUUID();
                TextView textView1 = new TextView(SearchActivity.this);
                textView1.setText(str);
                historyView.addView(textView1);
            }
        });


    }
}
