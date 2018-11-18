package br.ufjf.ice.trb1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import persistence.EventDAO;

public class GetAllEventsFragment extends Fragment {

    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_get_all_events, container, false);

        recyclerView = rootView.findViewById(R.id.all_events_rv);
        layoutManager = new LinearLayoutManager(getContext());

        EventDAO eventDAO = new EventDAO(this.getContext());
        adapter = new GetAllEventsAdapter(eventDAO.getAll());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
