package com.example.mrsnack.mrtrip.Data;



import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mrsnack.mrtrip.Moduls.Trip;

import java.util.List;


@Dao
public interface TripDao {

    @Insert
    void addTrip(Trip trip);

    @Query("select * from trips")
    List<Trip> getTrips();

    @Query("SELECT * FROM trips WHERE tripTitle = :name and tripDate = :date")
    Trip getSingle(String name,String date);

    @Query("DELETE FROM trips WHERE tripTitle = :name and tripDate = :date")
    void delete(String name,String date);

}
