package com.example.sunrinthonclient.Activities;

import android.os.Bundle;

import com.example.sunrinthonclient.Fragments.CertificationFragment;
import com.example.sunrinthonclient.Fragments.LoginFragment;
import com.example.sunrinthonclient.Fragments.RegisterFragment;
import com.example.sunrinthonclient.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class LoginActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;
    CertificationFragment certificationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        certificationFragment = new CertificationFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, loginFragment).commit();
    }

    public void changeFragment(int showFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);

        if (showFragment == 0) {
            fragmentTransaction.setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide2);
            fragmentTransaction.replace(R.id.container, loginFragment);
        }
        else if (showFragment == 1) {
            fragmentTransaction.setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide);
            fragmentTransaction.replace(R.id.container, certificationFragment);
        }
        else if (showFragment == 2) {
            fragmentTransaction.setCustomAnimations(R.anim.fragment_show, R.anim.fragment_hide);
            fragmentTransaction.replace(R.id.container, registerFragment);
        }

        fragmentTransaction.commit();
    }
}
