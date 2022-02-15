package com.golden.golden.glide;


import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.BaseRequestOptions;
import com.golden.golden.R;

/**
 * Created by GoldenLi on 2022/1/9 0009 17:14.
 */
@GlideExtension
public final class MyAppGlideExtension {

    private MyAppGlideExtension()
    {

    }

    @GlideOption
    public static BaseRequestOptions<?> defaultImg(BaseRequestOptions<?> options)
    {
        return options
                .placeholder(R.drawable.placeh)
                .error(R.drawable.error)
                .fallback(R.drawable.error)
                .override(80,90);
    }

}
