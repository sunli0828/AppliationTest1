package com.bwie.sunli20181130.week_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bwie.sunli20181130.R;

@SuppressLint("AppCompatCustomView")
public class CustomGroupNameView extends TextView {
    public CustomGroupNameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomWeekFlowView);
        int color = typedArray.getColor(R.styleable.CustomWeekFlowView_textcolor, Color.BLACK);

        setTextColor(color);

        //回收
        typedArray.recycle();
    }

    public CustomGroupNameView(Context context) {
        super(context);
    }
}
