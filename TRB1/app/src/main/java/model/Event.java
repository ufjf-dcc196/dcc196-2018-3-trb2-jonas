package model;

import java.util.ArrayList;

public class Event {

    private String eventTitle;
    private int day;
    private int hour;
    private String facilitator;
    private String textDescription;
    private static ArrayList<Participant> subscribed = new ArrayList<>();;

    public Event(String eventTitle, int day, int hour, String facilitator, String textDescription){
        setEventTitle(eventTitle);
        setDay(day);
        setHour(hour);
        setFacilitator(facilitator);
        setTextDescription(textDescription);
    }

    public static ArrayList<Participant> getParticipants() {
        return subscribed;
    }

    public void addParticipant(Participant participant) {
        Participant toSearch = this.searchFor(participant.getName());
        if(toSearch == null)
            Event.subscribed.add(participant);
    }

    public Participant searchFor(String name){
        for (Participant p: this.getParticipants()) {
            if(p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public ArrayList<Participant> getNotCurrentSubscribed( ArrayList<Participant> eventList) {
        ArrayList<Participant> currentNotSubscribed = new ArrayList<>();

        for (Participant p: subscribed) {
            for (Participant q: eventList){
                if(!p.getId().equals(q.getId()))
                    currentNotSubscribed.add(q);
            }
        }

        return currentNotSubscribed;
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

