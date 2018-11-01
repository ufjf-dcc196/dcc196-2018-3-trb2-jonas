package br.ufjf.ice.trb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import model.Event;
import model.Events;
import model.Participant;
import model.Participants;

public class AddEventToParticipant extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_to_participant);

        Bundle extras = getIntent().getExtras();
        String participantName = extras.getString("NAME");

        Participant selectedParticipant = Participants.getInstance().searchFor(participantName);

        ArrayList<Event> currentNotSubscribedEvents = selectedParticipant.getNotCurrentSubscribed(Events.getInstance().getAllEvents());

        recyclerView = findViewById(R.id.non_subscribed_events_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ShowNonSubscribedEventsAdapter(currentNotSubscribedEvents, selectedParticipant);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
