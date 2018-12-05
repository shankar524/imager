package com.shankar.imager.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageLoadAsync extends AsyncTask<Void,Void,Void> {
    private String url;
    private ImageView imgView;
    private Bitmap bitmap;

    public ImageLoadAsync(String url, ImageView imgView)
    {
        this.url=url;
        this.imgView=imgView;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(this.url);
            URLConnection conn = url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        }
        catch(MalformedURLException e){}
        catch(IOException e){}
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        imgView.setImageBitmap(bitmap);
    }

}
