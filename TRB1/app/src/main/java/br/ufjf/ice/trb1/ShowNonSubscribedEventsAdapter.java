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
import utils.NotificationService;

public class ShowNonSubscribedEventsAdapter extends RecyclerView.Adapter<ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder> {
    private ArrayList<Event> events;
    private Participant participant;

    public static class ShowNonSubscribedEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public ShowNonSubscribedEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.non_subscribed_cv);
        }
    }

    public ShowNonSubscribedEventsAdapter(ArrayList<Event> subscribed, Participant participant){
        this.participant = participant;
        this.events = subscribed;
    }

    @NonNull
    @Override
    public ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.non_subscribed_cardview, viewGroup, false);
        return new ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowNonSubscribedEventsAdapter.ShowNonSubscribedEventsViewHolder viewHolder, int i) {
        Event toBind = this.events.get(i);

        viewHolder.eventTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ParticipantEventDAO participantEventDAO = new ParticipantEventDAO(v.getContext());

                participantEventDAO.create(participant.getId(), getItemId(viewHolder.getAdapterPosition()));

                deleteEvent(viewHolder.getAdapterPosition());

                NotificationService.sendToast(v, "Evento adicionado!");

            }
        });

        viewHolder.eventTitle.setText(toBind.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return events.size();
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
