package com.example.mrsnack.mrtrip.Data;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mrsnack.mrtrip.MainActivity;
import com.example.mrsnack.mrtrip.Moduls.Guide;
import com.example.mrsnack.mrtrip.Moduls.Trip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TripsData extends AsyncTask<Void, Void, Void> {

    ArrayList<Trip> trips = new ArrayList<Trip>();

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    private final String TABLE_NAME = "trips";

    public TripsData(){

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference(TABLE_NAME);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        trips.clear();
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                trips.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Trip artist = postSnapshot.getValue(Trip.class);
                    //adding artist to the list

                    Log.d("data Sample FireBase" ,artist.getTripImage() );

                    trips.add(artist);

                }
                MainActivity.setRecyclerView(trips);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        return null;

    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        MainActivity.setRecyclerView(trips);

    }


    public ArrayList<Trip> getTrips(){
        return trips;
    }


}
