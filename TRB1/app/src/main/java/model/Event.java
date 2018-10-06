package model;

public class Event {

    private String eventTitle;
    private int day;
    private int hour;
    private int facilitator;

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

    public int getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(int facilitator) {
        this.facilitator = facilitator;
    }
}
