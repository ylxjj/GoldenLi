package com.golden.golden.mmkv;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.golden.golden.R;
import com.tencent.mmkv.MMKV;

public class MmkvActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mediarecorder);
        String rootDir=MMKV.initialize(this);
        MMKV mmkv=MMKV.defaultMMKV();
        mmkv.encode("Golden","123211231");  //支持int float byte数组 String
        String s= mmkv.decodeString("Golden");    //取出需要选择取出类型
        Log.i("golden", "onCreate: "+s);
    }

}
