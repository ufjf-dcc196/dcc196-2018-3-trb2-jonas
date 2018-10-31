package model;

import java.util.ArrayList;

public class Participant {

    public Participant(String name, String email, String id){
        setName(name);
        setEmail(email);
        setId(id);
    }

    private static ArrayList<Event> events;

    public static ArrayList<Event> getSubscribed(){
        if(events == null) events = new ArrayList<>();
        return events;
    }

    private String name;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
