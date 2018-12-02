package com.bwie.sunli20181130.week_test;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomWeekFlowView extends LinearLayout {

    private int mChildMaxHeight;

    private int mHspace = 20; //左右
    private int mVspace = 20; //上下

    public CustomWeekFlowView(Context context) {
        super(context);
    }

    public CustomWeekFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //父容器推荐的宽高
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        //测量孩子的大小
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //找到最高的孩子的高度
        findMaxChildHeght();

        int left = 0, top = 0;

        //循环所有的孩子
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            //判断是否是一行的开头
            if (left != 0) {
                //换行
                if ((left + view.getMeasuredWidth()) > sizeWidth) {
                    //下一行的top  20
                    top += mChildMaxHeight + mVspace;
                    left = 0;
                }
            }
            left += view.getMeasuredWidth() + mHspace;
        }
        setMeasuredDimension(sizeWidth, (top + mChildMaxHeight) >
                sizeHeight ? sizeHeight : top + mChildMaxHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        findMaxChildHeght();

        int left = 0, top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            //判断是否是一行的开头
            if (left != 0) {
                //换行
                if ((left + view.getMeasuredWidth()) > getWidth()) {
                    //下一行的top  20
                    top += mChildMaxHeight + mVspace;
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

    private void findMaxChildHeght() {
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
