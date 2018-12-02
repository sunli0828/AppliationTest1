package com.bwie.sunli20181130.week_test;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomHotView extends LinearLayout {
    private int mChildMaxHeight;
    //左右间距  单位px
    private int mHspace = 20;
    //上下间距
    private int mVSpace = 20;

    public CustomHotView(Context context) {
        super(context);
    }

    public CustomHotView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //用Measure方法计算宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //父容器推荐的宽高和计算模式
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        //测量孩子的大小 ***
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        findMaxChildMaxHeight();

        int left = 0, top = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (left != 0) {
                if ((left + view.getMeasuredWidth()) > sizeWidth) {
                    top += mChildMaxHeight + mVSpace;
                    left = 0;
                }
            }
            left += view.getMeasuredWidth() + mHspace;
        }
        setMeasuredDimension(sizeWidth,
                (top + mChildMaxHeight) > sizeHeight ? sizeHeight : top + mChildMaxHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildMaxHeight();

        int left = 0, top = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (left != 0) {
                if ((left + view.getMeasuredWidth()) > getWidth()) {
                    top += mChildMaxHeight + mVSpace;
                    left = 0;
                }
            }
            view.layout(left, top, left + view.getMeasuredWidth(), top + mChildMaxHeight);
            left += view.getMeasuredWidth() + mHspace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //寻找最高的孩子
    private void findMaxChildMaxHeight() {
        mChildMaxHeight = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight() > mChildMaxHeight) {
                mChildMaxHeight = view.getMeasuredHeight();
            }
        }
    }
}
