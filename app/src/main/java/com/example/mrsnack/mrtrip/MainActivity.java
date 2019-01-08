package com.example.mrsnack.mrtrip;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.example.mrsnack.mrtrip.Adpaters.MainRecyclerViewAdapter;
import com.example.mrsnack.mrtrip.Data.TripsData;
import com.example.mrsnack.mrtrip.Moduls.Trip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView recyclerView;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}

