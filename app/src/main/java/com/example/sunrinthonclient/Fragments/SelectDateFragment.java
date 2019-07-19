package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunrinthonclient.CalendarPagerAdapter;
import com.example.sunrinthonclient.R;

import java.util.Calendar;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class SelectDateFragment extends Fragment {
    View view;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_date, container, false);

        viewPager = view.findViewById(R.id.calandar_viewPager);
        CalendarPagerAdapter calendarPagerAdapter = new CalendarPagerAdapter(getContext(), getFragmentManager());
        viewPager.setAdapter(calendarPagerAdapter);
        setCalendar();

        return view;
    }

    private void setCalendar() {
        Calendar nowCalendar = Calendar.getInstance();
        viewPager.setCurrentItem(nowCalendar.get(Calendar.MONTH));
    }
}
