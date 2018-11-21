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
    private Event currentEvent;

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
    public void onBindViewHolder(@NonNull final GetAllEventsViewHolder getAllEventsViewHolder, int i) {
        currentEvent = this.events.get(i);

        getAllEventsViewHolder.eventTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAllEventsViewHolder.getAdapterPosition();

                Intent intent = new Intent(v.getContext(), ViewEventDetailsActivity.class);
                intent.putExtra("TITLE", getEventTitle(position));
                v.getContext().startActivity(intent);
            }
        });

        getAllEventsViewHolder.eventTitle.setText(currentEvent.getEventTitle());
    }

    private String getEventTitle(int position) {
        Event event = this.events.get(position);
        return event.getEventTitle();
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public void addEvent(Event event){
        this.events.add(event);
        notifyItemInserted(getItemCount());
    }
}
