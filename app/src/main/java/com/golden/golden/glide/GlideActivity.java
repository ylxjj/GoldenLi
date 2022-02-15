package com.golden.golden.glide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.golden.golden.R;


/**
 * Created by GoldenLi on 2022/1/8 0008 17:24.
 */
public class GlideActivity extends Activity {


    ImageView imageView;
    ImageView imageView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        imageView=findViewById(R.id.iv2);
                //Glide请求返回设置 placeholder 占位图 error 错误图 fallback  override尺寸
        RequestOptions requestOptions=new RequestOptions()
                .placeholder(R.drawable.placeh)
                .error(R.drawable.error)
                .fallback(R.drawable.error)
                .override(80,70);
        //Glide with 上下文 apply加入返回设置 transition 渐变效果 laod 路径 into指定控件id
        //tranform 图片转换 CircleCrop 圆角 roundedCorners 四个角度统一指定 granularRoundCorners 单独指定角度 Rotate旋转 只能作用于网络jpg
        Glide
                .with(this)
                .load("https://ss0.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3873386731,866153973&fm=15&gp=0.jpg")
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .transform(new CircleCrop())
                .into(imageView);

        imageView2=findViewById(R.id.iv);
        GlideApp
                .with(this)
                .load("https://ss0.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3873386731,866153973&fm=15&gp=0.jpg")
                .defaultImg()
                .into(imageView2);

    }
}
