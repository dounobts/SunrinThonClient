package com.example.sunrinthonclient.Activities;

import android.os.Bundle;
import android.util.Log;

import com.example.sunrinthonclient.Fragments.SelectDateFragment;
import com.example.sunrinthonclient.Fragments.SelectPlaceFragment;
import com.example.sunrinthonclient.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    SelectPlaceFragment selectPlaceFragment;
    SelectDateFragment selectDateFragment;

    public int selectedRoom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectPlaceFragment = new SelectPlaceFragment();
        selectDateFragment = new SelectDateFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, selectPlaceFragment).commit();
    }

    public void changeFragment(int showFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);

        if (showFragment == 0) {
            fragmentTransaction.setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide2);
            fragmentTransaction.replace(R.id.container, selectPlaceFragment);
        }
        else if (showFragment == 1) {
            fragmentTransaction.setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide);
            fragmentTransaction.replace(R.id.container, selectDateFragment);
        }

        fragmentTransaction.commit();
    }
}
