package com.shankar.imager.db;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
interface ImgDao {
    @Query("SELECT * FROM IMAGE_TABLE")
    List<Img> getAll();

    @Query("SELECT * FROM IMAGE_TABLE WHERE id IN (:userIds)")
    List<Img> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM IMAGE_TABLE WHERE url LIKE :url LIMIT 1")
    Img findByUrl(String url);


    @Insert
    void insertAll(Img... imgs);

    @Delete
    void delete(Img img);
}
