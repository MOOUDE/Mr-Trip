package com.example.mrsnack.mrtrip.Data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.mrsnack.mrtrip.Moduls.Trip;


@Database(entities = {Trip.class} ,version = 1)
public abstract class TripAppDataBase extends RoomDatabase {
    public  static final String DATABASE_NAME = "trips";
    private static TripAppDataBase sInstance;
    private static final Object LOCK = new Object();

    public static TripAppDataBase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        TripAppDataBase.class, TripAppDataBase.DATABASE_NAME)
                        .build();
            }
        }
        return sInstance;
    }

    public abstract TripDao mDao();

}