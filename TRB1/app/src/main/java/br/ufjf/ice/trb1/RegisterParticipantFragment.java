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
import persistence.ParticipantDAO;
import utils.NotificationService;

public class RegisterParticipantFragment extends Fragment {

    private TextView pName;
    private TextView pMail;
    private TextView pRegisterNumber;
    private Button pRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_register_participant, container, false);

        pName = rootView.findViewById(R.id.p_add_name);
        pMail = rootView.findViewById(R.id.p_add_mail);
        pRegisterNumber = rootView.findViewById(R.id.p_add_register_number);

        pRegister = rootView.findViewById(R.id.add_participant_action);

        pRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameContent = pName.getText().toString();
                String mailContent = pMail.getText().toString();
                String registerNumberContent = pRegisterNumber.getText().toString();

                if(isParticipantValid(view, nameContent, mailContent, registerNumberContent)){
                    if(ParticipantDAO.create(registerNumberContent, nameContent, mailContent)){

                        NotificationService.sendToast(view,  nameContent + " cadastrado!");

                        Participant p = ParticipantDAO.getLast();
                        ((GetAllParticipantsAdapter) GetAllParticipantsFragment.getAdapter()).addParticipant(p);
                    }
                    else {
                        NotificationService.sendToast(view,  nameContent + "não cadastrado. Erro ao acessar o banco.");
                    }

                    cleanViews();

                }

            }

            private void cleanViews() {
                pName.setText("");
                pMail.setText("");
                pRegisterNumber.setText("");
            }
        });

        return rootView;
    }

    private boolean isParticipantValid(View v, String nameContent, String mailContent, String registerNumberContent) {

        if(nameContent == null || nameContent.isEmpty()){
            NotificationService.sendToast(v, "Insira um nome válido!");
            return false;
        }

        else if(mailContent == null || mailContent.isEmpty()){
            NotificationService.sendToast(v, "Insira um e-mail válido!");
            return false;
        }

        else if(registerNumberContent == null || registerNumberContent.isEmpty()){
            NotificationService.sendToast(v, "Insira um CPF válido!");
            return false;
        }

        return true;
    }
}
