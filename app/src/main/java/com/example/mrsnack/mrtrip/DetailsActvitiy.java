package com.example.mrsnack.mrtrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mrsnack.mrtrip.Moduls.Guide;

public class DetailsActvitiy extends AppCompatActivity {
    ImageView header;
    TextView name,location,time,tripPrice,extra;


    String tripLocation,extras,transport ,tripType ,title,tripImage,tripDate,tripDuration;
    int regNumber;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_actvitiy);

        header = findViewById(R.id.header);

        iniData();

        String url = getIntent().getStringExtra("Image");

        Glide.with(this)
                .load(url)
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

    void iniData(){


        transport = getIntent().getStringExtra("trnsport");
        tripType = getIntent().getStringExtra("type");
        title = getIntent().getStringExtra("title");
        tripDate = getIntent().getStringExtra("date");
        tripDuration = getIntent().getStringExtra("duration");
        tripLocation = getIntent().getStringExtra("location");
        price = getIntent().getDoubleExtra("price",0.0);
        extras = getIntent().getStringExtra("extra");


    }
}
