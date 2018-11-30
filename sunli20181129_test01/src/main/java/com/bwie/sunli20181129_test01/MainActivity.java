package com.bwie.sunli20181129_test01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;

import com.bwie.sunli20181129_test01.view.CircleRollView;
import com.bwie.sunli20181129_test01.view.CustomCircleView;
import com.bwie.sunli20181129_test01.view.CustomSmallCircleView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float[] angles = new float[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        final CircleRollView circleRollView = findViewById(R.id.circleroll);
        circleRollView.setData(angles);
        circleRollView.invalidate();
        CustomSmallCircleView smallCircleView = findViewById(R.id.smallcircle);

        smallCircleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float degrees = (float) (7200 + Math.random() * 1000);
                RotateAnimation rotateAnimation = new RotateAnimation(0, -degrees, 240,240);
                rotateAnimation.setDuration(5000);
                rotateAnimation.setFillAfter(true);
                circleRollView.startAnimation(rotateAnimation);
            }
        });


    }
}
