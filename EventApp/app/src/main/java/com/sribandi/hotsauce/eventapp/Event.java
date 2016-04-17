package com.sribandi.hotsauce.eventapp;

public class Event {
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
}
