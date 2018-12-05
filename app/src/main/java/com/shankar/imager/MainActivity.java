package com.shankar.imager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.shankar.imager.db.Img;
import com.shankar.imager.db.ImgDbAccess;
import com.shankar.imager.util.ImageLoadAsync;
import com.shankar.imager.util.ImageLoader;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    EditText urlText;
    Button submit;
    ImageView img;
    ImgDbAccess imgDbAccess;


    View.OnClickListener submitBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadImageFromUrl(urlText.getText().toString());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing view components
        urlText =findViewById(R.id.etURL);
        submit=findViewById(R.id.button);
        img =findViewById(R.id.imageView);

        imgDbAccess = new ImgDbAccess(getApplicationContext());

        submit.setOnClickListener(submitBtnClick);

    }
    //helper function to load image from it's URL and paste to ImageView
    private void loadImageFromUrl(String url){
        if(!imgDbAccess.imageExists(url))
        {
            imgDbAccess.addImage(new Img(url));
            Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"not saved",Toast.LENGTH_LONG).show();
        }
        ImageLoadAsync loadImgAsync = new ImageLoadAsync(url,img);
        loadImgAsync.execute();
        //ImageLoader.loadImage(url,img);

    }
}
