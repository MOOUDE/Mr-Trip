package com.example.mrsnack.mrtrip.Moduls;

public class Trip {

    int tripId;
    double tripPrice;

    String tripLocation;
    String tripDate;
    String tripDuration;
    String tripExtras;
    String tripTransport;
    String tripType;
    String tripTitle;
    String image;


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

}
