package com.hacktx2016.hackdfw;

public class Event {
    private String title;
    private String description;
    private int rating;
    
    public Event(String t, String d, int r) {
        title = t;
        description = d;
        rating = r;
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
}
