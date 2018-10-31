package br.ufjf.ice.trb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import model.Event;
import model.Events;
import model.Participant;
import model.Participants;

public class ViewEventDetailsActivity extends AppCompatActivity {

    private TextView title;
    private TextView day;
    private TextView hour;
    private TextView facilitator;
    private TextView description;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_event_details);

        Bundle extras = getIntent().getExtras();
        String eventTitle = extras.getString("TITLE");

        Event result = Events.getInstance().searchFor(eventTitle);

        if(result != null) {
            title = findViewById(R.id.e_event_title_details);
            day = findViewById(R.id.e_day_details);
            hour = findViewById(R.id.e_hour_details);
            facilitator = findViewById(R.id.e_facilitator_details);
            description = findViewById(R.id.e_description_details);

            title.setText(result.getEventTitle());
            day.setText(Integer.toString(result.getDay()));
            hour.setText(Integer.toString(result.getHour()));
            facilitator.setText(result.getFacilitator());
            description.setText(result.getTextDescription());

            recyclerView = findViewById(R.id.e_participants_rv);
            layoutManager = new LinearLayoutManager(this);
            adapter = new GetEventParticipantsAdapter(result.getParticipants());

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        } else {
            Toast.makeText(getApplicationContext(), " Não foi possível encontrar o evento " + eventTitle + ".", Toast.LENGTH_SHORT).show();
        }
    }
}
