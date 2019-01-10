package com.example.mrsnack.mrtrip;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mrsnack.mrtrip.Data.TripAppDataBase;
import com.example.mrsnack.mrtrip.Moduls.Trip;

public class DetailsActvitiy extends AppCompatActivity {
    ImageView header;
    TextView name,location,time,tripPrice,extra;


    String tripLocation,extras,transport ,tripType ,title,tripImage,tripDate,tripDuration;
    int regNumber;
    double price;
    FloatingActionButton fltBtn,rmvBtn;
    Trip tripToSend;
    boolean isFav = false;

    public static TripAppDataBase mDataBase;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_actvitiy);

        header = findViewById(R.id.header);

        tripToSend = getIntent().getParcelableExtra("TRIP");

        mDataBase = Room.databaseBuilder(this , TripAppDataBase.class , "trips").build();



        fltBtn = (FloatingActionButton) findViewById(R.id.fltBtn);

        rmvBtn = (FloatingActionButton) findViewById(R.id.rmvBtn);



        iniData(tripToSend);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Trip tr = DetailsActvitiy.mDataBase.mDao().getSingle(tripToSend.tripTitle,tripToSend.tripDate);

                    Log.d("TAG ID :"," the id is : "+tr.getTripId());

                    isFav = true;

                } catch (Exception e) {
                    Log.d("TAG ID :"," NO id : ");
                    isFav = false;
                }
                if(isFav){
                    fltBtn.setVisibility(View.GONE);
                    rmvBtn.setVisibility(View.VISIBLE);

                }else {
                    rmvBtn.setVisibility(View.GONE);
                    fltBtn.setVisibility(View.VISIBLE);
                }

            }

        }).start();


        fltBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                   new Thread(new Runnable() {
                        @Override
                        public void run() {

                           DetailsActvitiy.mDataBase.mDao().addTrip(tripToSend);
                        }

                    }).start();
                Toast.makeText(getApplicationContext() , "تم الاضافة الى المفضلة" , Toast.LENGTH_LONG).show();

                rmvBtn.setVisibility(View.VISIBLE);
                fltBtn.setVisibility(View.GONE);

            }

        });

        rmvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DetailsActvitiy.mDataBase.mDao().delete(tripToSend.tripTitle , tripToSend.getTripDate());
                    }

                }).start();
                Toast.makeText(getApplicationContext() , "تم الازالة من المفضلة" , Toast.LENGTH_LONG).show();
                rmvBtn.setVisibility(View.GONE);
                fltBtn.setVisibility(View.VISIBLE);

            }
        });





        Glide.with(this)
                .load(tripToSend.getTripImage())
                .into(header);


        name = (TextView) findViewById(R.id.detailTripName);
        location = (TextView) findViewById(R.id.detailTripLocation);
        time = (TextView) findViewById(R.id.detailTripTime);
        tripPrice = (TextView) findViewById(R.id.detailTripPrice);
        extra = (TextView) findViewById(R.id.detailTrip);



        name.setText(title);
        location.setText(" المكان "+tripLocation);
        time.setText(tripDate);
        tripPrice.setText(" التكلفة "+String.valueOf(price)+" شيكل ");
        extra.setText(extras);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext() ,MainActivity.class);

        startActivity(intent);
    }

    void iniData(Trip toBind){



        transport = toBind.getTransport();
        tripType = toBind.getTripType();
        title = toBind.getTripTitle();
        tripDate = toBind.getTripDate();
        tripDuration = toBind.getTripDuration();
        tripLocation = toBind.getLocation();
        price = toBind.getTripPrice();
        extras = toBind.getTripExtras();


    }
}
