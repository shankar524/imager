package com.shankar.imager.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "image_table")
public class Img {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "url")
    private String url;


    public Img(int id,String url) {this.id=id;this.url = url;}

    @Ignore
    public Img(String url) {this.url = url;}

    public String getUrl(){return this.url;}
    public void setUrl(String url){this.url=url;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
