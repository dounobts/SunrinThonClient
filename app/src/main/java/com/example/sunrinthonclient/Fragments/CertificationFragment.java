package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunrinthonclient.R;

import androidx.fragment.app.Fragment;

public class CertificationFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_certification, container, false);

        return view;
    }
}
