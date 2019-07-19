package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunrinthonclient.Activities.ReservationActivity;
import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.SelectedData;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class SelectPlaceFragment extends Fragment implements View.OnClickListener {
    ReservationActivity activity;
    View view;

    ArrayList<LinearLayout> buttons = new ArrayList<>();
    ImageButton back, next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_place, container, false);
        activity = (ReservationActivity) getActivity();

        back = view.findViewById(R.id.button_back);
        next = view.findViewById(R.id.button_next);

        SelectedData.place = -1;
        buttons.add((LinearLayout) view.findViewById(R.id.room1));
        ((TextView)view.findViewById(R.id.room1).findViewById(R.id.room_name)).setText("미래로 1");
        ((TextView)view.findViewById(R.id.room1).findViewById(R.id.room_size)).setText("12");
        buttons.add((LinearLayout) view.findViewById(R.id.room2));
        ((TextView)view.findViewById(R.id.room2).findViewById(R.id.room_name)).setText("미래로 2");
        ((TextView)view.findViewById(R.id.room2).findViewById(R.id.room_size)).setText("12");
        buttons.add((LinearLayout) view.findViewById(R.id.room3));
        ((TextView)view.findViewById(R.id.room3).findViewById(R.id.room_name)).setText("미래로 3");
        ((TextView)view.findViewById(R.id.room3).findViewById(R.id.room_size)).setText("12");
        buttons.add((LinearLayout) view.findViewById(R.id.room4));
        ((TextView)view.findViewById(R.id.room4).findViewById(R.id.room_name)).setText("세계로 1");
        buttons.add((LinearLayout) view.findViewById(R.id.room5));
        ((TextView)view.findViewById(R.id.room5).findViewById(R.id.room_name)).setText("세계로 2");
        buttons.add((LinearLayout) view.findViewById(R.id.room6));
        ((TextView)view.findViewById(R.id.room6).findViewById(R.id.room_name)).setText("세계로 3");
        buttons.add((LinearLayout) view.findViewById(R.id.room7));
        ((TextView)view.findViewById(R.id.room7).findViewById(R.id.room_name)).setText("세계로 4");
        buttons.add((LinearLayout) view.findViewById(R.id.room8));
        ((TextView)view.findViewById(R.id.room8).findViewById(R.id.room_name)).setText("세계로 5");
        buttons.add((LinearLayout) view.findViewById(R.id.room9));
        ((TextView)view.findViewById(R.id.room9).findViewById(R.id.room_name)).setText("세계로 6");

        back.setOnClickListener(this);
        next.setOnClickListener(this);

        for (LinearLayout linearLayout : buttons) {
            linearLayout.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.equals(next)) {
            if (activity.selectedRoom == -1) {
                // 선택된 방이 없음
            }
            else {
                activity.changeFragment(1);
            }

            return;
        }
        else if (v.equals(back)) {

            return;
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).equals(v)) {
                SelectedData.place = i;

                ((TextView)buttons.get(i).findViewById(R.id.room_name)).setTextColor(ContextCompat.getColor(getContext(), R.color.selected));
                ((TextView)buttons.get(i).findViewById(R.id.room_size)).setTextColor(ContextCompat.getColor(getContext(), R.color.selected));
                ((ImageView)buttons.get(i).findViewById(R.id.man_icon)).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.accountup));
            }
            else {
                ((TextView)buttons.get(i).findViewById(R.id.room_name)).setTextColor(ContextCompat.getColor(getContext(), R.color.unselected));
                ((TextView)buttons.get(i).findViewById(R.id.room_size)).setTextColor(ContextCompat.getColor(getContext(), R.color.unselected));
                ((ImageView)buttons.get(i).findViewById(R.id.man_icon)).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.accountdown));
            }
        }
    }
}
