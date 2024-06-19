package com.example.recyclerview;
public class event_model {
    private String eventName;
    private String eventDescription;
    private String date;
    private String time;
    private String location;

    // Constructor
    public event_model(String eventName, String eventDescription, String date, String time, String location) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // Getters
    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    // Setters (if needed)
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
