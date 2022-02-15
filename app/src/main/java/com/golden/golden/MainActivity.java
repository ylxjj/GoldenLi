package com.golden.golden;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.golden.golden.glide.GlideActivity;
import com.golden.golden.UI.UiActivity;
import com.golden.golden.okhttp.OkhttpActivity;
import com.golden.golden.permission.PermissionsCall;
import com.golden.golden.permission.PermissionsUtils;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by GoldenLi on 2022/1/3 0003 20:10.
 */
public class MainActivity extends Activity {

   Button button;
   Button Glidebtn;
    Button OKbtn;
   Button buttonui;
    private final static int requestCode = 111;
    private static final String TAG = "stf";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        //添加动态权限
        button=findViewById(R.id.bt_0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            //请求权限
                applyPermissions();

            }
        });

        Glidebtn=findViewById(R.id.bt_1);
        Glidebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, GlideActivity.class);
                startActivity(intent);
            }
        });

        buttonui=findViewById(R.id.bt_ui);
        buttonui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UiActivity.class));
            }
        });
        OKbtn=findViewById(R.id.bt_okhttp);
        OKbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OkhttpActivity.class));
            }
        });
// TODO: 2022/1/15 0015  多媒体实践
// TODO: 2022/1/16 0016   okhttp ref网络框架 实现mvp mvvm架构


    }
    public void applyPermissions() {
        List<String> list = new ArrayList<>();

        list.add(Manifest.permission.CAMERA);
        list.add(Manifest.permission.RECORD_AUDIO);
        PermissionsUtils.with(MainActivity.this)
                .permissions(list)
                .request(requestCode, new PermissionsCall() {
                    @Override
                    public void errorRequest(String errorMsg) {
                        Log.i(TAG, "errorRequest: " + errorMsg);
                    }

                    @Override
                    public void granted() {
                        Log.i(TAG, "granted: 全部通过");
                        Toast.makeText(MainActivity.this, "全部通过", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void denideList(List<String> list) {
                        Log.i(TAG, "denideList: " + list);
                        Toast.makeText(MainActivity.this, "部分权限未通过,允许后重试", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}