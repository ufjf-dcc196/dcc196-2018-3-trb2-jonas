package br.ufjf.ice.trb1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Participant;
import model.Participants;

public class RegisterParticipantFragment extends Fragment {

    private TextView pName;
    private TextView pMail;
    private TextView pId;
    private Button pRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_register_participant, container, false);

        pName = rootView.findViewById(R.id.p_add_name);
        pMail = rootView.findViewById(R.id.p_add_mail);
        pId = rootView.findViewById(R.id.p_add_id);

        pRegister = rootView.findViewById(R.id.add_participant_action);

        pRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameContent = pName.getText().toString();
                String mailContent = pMail.getText().toString();
                String idContent = pId.getText().toString();

                if(nameContent == null || nameContent.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um nome válido!", Toast.LENGTH_SHORT).show();
                else if(mailContent == null || mailContent.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um e-mail válido!", Toast.LENGTH_SHORT).show();
                else if(idContent == null || idContent.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um CPF válido!", Toast.LENGTH_SHORT).show();
                else{
                    Participant p = new Participant(nameContent, mailContent, idContent);
                    if(Participants.getInstance().searchFor(nameContent) == null)
                        Participants.getInstance().getAllParticipants().add(p);

                    Toast.makeText(v.getContext(), nameContent + " cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
}
