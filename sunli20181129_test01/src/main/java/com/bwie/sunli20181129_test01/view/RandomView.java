package com.bwie.sunli20181129_test01.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class RandomView extends TextView {
    public RandomView(Context context) {
        super(context);
        init();
    }

    public RandomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        changeText();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        });
    }

    int i = 0;

    private void changeText() {
        setText(String.valueOf(getRandom()));
        if (i % 2 == 0) {
            setBackgroundColor(Color.BLACK);
        } else {
            setBackgroundColor(Color.RED);
        }
        i++;
    }

    private int getRandom() {
        return (int) (Math.random() * 9000 + 1000);
    }
}
