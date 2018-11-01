package model;

import java.util.ArrayList;

public class Event {

    private String eventTitle;
    private int day;
    private int hour;
    private String facilitator;
    private String textDescription;
    private ArrayList<Participant> participants = new ArrayList<>();

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public Event(String eventTitle, int day, int hour, String facilitator, String textDescription){
        setEventTitle(eventTitle);
        setDay(day);
        setHour(hour);
        setFacilitator(facilitator);
        setTextDescription(textDescription);
    }

    public void addParticipant(Participant participant) {
        Participant toSearch = this.searchFor(participant.getName());

        if(toSearch == null)
            this.getParticipants().add(participant);
    }

    public Participant searchFor(String name){
        for (Participant p: this.getParticipants()) {
            if(p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
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

    public void removeParticipant(Participant participant) {
        for (Participant p: participants){
            if(p.getId().equalsIgnoreCase(participant.getId()))
                participants.remove(p);
        }
    }
}

