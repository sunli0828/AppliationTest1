package com.bwie.sunli20181203.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bwie.sunli20181203.R;

/**
 * 写搜索发现的控件
 */

@SuppressLint("AppCompatCustomView")
public class FindView extends TextView {
    public FindView(Context context) {
        super(context);
    }

    public FindView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FindView);
        int color = typedArray.getColor(R.styleable.FindView_find_text_color, Color.DKGRAY);
        int size = typedArray.getInteger(R.styleable.FindView_fing_text_size, 24);

        setTextColor(color);//设置字体颜色
        setTextSize(size);  //设置字体大小

        //回收
        typedArray.recycle();
    }
}
