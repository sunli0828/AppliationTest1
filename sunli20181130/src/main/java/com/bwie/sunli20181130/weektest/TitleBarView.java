package com.bwie.sunli20181130.weektest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bwie.sunli20181130.R;

public class TitleBarView extends LinearLayout {

    Context mContext;

    public TitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        //加载视图
        View view = View.inflate(mContext, R.layout.title, null);

        final EditText editText = view.findViewById(R.id.edit_title);

        view.findViewById(R.id.go).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //6.在将要回调的地方 判断非空
                if (mOnButtonClickListener != null) {
                    //7.执行回调
                    mOnButtonClickListener.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);

    }

    //3.成员变量
    OnButtonClickListener mOnButtonClickListener;

    //4.传入 给成员变量赋值
    //5.在想要接受回调的地方，调用set方法设置监听
    public void setmOnButtonClickListener(OnButtonClickListener OnButtonClickListener) {
        mOnButtonClickListener = OnButtonClickListener;
    }

    //1.定义接口
    public interface OnButtonClickListener {
        //2.方法及其回传参数
        void onButtonClick(String str);
    }
}
