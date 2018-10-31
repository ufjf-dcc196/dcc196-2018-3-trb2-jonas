package model;

import java.util.ArrayList;

public class Event {

    public Event(String eventTitle, int day, int hour, String facilitator){
        setEventTitle(eventTitle);
        setDay(day);
        setHour(hour);
        setFacilitator(facilitator);
    }

    private static ArrayList<Participant> subscribed;

    public static ArrayList<Participant> getSubscribed(){
        if(subscribed == null) subscribed = new ArrayList<>();
        return subscribed;
    }

    private String eventTitle;
    private int day;
    private int hour;
    private String facilitator;

    public int getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(int textDescription) {
        this.textDescription = textDescription;
    }

    private int textDescription;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }
}

