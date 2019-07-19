package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.sunrinthonclient.Activities.LoginActivity;
import com.example.sunrinthonclient.R;

import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    LoginActivity activity;
    View view;

    ImageButton back, register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        activity = (LoginActivity) getActivity();

        back = view.findViewById(R.id.button_back);
        register = view.findViewById(R.id.button_register);

        back.setOnClickListener(this);
        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(back)) {
            activity.changeFragment(0);
        }
        else if (view.equals(register)) {
            Log.i("register", "try");
        }
    }
}
