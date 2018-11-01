package model;

import java.util.ArrayList;

public class Participant {

    private String name;
    private String mail;
    private String id;
    private ArrayList<Event> events  = new ArrayList<>();

    public Participant(String name, String mail, String id){
        setName(name);
        setMail(mail);
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        Event toSearch = this.searchFor(event.getEventTitle());
        if(toSearch == null)
            this.getEvents().add(event);
    }

    public Event searchFor(String title){
        for (Event e: this.getEvents()) {
            if(e.getEventTitle().equalsIgnoreCase(title))
                return e;
        }
        return null;
    }

    public ArrayList<Event> getNotCurrentSubscribed( ArrayList<Event> eventList) {
        ArrayList<Event> currentNotSubscribed = new ArrayList<>();

        for (Event p: events) {
            for (Event q: eventList){
                if(!p.getEventTitle().equals(q.getEventTitle()))
                    currentNotSubscribed.add(q);
            }
        }

        return currentNotSubscribed;
    }

}
