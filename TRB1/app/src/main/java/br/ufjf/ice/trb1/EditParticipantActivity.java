package br.ufjf.ice.trb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Participant;
import model.Participants;

public class EditParticipantActivity extends AppCompatActivity {

    private TextView pName;
    private TextView pMail;
    private TextView pId;
    private Button pRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_participant);

        pName = findViewById(R.id.p_edit_name);
        pMail = findViewById(R.id.p_edit_mail);
        pId = findViewById(R.id.p_edit_id);
        pRegister = findViewById(R.id.p_modify_action);

        Bundle extras = getIntent().getExtras();
        final String nameContent = extras.getString("P_NAME");
        String mailContent = extras.getString("P_MAIL");
        String idContent = extras.getString("P_ID");

        if(!(nameContent.isEmpty() || mailContent.isEmpty() || idContent.isEmpty())){
            pName.setText(nameContent);
            pMail.setText(mailContent);
            pId.setText(idContent);
        }

        pRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = pName.getText().toString();
                String newMail = pMail.getText().toString();
                String newId = pId.getText().toString();

                if(newName == null || newName.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um nome válido!", Toast.LENGTH_SHORT).show();
                else if(newMail == null || newMail.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um e-mail válido!", Toast.LENGTH_SHORT).show();
                else if(newId == null || newId.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um CPF válido!", Toast.LENGTH_SHORT).show();
                else{
                    Participant modified = new Participant(newName, newMail, newId);
                    Participant toRemove = Participants.getInstance().searchFor(nameContent);

                    Participants.getInstance().getAllParticipants().remove(toRemove);
                    Participants.getInstance().getAllParticipants().add(modified);

                    Toast.makeText(v.getContext(), newName + " modificado com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
