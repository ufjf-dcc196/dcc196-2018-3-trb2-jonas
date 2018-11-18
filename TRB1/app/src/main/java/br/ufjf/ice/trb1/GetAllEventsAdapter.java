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

public class GetAllEventsAdapter extends RecyclerView.Adapter<GetAllEventsAdapter.GetAllEventsViewHolder> {

    private ArrayList<Event> events;

    public static class GetAllEventsViewHolder extends RecyclerView.ViewHolder{
        public TextView eventTitle;

        public GetAllEventsViewHolder(@NonNull View itemView) {
            super(itemView);

            eventTitle = itemView.findViewById(R.id.event_title_cv);
        }
    }

    public GetAllEventsAdapter(ArrayList<Event> events){
        this.events = events;
    }

    @NonNull
    @Override
    public GetAllEventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_cardview, viewGroup, false);
        return new GetAllEventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetAllEventsViewHolder getAllEventsViewHolder, final int i) {
        Event currentEvent = this.events.get(i);

        getAllEventsViewHolder.eventTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewEventDetailsActivity.class);
                intent.putExtra("TITLE", events.get(i).getEventTitle());
                v.getContext().startActivity(intent);
            }
        });

        getAllEventsViewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public void updateEvent(Event participant){
        int position = this.events.indexOf(participant);
        this.events.set(position, participant);
        notifyItemChanged(position);
    }

    public void addEvent(Event participant){
        this.events.add(participant);
        notifyItemInserted(getItemCount());
    }
}
