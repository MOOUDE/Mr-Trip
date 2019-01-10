package com.example.mrsnack.mrtrip;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mrsnack.mrtrip.Adpaters.MainRecyclerViewAdapter;
import com.example.mrsnack.mrtrip.Data.TripAppDataBase;
import com.example.mrsnack.mrtrip.Data.TripsData;
import com.example.mrsnack.mrtrip.Moduls.Trip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView recyclerView;
    static Context context;

    public static TripAppDataBase mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataBase = Room.databaseBuilder(this , TripAppDataBase.class , "trips").build();

        recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        context = getApplicationContext();

        new TripsData().execute();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }

    public static void setRecyclerView(ArrayList<Trip> trips){
        recyclerView.setAdapter(new MainRecyclerViewAdapter(trips, context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.fav:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final ArrayList<Trip> favTrips = new ArrayList<Trip>(MainActivity.mDataBase.mDao().getTrips());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setRecyclerView(favTrips);
                            }
                        });
                    }
                }).start();

                return true;


            case R.id.all:
                new TripsData().execute();

            return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



