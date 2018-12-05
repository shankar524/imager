package com.shankar.imager.db;

import android.content.Context;

import java.util.List;

public class ImgDbAccess {
    AppDatabase db;
    ImgDao dao;
    public ImgDbAccess(Context context)
    {
        this.db=db.getInstance(context);
        this.dao=db.imgDao();
    }

    public List<Img> getAllImages()
    {
        return dao.getAll();
    }
    public Img findByUrl(String url){
        return dao.findByUrl(url);
    }
    public void addMultipleImage(Img... images)
    {
        dao.insertAll(images);
    }
    public void addImage(Img img)
    {
        dao.insertAll(img);
    }
    public void deleteImage(Img img)
    {
        dao.delete(img);
    }

    public boolean imageExists(String url)
    {
        Img imgFromDb=dao.findByUrl(url);
        return (imgFromDb==null)?false:true;
    }

}
