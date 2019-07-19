package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sunrinthonclient.CalendarPagerAdapter;
import com.example.sunrinthonclient.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SelectDateFragment extends Fragment {
    View view;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_date, container, false);

        viewPager = view.findViewById(R.id.calandar_viewPager);
        CalendarPagerAdapter calendarPagerAdapter = new CalendarPagerAdapter(getContext());
        viewPager.setAdapter(calendarPagerAdapter);
        setCalendar();

        return view;
    }

    private void setCalendar() {
        Calendar nowCalendar = Calendar.getInstance();
        viewPager.setCurrentItem(nowCalendar.get(Calendar.MONTH));
    }
}
