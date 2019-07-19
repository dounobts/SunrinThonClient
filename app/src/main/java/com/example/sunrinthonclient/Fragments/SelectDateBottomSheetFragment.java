package com.example.sunrinthonclient.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
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

import com.example.sunrinthonclient.Activities.MainActivity;
import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Retrofit.Client;
import com.example.sunrinthonclient.SelectTimeDialog;
import com.example.sunrinthonclient.SelectedData;
import com.example.sunrinthonclient.UserInfoDialog;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        if (SelectedData.isAdmin == false) {
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 1, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton1.setText("예약불가");
                            break;
                        case 404:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton1.setText("예약하기");
                            break;
                        case 500:
                            Snackbar.make(timeButton1, "정보 불러오기 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }
                @Override public void onFailure(Call<ResponseBody> call, Throwable t) {}});
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 2, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton2.setText("예약불가");
                            break;
                        case 404:
                            timeButton2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton2.setText("예약하기");
                            break;
                        case 500:
                            Snackbar.make(timeButton1, "정보 불러오기 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }
                @Override public void onFailure(Call<ResponseBody> call, Throwable t) {}});
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 3, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton3.setText("예약불가");
                            break;
                        case 404:
                            timeButton3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton3.setText("예약하기");
                            break;
                        case 500:
                            Snackbar.make(timeButton1, "정보 불러오기 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }
                @Override public void onFailure(Call<ResponseBody> call, Throwable t) {}});
        } else {
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 1, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton1.setText("예약확인");
                            break;
                        case 404:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton1.setText("예약없음");
                            break;
                        case 500:
                            Snackbar.make(timeButton1, "정보 불러오기 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }
                @Override public void onFailure(Call<ResponseBody> call, Throwable t) {}});
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 2, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton2.setText("예약확인");
                            break;
                        case 404:
                            timeButton2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton2.setText("예약없음");
                            break;
                        case 500:
                            Snackbar.make(timeButton1, "정보 불러오기 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }
                @Override public void onFailure(Call<ResponseBody> call, Throwable t) {}});
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 3, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton3.setText("예약확인");
                            break;
                        case 404:
                            timeButton3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton3.setText("예약없음");
                            break;
                        case 500:
                            Snackbar.make(timeButton1, "정보 불러오기 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }
                @Override public void onFailure(Call<ResponseBody> call, Throwable t) {}});
        }

        timeButton1.setOnClickListener(this);
        timeButton2.setOnClickListener(this);
        timeButton3.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (SelectedData.isAdmin) {
            Log.i("123", "123");

            if (v.equals(timeButton1)) {
                new UserInfoDialog(getContext()).show();
            }
            else if (v.equals(timeButton2)) {
                SelectedData.time = 2;
                new UserInfoDialog(getContext()).show();

            }
            else if (v.equals(timeButton3)) {
                SelectedData.time = 3;
                new UserInfoDialog(getContext()).show();
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
