package com.bwie.sunli20181203.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 写历史记录的控件
 */

public class HistoryView extends LinearLayout {

    private int mHspace = 20;//上下间距
    private int mVspace = 20;//左右间距
    private int mChildMaxHeight;//最高孩子的高度

    public HistoryView(Context context) {
        super(context);
    }

    public HistoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量父容器
        int sizeWdith = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        //测量孩子的高度
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        findMaxChildHeight();//找到最高的孩子的高度的方法

        int left = 0, top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            //一行满了换到下一行
            if(left != 0) {
                if (left + view.getMeasuredWidth() > sizeWdith) {
                    top += view.getMeasuredWidth() + mVspace;
                    left = 0;
                }
            }
            left += view.getMeasuredWidth() + mHspace;
        }
        setMeasuredDimension(sizeWdith, (top + mChildMaxHeight) > sizeHeight ? sizeHeight : top + mChildMaxHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        findMaxChildHeight();//找到最高的孩子的高度的方法

        int left = 0, top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            //换行
            if(left != 0) {
                if (left + view.getMeasuredWidth() > getWidth()) {
                    top += view.getMeasuredWidth() + mVspace;
                    left = 0;
                }
            }
            //孩子的位置
            view.layout(left, top, left + view.getMeasuredWidth(), top + mChildMaxHeight);
            left += view.getMeasuredWidth() + mHspace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //找到最高的孩子的高度的方法
    private void findMaxChildHeight() {
        int childCount = getChildCount();
        mChildMaxHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight() > mChildMaxHeight) {
                mChildMaxHeight = view.getMeasuredHeight();
            }
        }

    }
}
