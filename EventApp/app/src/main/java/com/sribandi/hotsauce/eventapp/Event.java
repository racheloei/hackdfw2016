package com.sribandi.hotsauce.eventapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Event /*implements Parcelable*/ {
    private String title;
    private String description;
    private int rating;
    private double longitude;
    private double latitude;

    public Event(String t, String d, int r, double lo, double la) {
        title = t;
        description = d;
        rating = r;
        longitude = lo;
        latitude = la;
    }

    public Event(Parcel in)
    {
        String[] data = new String[5];

//        in.readStringArray(data);
//        this.id = data[0];
//        this.name = data[1];
//        this.grade = data[2];

    }
    
    public String toString() {
        return title + "\n" + rating + " stars\n" + description + "\n\n";
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getRating() {
        return rating;
    }

    public double getLongitude() {return longitude;}

    public double getLatitude() {return latitude;}

    public static final Parcelable.Creator<Event> CREATOR
            = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

}
