package model;

import java.util.ArrayList;

public class Participants {

    private static Participants instance;

    private ArrayList<Participant> allParticipants;

    private Participants(){
        setAllParticipants(new ArrayList<Participant>());
        allParticipants.add(new Participant("Participant 1", "1","1"));
        allParticipants.add(new Participant("Participant 2", "1","1"));
        allParticipants.add(new Participant("Participant 3", "1","1"));
        allParticipants.add(new Participant("Participant 4", "1","1"));
        allParticipants.add(new Participant("Participant 5",  "1","1"));
        allParticipants.add(new Participant("Participant 6 ",  "1","1"));
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
