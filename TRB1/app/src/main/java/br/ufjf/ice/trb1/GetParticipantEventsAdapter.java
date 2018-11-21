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
import persistence.ParticipantEventDAO;

public class GetParticipantEventsAdapter extends RecyclerView.Adapter<GetParticipantEventsAdapter.GetParticipantEventsViewHolder>{

    private ArrayList<Event> events;
    private Participant participant;
    private Event currentEvent;

    public static class GetParticipantEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public GetParticipantEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.p_event_title_cv);
        }
    }

    public GetParticipantEventsAdapter(ArrayList<Event> events, Participant participant){
        this.events = events;
        this.participant = participant;
    }

    @NonNull
    @Override
    public GetParticipantEventsAdapter.GetParticipantEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p_event_cardview, viewGroup, false);
        return new GetParticipantEventsAdapter.GetParticipantEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GetParticipantEventsAdapter.GetParticipantEventsViewHolder viewHolder, int i) {
        currentEvent = this.events.get(i);

        viewHolder.eventTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                ParticipantEventDAO participantEventDAO = new ParticipantEventDAO(v.getContext());
                participantEventDAO.delete(participantEventDAO.getId(participant.getId(), getItemId(viewHolder.getAdapterPosition())));
                deleteEvent(viewHolder.getAdapterPosition());

                Toast.makeText(v.getContext(), "Evento removido!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        viewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public void deleteEvent(int position){
        Event toRemove = this.events.get(position);
        this.events.remove(toRemove);
        notifyItemRemoved(position);
    }

    @Override
    public long getItemId(int position) {
        Event clicked = this.events.get(position);
        int id = clicked.getId();
        return id;
    }
}
