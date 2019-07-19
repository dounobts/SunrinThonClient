package com.example.sunrinthonclient.Activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sunrinthonclient.CalendarPagerAdapter;
import com.example.sunrinthonclient.Fragments.SelectDateFragment;
import com.example.sunrinthonclient.Fragments.SelectPlaceFragment;
import com.example.sunrinthonclient.R;

public class MainActivity extends AppCompatActivity {

    SelectPlaceFragment selectPlaceFragment;
    SelectDateFragment selectDateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectDateFragment = new SelectDateFragment();
        selectPlaceFragment = new SelectPlaceFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, selectPlaceFragment).commit();
    }

    public void toSelectDate(int roomid) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, selectDateFragment).commit();
    }
}
