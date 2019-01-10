package com.example.mrsnack.mrtrip.Moduls;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "trips")
public class Trip implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int tripId;

    @ColumnInfo(name = "tripPrice")
    public double tripPrice;

    @ColumnInfo(name = "tripLocation")
    public String tripLocation;

    @ColumnInfo(name = "tripDate")
    public String tripDate;

    @ColumnInfo(name = "tripDuration")
    public String tripDuration;

    @ColumnInfo(name = "tripExtras")
    public String tripExtras;

    @ColumnInfo(name = "tripTransport")
    public String tripTransport;

    @ColumnInfo(name = "tripType")
    public String tripType;

    @ColumnInfo(name = "tripTitle")
    public String tripTitle;

    @ColumnInfo(name = "image")
    public String image;


    public Trip(String location,
                String tripDate,
                String tripDuration,
                double tripPrice,
                String tripExtras,
                Guide guid, int tripId,
                String transport, String tripType,
                String tripTitle,
                String tripImage) {
        this.tripLocation = location;
        this.tripDate = tripDate;
        this.tripDuration = tripDuration;
        this.tripPrice = tripPrice;
        this.tripExtras = tripExtras;
        this.tripId = tripId;
        this.tripTransport = transport;
        this.tripType = tripType;
        this.tripTitle = tripTitle;
        this.image = tripImage;
    }
    public Trip(){}




    public String getTripImage() {
        return image;
    }

    public void setTripImage(String tripImage) {
        tripImage = tripImage;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }


    public String getLocation() {
        return tripLocation;
    }

    public void setLocation(String location) {
        this.tripLocation = location;
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

    public double getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = tripPrice;
    }

    public String getTripExtras() {
        return tripExtras;
    }

    public void setTripExtras(String tripExtras) {
        this.tripExtras = tripExtras;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTransport() {
        return tripTransport;
    }

    public void setTransport(String transport) {
        this.tripTransport = transport;
    }


    public Trip(Parcel in){


        this.tripPrice = in.readDouble();
        this.tripLocation = in.readString();
        this.tripDate =  in.readString();
        this.tripDuration =  in.readString();
        this.tripExtras =  in.readString();
        this.tripTransport =  in.readString();
        this.tripType =  in.readString();
        this.tripTitle =  in.readString();
        this.image =  in.readString();

    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeDouble(this.tripPrice);
        dest.writeString(this.tripLocation);
        dest.writeString(this.tripDate);
        dest.writeString(this.tripDuration);
        dest.writeString(this.tripExtras);
        dest.writeString(this.tripTransport);
        dest.writeString(this.tripType);
        dest.writeString(this.tripTitle);
        dest.writeString(this.image);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


}
