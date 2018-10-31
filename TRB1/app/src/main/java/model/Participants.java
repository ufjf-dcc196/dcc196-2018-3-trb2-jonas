package model;

import java.util.ArrayList;

public class Participants {

    private static Participants instance;

    private ArrayList<Participant> allParticipants;

    private Participants(){
        setAllParticipants(new ArrayList<Participant>());

        Participant hp = new Participant("Harry Potter", "hp@hogwarts.castle","123456780");
        hp.addEvent(new Event("Android Hell: Small-talking development", 1, 14, "John", "Not your common college lecture!"));

        Participant hermi = new Participant("Hermione Granger", "hermione.granger@hogwarts.castle","123456781");
        hermi.addEvent(new Event("Android Hell: Small-talking development", 1, 14, "John", "Not your common college lecture!"));
        hermi.addEvent(new Event("Real Mobile: Begin with React Native", 2, 14, "Arya", "Not your common college lecture!"));
        hermi.addEvent(new Event("Creating RESTful APIs", 3, 14, "Eddard", "Not your common college lecture!"));
        hermi.addEvent(new Event("DevOps on Real World", 1, 16, "Robb", "Not your common college lecture!"));
        hermi.addEvent(new Event("AI: Are We Near to Doomsday?", 2, 16, "Sansa", "Not your common college lecture!"));
        hermi.addEvent(new Event("That Boring Language Workshop", 3, 16, "Bran", "Not your common college lecture!"));

        allParticipants.add(hp);
        allParticipants.add(hermi);
        allParticipants.add(new Participant("Albus Dumbledore", "theboss@hogwarts.castle","123456782"));
        allParticipants.add(new Participant("Draco Malfoy", "malfoydrake@hogwarts.castle","123456783"));
        allParticipants.add(new Participant("Ronald Weasley",  "ron.weasley@hogwarts.castle","123456784"));
        allParticipants.add(new Participant("Sirius Black",  "blacks@hogwarts.castle","123456786"));
    }

    public Participant searchFor(String name){
        for (Participant p: getAllParticipants()) {
            if(p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public static synchronized Participants getInstance(){

        if(instance == null) instance = new Participants();
        return instance;
    }

    public ArrayList<Participant> getAllParticipants() {
        return allParticipants;
    }

    public void setAllParticipants(ArrayList<Participant> allParticipants) {
        this.allParticipants = allParticipants;
    }
}
