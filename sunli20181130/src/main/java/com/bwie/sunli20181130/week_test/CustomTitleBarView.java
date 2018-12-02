package com.bwie.sunli20181130.week_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bwie.sunli20181130.R;

public class CustomTitleBarView extends LinearLayout {

    Context mContext;

    public CustomTitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CustomTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.titlebarview, null);

        final EditText editText = view.findViewById(R.id.edit_search);

        view.findViewById(R.id.btn_search).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //6.
                if (mOnButtonClickListener != null) {
                    //7.
                    mOnButtonClickListener.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }

    //3.
    onButtonClickListener mOnButtonClickListener;

    //4.
    //5.
    public void setmOnButtonClickListener(onButtonClickListener OnButtonClickListener) {
        mOnButtonClickListener = OnButtonClickListener;
    }

    //1.
    public interface onButtonClickListener {
        //2.
        void onButtonClick(String str);
    }
}
