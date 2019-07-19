package com.example.sunrinthonclient.Activities;

import android.os.Bundle;

import com.example.sunrinthonclient.Fragments.LoginFragment;
import com.example.sunrinthonclient.Fragments.RegisterFragment;
import com.example.sunrinthonclient.Fragments.SelectDateFragment;
import com.example.sunrinthonclient.Fragments.SelectPlaceFragment;
import com.example.sunrinthonclient.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, loginFragment).commit();
    }

    public void toRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, registerFragment).commit();
    }
}
