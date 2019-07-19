package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sunrinthonclient.Activities.MainActivity;
import com.example.sunrinthonclient.R;

import androidx.fragment.app.Fragment;

public class SelectPlaceFragment extends Fragment implements View.OnClickListener {
    MainActivity activity;
    View view;

    Button toFuture1, toFuture2, toFuture3,
            toWorld1, toWorld2, toWorld3,
            toWorld4, toWorld5, toWorld6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_place, container, false);

        activity = (MainActivity) getActivity();

        toFuture1 = view.findViewById(R.id.place_toFuture1);
        toFuture2 = view.findViewById(R.id.place_toFuture2);
        toFuture3 = view.findViewById(R.id.place_toFuture3);
        toWorld1 = view.findViewById(R.id.place_toWorld1);
        toWorld2 = view.findViewById(R.id.place_toWorld2);
        toWorld3 = view.findViewById(R.id.place_toWorld3);
        toWorld4 = view.findViewById(R.id.place_toWorld4);
        toWorld5 = view.findViewById(R.id.place_toWorld5);
        toWorld6 = view.findViewById(R.id.place_toWorld6);

        toFuture1.setOnClickListener(this);
        toFuture2.setOnClickListener(this);
        toFuture3.setOnClickListener(this);
        toWorld1.setOnClickListener(this);
        toWorld2.setOnClickListener(this);
        toWorld3.setOnClickListener(this);
        toWorld4.setOnClickListener(this);
        toWorld5.setOnClickListener(this);
        toWorld6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        activity.toSelectDate(0);
    }
}
