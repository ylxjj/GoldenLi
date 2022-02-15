package com.golden.golden.videoplayer;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.golden.golden.R;

public class VpActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_videoplayer);
    }
}
