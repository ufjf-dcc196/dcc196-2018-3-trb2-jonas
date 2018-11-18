package br.ufjf.ice.trb1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.Event;
import model.Participant;

public class GetParticipantEventsAdapter extends RecyclerView.Adapter<GetParticipantEventsAdapter.GetParticipantEventsViewHolder>{

    private ArrayList<Event> eventList;
    private Participant participant;

    public static class GetParticipantEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public GetParticipantEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.p_event_title_cv);
        }
    }

    public GetParticipantEventsAdapter(ArrayList<Event> events, Participant participant){
        eventList = events;
        this.participant = participant;
    }

    @NonNull
    @Override
    public GetParticipantEventsAdapter.GetParticipantEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p_event_cardview, viewGroup, false);
        return new GetParticipantEventsAdapter.GetParticipantEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetParticipantEventsAdapter.GetParticipantEventsViewHolder viewHolder, final int i) {
        final Event currentEvent = eventList.get(i);

        viewHolder.eventTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //participant.getEvents().remove(currentEvent);
                //Events.getInstance().searchFor(currentEvent.getEventTitle()).removeParticipant(participant);
                Toast.makeText(v.getContext(), "Evento removido!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        viewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
