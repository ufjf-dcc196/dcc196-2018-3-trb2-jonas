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
import utils.NotificationService;

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

                if(isValidEvent(v, title, day,hour, facilitator, description)){

                }
                else{
                    Event e = new Event(title, Integer.parseInt(day), Integer.parseInt(hour), facilitator, description);
                    //if(Events.getInstance().searchFor(title) == null)
                        //Events.getInstance().getAllEvents().add(e);

                    Toast.makeText(v.getContext(), title + " cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean isValidEvent(View v,String title, String day, String hour, String facilitator, String description) {
                if(title == null || title.isEmpty())
                    NotificationService.sendToast(v, "Insira um título de evento válido!");
                else if(day == null || day.isEmpty())
                    NotificationService.sendToast(v, "Insira um dia válido!");
                else if(hour == null || hour.isEmpty())
                    NotificationService.sendToast(v, "Insira uma hora válida!");
                else if(facilitator == null || facilitator.isEmpty())
                    NotificationService.sendToast(v, "Insira um facilitador válido!");
                else if(description == null || description.isEmpty())
                    NotificationService.sendToast(v, "Insira uma descrição válida!");
                return true;
            }
        });
        return rootView;
    }

}
