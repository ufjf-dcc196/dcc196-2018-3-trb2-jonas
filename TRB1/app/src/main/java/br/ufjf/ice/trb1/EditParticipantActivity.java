package br.ufjf.ice.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Participant;
import persistence.ParticipantDAO;

public class EditParticipantActivity extends AppCompatActivity {

    private TextView pName;
    private TextView pMail;
    private TextView pRegisterNumber;
    private Button pSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_participant);

        pName = findViewById(R.id.p_edit_name);
        pMail = findViewById(R.id.p_edit_mail);
        pRegisterNumber = findViewById(R.id.p_edit_register_number);
        pSave = findViewById(R.id.p_modify_action);

        Bundle extras = getIntent().getExtras();
        final String nameContent = extras.getString("P_NAME");
        String mailContent = extras.getString("P_MAIL");
        String idContent = extras.getString("P_ID");

        if(!(nameContent.isEmpty() || mailContent.isEmpty() || idContent.isEmpty())){
            pName.setText(nameContent);
            pMail.setText(mailContent);
            pRegisterNumber.setText(idContent);
        }

        pSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = pName.getText().toString();
                String newMail = pMail.getText().toString();
                String newRegisterNumber = pRegisterNumber.getText().toString();

                if(newName == null || newName.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um nome válido!", Toast.LENGTH_SHORT).show();
                else if(newMail == null || newMail.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um e-mail válido!", Toast.LENGTH_SHORT).show();
                else if(newRegisterNumber == null || newRegisterNumber.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um CPF válido!", Toast.LENGTH_SHORT).show();
                else{
                    //ParticipantDAO.update(new Participant(newName, newRegisterNumber, newMail));

                    Toast.makeText(v.getContext(), newName + " modificado com sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    v.getContext().startActivity(intent);
                    finish();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        GetAllParticipantsFragment.getAdapter().notifyDataSetChanged();
        ViewEventDetailsActivity.getAdapter().notifyDataSetChanged();
    }
}
