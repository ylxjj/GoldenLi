package com.golden.golden.UI;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.golden.golden.R;
import com.golden.golden.UI.MyUi.MyTextView;

/**
 * Created by GoldenLi on 2022/1/17 0017 23:58.
 */
public class UiActivity extends Activity {

    TextView textView;
    MyTextView textView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ui);
        //textview 阴影处理
        textView=findViewById(R.id.textView);
        textView.setTextColor(getResources().getColor(R.color.colorBlue));
        textView.setText("默认显示");
        textView.setSingleLine();
        textView.setShadowLayer(3,5,5,R.color.colorRed);

        //textview 跑马灯处理
        textView2=findViewById(R.id.textViewsinglelong);
        textView2.setMarqueeRepeatLimit(Integer.MAX_VALUE);    //重复次数
        textView2.setFocusable(true);                          //获取焦点
        textView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);  //允许长度
        textView2.setText("股公告但是：的哈斯皇帝啊实打实等哈四大还是的哈斯2300-0000，特此公告 用户永仓愉快的晒");
        textView2.setSingleLine();                             //单行显示
        textView2.setFocusableInTouchMode(true);               //设置触摸焦点
        // TODO: 2022/1/18 把控几个重要组件的常用属性，textview editview btn progressbar dialog
    }

}
