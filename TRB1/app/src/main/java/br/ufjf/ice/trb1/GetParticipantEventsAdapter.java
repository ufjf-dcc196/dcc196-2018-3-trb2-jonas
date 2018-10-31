package br.ufjf.ice.trb1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Event;

public class GetParticipantEventsAdapter extends RecyclerView.Adapter<GetParticipantEventsAdapter.GetParticipantEventsViewHolder>{

    private ArrayList<Event> eventList;

    public static class GetParticipantEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public GetParticipantEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.p_event_title_cv);
        }
    }

    public GetParticipantEventsAdapter(ArrayList<Event> events){
        eventList = events;
    }

    @NonNull
    @Override
    public GetParticipantEventsAdapter.GetParticipantEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p_event_cardview, viewGroup, false);
        return new GetParticipantEventsAdapter.GetParticipantEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetParticipantEventsAdapter.GetParticipantEventsViewHolder viewHolder, final int i) {
        Event currentEvent = eventList.get(i);

        viewHolder.eventTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewEventDetailsActivity.class);
                intent.putExtra("TITLE", eventList.get(i).getEventTitle());
                v.getContext().startActivity(intent);
            }
        });

        viewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
