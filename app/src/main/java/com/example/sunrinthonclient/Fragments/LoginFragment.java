package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sunrinthonclient.R;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment implements View.OnClickListener {
    View view;

    TextView register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        register = view.findViewById(R.id.button_register);

        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(register)) {

        }
    }
}
