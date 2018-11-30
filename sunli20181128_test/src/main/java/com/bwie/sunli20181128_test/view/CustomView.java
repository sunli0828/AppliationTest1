package com.bwie.sunli20181128_test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    Paint mPanit;
    private String b, c, d;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPanit = new Paint();
        mPanit.setStrokeWidth(5);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setData(String aa, String bb, String cc){
        b = aa;
        c = bb;
        d = cc;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(10, 10, 10,200, mPanit);


        canvas.drawLine(10, 200, 200, 200, mPanit);

        canvas.drawRect(30, Float.parseFloat(b), 60, 200, mPanit);
        mPanit.setColor(Color.RED);
        mPanit.setStyle(Paint.Style.FILL);

        canvas.drawRect(90, Float.parseFloat(c), 120, 200, mPanit);
        mPanit.setColor(Color.YELLOW);
        mPanit.setStyle(Paint.Style.FILL);
    }
}
