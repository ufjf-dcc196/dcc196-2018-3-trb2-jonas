package model;

import java.util.ArrayList;

public class Events {

    private static Events instance;

    private ArrayList<Event> allEvents;

    private Events(){
       setAllEvents(new ArrayList<Event>());
        allEvents.add(new Event("Event 1", 1, 2, "Facilitator"));
        allEvents.add(new Event("Event 2", 1, 2, "Facilitator"));
        allEvents.add(new Event("Event 3", 1, 2, "Facilitator"));
        allEvents.add(new Event("Event 4", 1, 2, "Facilitator"));
        allEvents.add(new Event("Event 5", 1, 2, "Facilitator"));
        allEvents.add(new Event("Event 6 ", 1, 2, "Facilitator"));
    }

    public static synchronized Events getInstance(){

        if(instance == null) instance = new Events();
        return instance;
    }

    public ArrayList<Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(ArrayList<Event> allEvents) {
        this.allEvents = allEvents;
    }
}
