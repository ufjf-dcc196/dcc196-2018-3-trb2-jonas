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

public class ShowNonSubscribedEventsAdapter extends RecyclerView.Adapter<ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder> {
    private ArrayList<Event> eventsList;
    private Participant participant;
    private Event currentEvent;

    public static class ShowNonSubscribedEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public ShowNonSubscribedEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.non_subscribed_cv);
        }
    }

    public ShowNonSubscribedEventsAdapter(ArrayList<Event> subscribed, Participant participant){
        this.participant = participant;
        this.eventsList = subscribed;
    }

    @NonNull
    @Override
    public ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.non_subscribed_cardview, viewGroup, false);
        return new ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder viewHolder, int i) {
        final Event event = eventsList.get(i);
        currentEvent = event;

        viewHolder.eventTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ParticipantEventDAO participantEventDAO = new ParticipantEventDAO(v.getContext());
                participantEventDAO.create(participant.getId(), currentEvent.getId());
                deleteEvent(currentEvent);

                Toast.makeText(v.getContext(), "Evento adicionado!", Toast.LENGTH_SHORT).show();

            }
        });

        viewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public void deleteEvent(Event event){
        this.eventsList.remove(event);
        notifyItemRemoved(getItemCount());
    }
}
