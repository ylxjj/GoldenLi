package com.golden.golden.mediaplayer;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.golden.golden.R;

public class MpActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mediaplayer);
    }
}
