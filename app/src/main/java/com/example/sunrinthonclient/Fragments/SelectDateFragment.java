package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.sunrinthonclient.Activities.MainActivity;
import com.example.sunrinthonclient.CalendarPagerAdapter;
import com.example.sunrinthonclient.R;

import java.util.Calendar;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class SelectDateFragment extends Fragment implements View.OnClickListener {
    MainActivity activity;
    View view;
    ViewPager viewPager;

    ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_date, container, false);
        activity = (MainActivity) getActivity();

        viewPager = view.findViewById(R.id.calandar_viewPager);
        CalendarPagerAdapter calendarPagerAdapter = new CalendarPagerAdapter(getContext(), getFragmentManager());
        viewPager.setAdapter(calendarPagerAdapter);
        setCalendar();

        back = view.findViewById(R.id.button_back);
        back.setOnClickListener(this);

        return view;
    }

    private void setCalendar() {
        Calendar nowCalendar = Calendar.getInstance();
        viewPager.setCurrentItem(nowCalendar.get(Calendar.MONTH));
    }

    @Override
    public void onClick(View v) {
        if (v.equals(back)) {
            activity.changeFragment(0);
        }
    }
}
