package br.ufjf.ice.trb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import model.Participant;
import model.Event;
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

        Participant selectedParticipant = ParticipantDAO.read(participantName);

        ArrayList<Event> currentNotSubscribedEvents = ParticipantEventDAO.getOtherEvents(selectedParticipant.getId());

        recyclerView = findViewById(R.id.non_subscribed_events_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ShowNonSubscribedEventsAdapter(currentNotSubscribedEvents, selectedParticipant);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
