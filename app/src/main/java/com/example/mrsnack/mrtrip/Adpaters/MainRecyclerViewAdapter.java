package com.example.mrsnack.mrtrip.Adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mrsnack.mrtrip.DetailsActvitiy;
import com.example.mrsnack.mrtrip.Moduls.Trip;
import com.example.mrsnack.mrtrip.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {

    ArrayList<Trip> trips;
    Context context;

    public MainRecyclerViewAdapter(ArrayList<Trip> trips , Context context){
        this.trips = trips;
        this.context = context;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_layout , viewGroup , false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final Trip trip = trips.get(i);

       // myViewHolder.type.setText(trip.getTripType());
        myViewHolder.time.setText(trip.getTripDate());
     //   myViewHolder.location.setText(trip.getLocation());
        myViewHolder.name.setText(trip.getTitle());




        Glide.with(context)
                .load(trip.getTripImage())
                .into(myViewHolder.image);

        myViewHolder.setItemOnClickListner(new RecyclerOnClickListner(){

            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(context , DetailsActvitiy.class);

                intent.putExtra("Image",trip.getTripImage());
                intent.putExtra("type" ,trip.getTripType());
                intent.putExtra("date" , trip.getTripDate());
                intent.putExtra("title",trip.getTitle());
                intent.putExtra("location",trip.getLocation());
                intent.putExtra("price",trip.getPrice());
                intent.putExtra("transport",trip.getTransport());
                intent.putExtra("extra" , trip.getExtras());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return trips.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        ImageView image;
        TextView name,time,price,type;

        private RecyclerOnClickListner clicklistener;

        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.tripImage);
            name = (TextView) view.findViewById(R.id.TripName);
            time = (TextView) view.findViewById(R.id.TripTime);


            view.setOnClickListener(this);


        }
        public void setItemOnClickListner(RecyclerOnClickListner listner){
            this.clicklistener = listner;

        }

        @Override
        public void onClick(View v) {
            clicklistener.onClick(v , getAdapterPosition());

        }
    }

}
