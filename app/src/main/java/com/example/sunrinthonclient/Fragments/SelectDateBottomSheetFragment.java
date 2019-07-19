package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.SelectTimeDialog;
import com.example.sunrinthonclient.SelectedData;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SelectDateBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    View view;
    TextView timeButton1, timeButton2, timeButton3;

    public static SelectDateBottomSheetFragment getInstance() { return new SelectDateBottomSheetFragment(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottomsheet_selectdate, container, false);

        timeButton1 = view.findViewById(R.id.timeButton1);
        timeButton2 = view.findViewById(R.id.timeButton2);
        timeButton3 = view.findViewById(R.id.timeButton3);

        timeButton1.setOnClickListener(this);
        timeButton2.setOnClickListener(this);
        timeButton3.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (SelectedData.isAdmin) {
            if (v.equals(timeButton1)) {
                SelectedData.time = 1;
                // 점유자 띄우기
            }
            else if (v.equals(timeButton2)) {
                SelectedData.time = 2;
                // 점유자 띄우기
            }
            else if (v.equals(timeButton3)) {
                SelectedData.time = 3;
                // 점유자 띄우기
            }
        }
        else {
            if (v.equals(timeButton1)) {
                SelectedData.time = 1;
                new SelectTimeDialog(getContext(), this, getActivity()).show();
            }
            else if (v.equals(timeButton2)) {
                SelectedData.time = 2;
                new SelectTimeDialog(getContext(), this, getActivity()).show();
            }
            else if (v.equals(timeButton3)) {
                SelectedData.time = 3;
                new SelectTimeDialog(getContext(), this, getActivity()).show();
            }
        }
    }
}
