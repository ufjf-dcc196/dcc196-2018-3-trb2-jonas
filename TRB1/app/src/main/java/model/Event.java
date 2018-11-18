package model;

public class Event {

    private int id;
    private String eventTitle;
    private int day;
    private int hour;
    private String facilitator;
    private String description;

    public Event(int id, String eventTitle, int day, int hour, String facilitator, String description){
        setId(id);
        setEventTitle(eventTitle);
        setDay(day);
        setHour(hour);
        setFacilitator(facilitator);
        setDescription(description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

