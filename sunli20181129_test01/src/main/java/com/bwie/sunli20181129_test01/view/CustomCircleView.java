package com.bwie.sunli20181129_test01.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircleView extends View {

    Paint mPaint;
    int mCircleCount = 6;
    float mStartAngle = 0;

    RectF rectF;

    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        rectF = new RectF();
        rectF.top = 10;
        rectF.left = 10;
        rectF.right = 80;
        rectF.bottom = 80;
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(240, 240, 200, mPaint);
    }
}
