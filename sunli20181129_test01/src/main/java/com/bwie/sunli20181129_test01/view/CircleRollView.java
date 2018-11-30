package com.bwie.sunli20181129_test01.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleRollView extends View {

    float[] mAngles;
    RectF mRectF;
    Paint mPaint;
    float mStartAngle = 0;

    public CircleRollView(Context context) {
        super(context);
        init();
    }

    public CircleRollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setData(float[] angles){
        mAngles = angles;
    }

    private void init() {

        mPaint = new Paint();
        mPaint.setColor(Color.RED);

        mPaint.setStrokeWidth(10);

        mPaint.setStyle(Paint.Style.FILL);

        mRectF = new RectF();
        mRectF.top = 40;
        mRectF.bottom = 440;
        mRectF.right = 440;
        mRectF.left = 40;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i  <  mAngles.length; i++){
            if(i % 2 == 0 ){
                //角标为双数时，设置画笔颜色为蓝色
                mPaint.setColor(Color.BLUE);
            }else{
                //角标为单数时，设置画笔颜色为绿色
                mPaint.setColor(Color.GREEN);
            }

            canvas.drawArc(mRectF, mStartAngle, mAngles[i], true, mPaint);

            mStartAngle += mAngles[i];
        }
    }
}
