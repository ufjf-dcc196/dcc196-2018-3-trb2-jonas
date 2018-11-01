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

public class AddParticipantToEventActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant_to_event);

        Bundle extras = getIntent().getExtras();
        String eventTitle = extras.getString("TITLE");

        Event selectedEvent = Events.getInstance().searchFor(eventTitle);

        ArrayList<Participant> currentNotSubscribed = selectedEvent.getNotCurrentSubscribed(Participants.getInstance().getAllParticipants());

        recyclerView = findViewById(R.id.non_participants_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ShowNonParticipantsAdapter(currentNotSubscribed);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}
