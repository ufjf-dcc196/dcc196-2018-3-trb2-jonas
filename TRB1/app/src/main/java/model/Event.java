package model;

import java.util.ArrayList;

public class Event {

    private String eventTitle;
    private int day;
    private int hour;
    private String facilitator;
    private String textDescription;

    public Event(String eventTitle, int day, int hour, String facilitator, String textDescription){
        setEventTitle(eventTitle);
        setDay(day);
        setHour(hour);
        setFacilitator(facilitator);
        setTextDescription(textDescription);
    }

    private static ArrayList<Participant> subscribed;

    public static ArrayList<Participant> getSubscribed(){
        if(subscribed == null) subscribed = new ArrayList<>();
        return subscribed;
    }
    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

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

