package model;

import java.util.ArrayList;

public class Events {

    private static Events instance;

    private ArrayList<Event> allEvents;

    private Events(){
       setAllEvents(new ArrayList<Event>());
        allEvents.add(new Event("Android Hell: Small-talking development", 1, 14, "John"));
        allEvents.add(new Event("Real Mobile: Begin with React Native", 2, 14, "Arya"));
        allEvents.add(new Event("Creating RESTful APIs", 3, 14, "Eddard"));
        allEvents.add(new Event("DevOps on Real World", 1, 16, "Robb"));
        allEvents.add(new Event("AI: Are We Near to Doomsday?", 2, 16, "Sansa"));
        allEvents.add(new Event("That Boring Language Workshop", 3, 16, "Bran"));
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
