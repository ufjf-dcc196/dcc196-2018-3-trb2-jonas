package br.ufjf.ice.trb1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import model.Participant;

public class GetAllParticipantsAdapter extends RecyclerView.Adapter<GetAllParticipantsAdapter.GetAllParticipantsViewHolder> {

    private ArrayList<Participant> participantsList;

    public static class GetAllParticipantsViewHolder extends RecyclerView.ViewHolder {
        public TextView participantName;

        public GetAllParticipantsViewHolder(@NonNull View itemView) {
            super(itemView);

            participantName = itemView.findViewById(R.id.participant_name_cv);

        }
    }

    public GetAllParticipantsAdapter(ArrayList<Participant> participants) {
        participantsList = participants;
    }

    @NonNull
    @Override
    public GetAllParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.participant_cardview, viewGroup, false);

        return new GetAllParticipantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetAllParticipantsViewHolder getAllParticipantsViewHolder, final int i) {
        Participant currentParticipant = participantsList.get(i);
        getAllParticipantsViewHolder.participantName.setText(currentParticipant.getName());

        getAllParticipantsViewHolder.participantName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewParticipantDetailsActivity.class);
                intent.putExtra("NAME", participantsList.get(i).getName());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return participantsList.size();
    }
}
