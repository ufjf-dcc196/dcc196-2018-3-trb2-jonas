package br.ufjf.ice.trb1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Participant;

public class GetEventParticipantsAdapter extends RecyclerView.Adapter<GetEventParticipantsAdapter.GetEventParticipantsViewHolder>{

    private ArrayList<Participant> participants;

    public static class GetEventParticipantsViewHolder extends RecyclerView.ViewHolder{
        public TextView participantName;

        public GetEventParticipantsViewHolder(@NonNull View itemView) {
            super(itemView);

            participantName = itemView.findViewById(R.id.e_participant_name_cv);
        }
    }

    public GetEventParticipantsAdapter(ArrayList<Participant> subscribed){
        participants = subscribed;
    }

    @NonNull
    @Override
    public GetEventParticipantsAdapter.GetEventParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.e_participant_cardview, viewGroup, false);
        return new GetEventParticipantsAdapter.GetEventParticipantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetEventParticipantsAdapter.GetEventParticipantsViewHolder viewHolder, final int i) {
        Participant currentParticipant = participants.get(i);

        viewHolder.participantName.setText(currentParticipant.getName());
    }

    @Override
    public int getItemCount() {
        return participants.size();
    }
}
