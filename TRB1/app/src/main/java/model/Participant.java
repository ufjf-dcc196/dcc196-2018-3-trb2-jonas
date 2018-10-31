package model;

import java.util.ArrayList;

public class Participant {

    public Participant(String name, String mail, String id){
        setName(name);
        setMail(mail);
        setId(id);
    }

    private static ArrayList<Event> events;

    public static ArrayList<Event> getSubscribed(){
        if(events == null) events = new ArrayList<>();
        return events;
    }

    private String name;
    private String mail;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
