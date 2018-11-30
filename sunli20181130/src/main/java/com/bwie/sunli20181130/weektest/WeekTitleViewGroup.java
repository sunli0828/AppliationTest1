package com.bwie.sunli20181130.weektest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.bwie.sunli20181130.R;

public class WeekTitleViewGroup extends LinearLayout {

    Context mContext;

    public WeekTitleViewGroup(Context context) {
        super(context);
        mContext = context;
    }

    public WeekTitleViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.title_week, null);
    }
}
