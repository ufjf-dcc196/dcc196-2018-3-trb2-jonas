package br.ufjf.ice.trb1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Event;

public class GetAllEventsAdapter extends RecyclerView.Adapter<GetAllEventsAdapter.GetAllEventsViewHolder> {

    private ArrayList<Event> eventList;

    public static class GetAllEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public GetAllEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.event_title_cv);
        }
    }

    public GetAllEventsAdapter(ArrayList<Event> events){
        eventList = events;
    }

    @NonNull
    @Override
    public GetAllEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_cardview, viewGroup, false);
        return new GetAllEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetAllEventsViewHolder getAllEventsViewHolder, int i) {
        Event currentEvent = eventList.get(i);

        getAllEventsViewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
