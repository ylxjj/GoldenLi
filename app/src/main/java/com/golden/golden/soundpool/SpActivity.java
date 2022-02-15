package com.golden.golden.soundpool;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.golden.golden.R;

public class SpActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_soundpool);
    }
}
