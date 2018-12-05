package com.shankar.imager.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {
    public static void loadImage(String url, ImageView imageView)
    {
        Picasso.get()
                .load(url)
                .error(android.R.drawable.stat_notify_error)
                .resize(50,50)
                .into(imageView);
    }
}
