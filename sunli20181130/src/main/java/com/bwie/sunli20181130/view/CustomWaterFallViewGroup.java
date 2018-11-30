package com.bwie.sunli20181130.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.sunli20181130.R;

import java.util.ArrayList;
import java.util.List;

public class CustomWaterFallViewGroup extends LinearLayout {

    final int mMaxSize = 22;
    List<String> stringList = new ArrayList<>();
    Context mContext;

    public CustomWaterFallViewGroup(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CustomWaterFallViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
    }

    public void setData(List<String> stringList) {
        this.stringList = stringList;
        showData();
    }

    private void showData() {
        removeAllViews();
        LinearLayout linearLayout_h = (LinearLayout) View.inflate(mContext, R.layout.item_water_fall_h, null);
        addView(linearLayout_h);

        int len = 0;

        for (String str : stringList) {
            len += str.length();

            if (len > mMaxSize) {
                linearLayout_h = (LinearLayout) View.inflate(mContext, R.layout.item_water_fall_h, null);
                addView(linearLayout_h);
                len = str.length();
            }


            View view = View.inflate(mContext, R.layout.item_water_fall, null);
            TextView textView = view.findViewById(R.id.tv_item_water_fall);
            textView.setText(str);
            linearLayout_h.addView(view);

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
            layoutParams.weight = 1;
            view.setLayoutParams(layoutParams);
        }
    }
}
