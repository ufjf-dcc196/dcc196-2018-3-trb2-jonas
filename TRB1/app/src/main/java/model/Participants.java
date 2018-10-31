package model;

import java.util.ArrayList;

public class Participants {

    private static Participants instance;

    private ArrayList<Participant> allParticipants;

    private Participants(){
        setAllParticipants(new ArrayList<Participant>());
        allParticipants.add(new Participant("Harry Potter", "hp@hogwarts.castle","123456780"));
        allParticipants.add(new Participant("Hermione Granger", "hermione.granger@hogwarts.castle","123456781"));
        allParticipants.add(new Participant("Albus Dumbledore", "theboss@hogwarts.castle","123456782"));
        allParticipants.add(new Participant("Draco Malfoy", "malfoydrake@hogwarts.castle","123456783"));
        allParticipants.add(new Participant("Ronald Weasley",  "ron.weasley@hogwarts.castle","123456784"));
        allParticipants.add(new Participant("Sirius Black",  "blacks@hogwarts.castle","123456786"));
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
