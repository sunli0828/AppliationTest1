package com.bwie.sunli20181129_test01.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomSmallCircleView extends View {

    Paint mPaint;
    int mCircleCount = 6;
    float mStartAngle = 0;

    RectF rectF;

    public CustomSmallCircleView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);


    }

    public CustomSmallCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(240, 240, 45, mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        canvas.drawText("开始", 210,250, mPaint);

    }
}
