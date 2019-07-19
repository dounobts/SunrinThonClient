package com.example.sunrinthonclient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sunrinthonclient.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SelectDateBottomSheetFragment extends BottomSheetDialogFragment {
    public static SelectDateBottomSheetFragment getInstance() { return new SelectDateBottomSheetFragment(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_selectdate, container, false);
        return view;
    }
}
