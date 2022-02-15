package com.golden.golden.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.golden.golden.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends Activity {

    Button btnsget;
    Button btnspost;
    Button btnaget;
    Button btnapost;
    TextView tvcallback;
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_okhttp);
        tvcallback=findViewById(R.id.tvcontent);
        btnsget=findViewById(R.id.sget);
        okHttpClient=new OkHttpClient();
        btnsget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               new Thread(){
                   @Override
                   public void run()
                   {
                       Request request=new Request.Builder().url("https://www.httpbin.org/get?mac=8a1&win=66f2").build();
                       Call call =okHttpClient.newCall(request);
                       try {
                           Response response=call.execute();
//                           tvcallback.setText(response.body().string());
                           Log.i("Golden",response.body().string());
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }.start();
            }
        });
        btnaget=findViewById(R.id.aget);
        btnaget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request request=new Request.Builder().url("https://www.httpbin.org/get?mac=8a1&win=66f2").build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful())
                        {
                            Log.i("Golden",response.body().string());
                        }
                    }
                });
            }
        });
        btnspost=findViewById(R.id.spost);
        btnspost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        FormBody formBody=new FormBody.Builder().add("win7","1709").add("win11","22H3").build();
                        Request request=new Request.Builder().url("https://www.httpbin.org/post").post(formBody).build();
                        Call call=okHttpClient.newCall(request);
                        try
                        {
                            Response response=call.execute();
                            Log.i("Golden",response.body().string());
                        }catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        btnapost=findViewById(R.id.apost);
        btnapost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FormBody formBody=new FormBody.Builder().add("win8","1809").add("win9","1907").build();
                Request request=new Request.Builder().url("https://www.httpbin.org/post").post(formBody).build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful())
                        {
                            Log.i("Golden",response.body().string());
                        }
                    }
                });
            }
        });
    }
}
