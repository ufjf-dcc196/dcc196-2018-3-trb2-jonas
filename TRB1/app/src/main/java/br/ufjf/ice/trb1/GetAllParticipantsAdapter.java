package br.ufjf.ice.trb1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import model.Participant;

public class GetAllParticipantsAdapter extends RecyclerView.Adapter<GetAllParticipantsAdapter.GetAllParticipantsViewHolder> {

    private List<Participant> participants;
    private String name;

    public static class GetAllParticipantsViewHolder extends RecyclerView.ViewHolder {
        public TextView participantName;

        public GetAllParticipantsViewHolder(@NonNull View itemView) {
            super(itemView);

            participantName = itemView.findViewById(R.id.participant_name_cv);

        }
    }

    public GetAllParticipantsAdapter(List<Participant> participants) {
        this.participants = participants;
    }

    @NonNull
    @Override
    public GetAllParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.participant_cardview, viewGroup, false);

        return new GetAllParticipantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GetAllParticipantsViewHolder getAllParticipantsViewHolder, int i) {
        Participant currentParticipant = this.participants.get(i);
        name = participants.get(i).getName();
        getAllParticipantsViewHolder.participantName.setText(currentParticipant.getName());

        getAllParticipantsViewHolder.participantName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAllParticipantsViewHolder.getAdapterPosition();
                Intent intent = new Intent(v.getContext(), ViewParticipantDetailsActivity.class);
                intent.putExtra("NAME", getNameParticipant(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    private String getNameParticipant(int position) {
        Participant participant = this.participants.get(position);
        return participant.getName();
    }

    @Override
    public int getItemCount() {
        return this.participants.size();
    }

    public void updateParticipant(Participant oldParticipant, Participant newParticipant){
        int position = searchFor(oldParticipant);
        this.participants.set(position, newParticipant);
        notifyItemChanged(position);
    }

    private int searchFor(Participant oldParticipant) {
        for (int i = 0; i < this.participants.size(); i++){
            if(((Participant) participants.toArray()[i]).getName().equalsIgnoreCase(oldParticipant.getName()))
                return i;
        }

        return -1;
    }

    public void addParticipant(Participant participant){
        this.participants.add(participant);
        notifyItemInserted(getItemCount());
    }
}
