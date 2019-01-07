package com.example.mrsnack.mrtrip.Moduls;

import android.os.Parcel;
import android.os.Parcelable;

public class Trip {

    String location;
    String tripDate;
    String tripDuration;
    double price;
    String extras;
    Guide guid;
    int regNumber;
    String transport;
    String tripType;
    String title;
    String tripImage;


    public Trip(String location,
                String tripDate,
                String tripDuration,
                double price,
                String extras,
                Guide guid, int regNumber,
                String transport, String tripType,
                String title,
                String tripImage) {
        this.location = location;
        this.tripDate = tripDate;
        this.tripDuration = tripDuration;
        this.price = price;
        this.extras = extras;
        this.guid = guid;
        this.regNumber = regNumber;
        this.transport = transport;
        this.tripType = tripType;
        this.title = title;
        this.tripImage = tripImage;
    }




    public String getTripImage() {
        return tripImage;
    }

    public void setTripImage(String tripImage) {
        tripImage = tripImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(String tripDuration) {
        this.tripDuration = tripDuration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Guide getGuid() {
        return guid;
    }

    public void setGuid(Guide guid) {
        this.guid = guid;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }



    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

}
