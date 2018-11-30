package com.bwie.sunli.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bwie.sunli.R;

public class CustomView extends View {

    Paint mPaint;
    int mPaintColor = Color.BLUE;

    float mTouchX, mTouchY;
    private String b;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
     //   TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
       // String str = typedArray.getString(R.styleable.CustomCircleView_text);

        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //获取点击位置的x,y
                    mTouchX = event.getX();
                    mTouchY = event.getY();
                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    //获取点击位置的x,y
                    mTouchX = event.getX();
                    mTouchY = event.getY();
                }

                invalidate();
                return true;
            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(10, 10, 10,200, mPaint);

        canvas.drawLine(10, 200, 200, 200, mPaint);

        canvas.drawRect(Float.parseFloat(b), 150, 65, 200, mPaint);
    }
}
