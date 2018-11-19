package br.ufjf.ice.trb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import model.Participant;
import model.Event;
import persistence.EventDAO;
import persistence.ParticipantDAO;
import persistence.ParticipantEventDAO;

public class AddEventToParticipantActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_to_participant);

        Bundle extras = getIntent().getExtras();
        String participantName = extras.getString("NAME");

        ParticipantDAO participantDAO = new ParticipantDAO(this);
        Participant selectedParticipant = participantDAO.read(participantName);

        EventDAO eventDAO = new EventDAO(this);
        ArrayList<Event> allEvents = eventDAO.getAll();

        ParticipantEventDAO participantEventDAO = new ParticipantEventDAO(this);
        ArrayList<Event> currentSubscribed = participantEventDAO.getEvents(this, selectedParticipant.getId());

        ArrayList<Event> currentNotSubscribedEvents = getNotCurrentSubscribed(allEvents, currentSubscribed);

        recyclerView = findViewById(R.id.non_subscribed_events_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ShowNonSubscribedEventsAdapter(currentNotSubscribedEvents, selectedParticipant);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Event> getNotCurrentSubscribed( ArrayList<Event> allEvents, ArrayList<Event> currentSubscribed) {
        ArrayList<Event> notSubscribed = new ArrayList<>();

        ArrayList<String> availableEvents = new ArrayList<>();

        for (Event available: allEvents) {
            availableEvents.add(available.getEventTitle());
        }

        ArrayList<String> subscribedEvents = new ArrayList<>();

        for (Event subscribed: currentSubscribed) {
            subscribedEvents.add(subscribed.getEventTitle());
        }

        availableEvents.removeAll(subscribedEvents);

        for (String event : availableEvents) {
            for (Event e: allEvents) {
                if(e.getEventTitle().equalsIgnoreCase(event))
                    notSubscribed.add(e);
            }
        }

        return notSubscribed;
    }
}
