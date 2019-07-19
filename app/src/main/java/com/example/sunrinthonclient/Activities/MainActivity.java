package com.example.sunrinthonclient.Activities;

import android.os.Bundle;

import com.example.sunrinthonclient.Fragments.SelectDateFragment;
import com.example.sunrinthonclient.Fragments.SelectPlaceFragment;
import com.example.sunrinthonclient.R;

import androidx.appcompat.app.AppCompatActivity;

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
