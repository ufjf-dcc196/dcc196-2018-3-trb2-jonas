package br.ufjf.ice.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Events;
import model.Participant;
import model.Participants;

public class ViewParticipantDetailsActivity extends AppCompatActivity {
    private TextView name;
    private TextView mail;
    private TextView id;
    private Button subscribe;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_participant_details);

        Bundle extras = getIntent().getExtras();
        String participantName = extras.getString("NAME");

        final Participant result = Participants.getInstance().searchFor(participantName);

        if( result != null) {

            name = findViewById(R.id.p_name_details);
            mail = findViewById(R.id.p_mail_details);
            id = findViewById(R.id.p_id_details);

            name.setText(result.getName());
            mail.setText(result.getMail());
            id.setText(result.getId());

            subscribe = findViewById(R.id.add_event_to_participant_action);

            recyclerView = findViewById(R.id.p_events_rv);
            layoutManager = new LinearLayoutManager(this);
            adapter = new GetParticipantEventsAdapter(result.getEvents(), result);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            subscribe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AddEventToParticipant.class);
                    intent.putExtra("NAME", result.getName());
                    v.getContext().startActivity(intent);
                    finish();
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), " Não foi possível encontrar o participante " + participantName + ".", Toast.LENGTH_SHORT).show();
        }
    }
}
