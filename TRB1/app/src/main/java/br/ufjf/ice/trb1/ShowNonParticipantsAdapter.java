package br.ufjf.ice.trb1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.Participant;

public class ShowNonParticipantsAdapter extends RecyclerView.Adapter<ShowNonParticipantsAdapter.ShowNonParticipantsViewHolder> {
    private ArrayList<Participant> participantsList;

    public static class ShowNonParticipantsViewHolder extends RecyclerView.ViewHolder{
        public TextView participantName;

        public ShowNonParticipantsViewHolder(@NonNull View itemView) {
            super(itemView);

            participantName = itemView.findViewById(R.id.non_participant_cv);
        }
    }

    public ShowNonParticipantsAdapter(ArrayList<Participant> subscribed){
        participantsList = subscribed;
    }

    @NonNull
    @Override
    public ShowNonParticipantsAdapter.ShowNonParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.non_participant_cardview, viewGroup, false);
        return new ShowNonParticipantsAdapter.ShowNonParticipantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowNonParticipantsAdapter.ShowNonParticipantsViewHolder viewHolder, final int i) {
        Participant currentParticipant = participantsList.get(i);

        viewHolder.participantName.setText(currentParticipant.getName());
    }

    @Override
    public int getItemCount() {
        return participantsList.size();
    }
}
