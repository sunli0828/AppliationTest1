package com.bwie.sunli20181203.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bwie.sunli20181203.R;

/**
 * 自定义搜索控件
 */
public class TitleBarView extends LinearLayout {
    
    Context mContext;
    
    public TitleBarView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }
    //写一个加载视图的方法
    private void init() {
        View view = View.inflate(mContext, R.layout.view_titlebar, null);
        final EditText editText = view.findViewById(R.id.edit_search);
        //点击按钮设置监听事件
        view.findViewById(R.id.btn_search).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    onButtonClickListener buttonClickListener;

    public void setClickListener(onButtonClickListener clickListener) {
        buttonClickListener = clickListener;
    }
    //定义一个接口
    public interface onButtonClickListener {
        void onButtonClick(String str);
    }
}
