package com.shankar.imager.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

@Database(entities = {Img.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG=AppDatabase.class.getSimpleName();
    private static final Object LOCK=new Object();
    private static final String DATABASE_NAME="imageDb";
    private static AppDatabase mInstance;
    public abstract ImgDao imgDao();
    public static AppDatabase getInstance(Context context){

        if(mInstance==null){
            synchronized (LOCK){
                Log.d(LOG_TAG,"Creating new database instance");
                mInstance= Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,AppDatabase.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        Log.d(LOG_TAG,"getting the database instance");
        return mInstance;

    }
}
