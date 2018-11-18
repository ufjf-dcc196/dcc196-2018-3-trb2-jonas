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
import model.Event;

public class RegisterEventFragment extends Fragment {
    private TextView eTitle;
    private TextView eDay;
    private TextView eHour;
    private TextView eFacilitator;
    private TextView eDescription;
    private Button eRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_register_event, container, false);

        eTitle = rootView.findViewById(R.id.e_add_title);
        eDay = rootView.findViewById(R.id.e_add_day);
        eHour = rootView.findViewById(R.id.e_add_hour);
        eFacilitator = rootView.findViewById(R.id.e_add_facilitator);
        eDescription = rootView.findViewById(R.id.e_add_description);

        eRegister = rootView.findViewById(R.id.add_event_action);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = eTitle.getText().toString();
                String day = eDay.getText().toString();
                String hour = eHour.getText().toString();
                String facilitator = eFacilitator.getText().toString();
                String description = eDescription.getText().toString();

                if(title == null || title.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um título de evento válido!", Toast.LENGTH_SHORT).show();
                else if(day == null || day.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um dia válido!", Toast.LENGTH_SHORT).show();
                else if(hour == null || hour.isEmpty())
                    Toast.makeText(v.getContext(), "Insira uma hora válida!", Toast.LENGTH_SHORT).show();
                else if(facilitator == null || facilitator.isEmpty())
                    Toast.makeText(v.getContext(), "Insira um facilitador válido!", Toast.LENGTH_SHORT).show();
                else if(description == null || description.isEmpty())
                    Toast.makeText(v.getContext(), "Insira uma descrição válida!", Toast.LENGTH_SHORT).show();
                else{
                    Event e = new Event(title, Integer.parseInt(day), Integer.parseInt(hour), facilitator, description);
                    //if(Events.getInstance().searchFor(title) == null)
                        //Events.getInstance().getAllEvents().add(e);

                    Toast.makeText(v.getContext(), title + " cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }

}
