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

import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Dialogs.SelectTimeDialog;
import com.example.sunrinthonclient.Activities.MainActivity;
import com.example.sunrinthonclient.Dialogs.SelectTimeDialog;
import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Retrofit.Client;
import com.example.sunrinthonclient.SelectedData;
import com.example.sunrinthonclient.Dialogs.UserInfoDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;

import androidx.core.content.ContextCompat;
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

        TextView AAAA = view.findViewById(R.id.AAAA);
        TextView BBBB = view.findViewById(R.id.BBBBBB);


        if (SelectedData.place == 0)
            AAAA.setText("세계로 1");
        if (SelectedData.place == 1)
            AAAA.setText("세계로 2");
        if (SelectedData.place == 2)
            AAAA.setText("세계로 3");
        if (SelectedData.place == 3)
            AAAA.setText("세계로 4");
        if (SelectedData.place == 4)
            AAAA.setText("세계로 5");
        if (SelectedData.place == 5)
            AAAA.setText("세계로 6");
        if (SelectedData.place == 6)
            AAAA.setText("미래로 1");
        if (SelectedData.place == 7)
            AAAA.setText("미래로 2");
        if (SelectedData.place == 8)
            AAAA.setText("미래로 3");

        BBBB.setText(SelectedData.month + 1 + "/" + SelectedData.day);

        if (SelectedData.isAdmin == false) {
            Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, 1, SelectedData.place).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch (response.code()) {
                        case 200:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton1.setText("예약불가");
                            timeButton1.setEnabled(false);
                            break;
                        case 404:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton1.setText("예약하기");
                            timeButton1.setEnabled(true);
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
                            timeButton2.setEnabled(false);
                            break;
                        case 404:
                            timeButton2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton2.setText("예약하기");
                            timeButton2.setEnabled(true);
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
                            timeButton3.setEnabled(false);
                            break;
                        case 404:
                            timeButton3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_skyblue_background));
                            timeButton3.setText("예약하기");
                            timeButton3.setEnabled(true);
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
                            timeButton1.setEnabled(true);
                            break;
                        case 404:
                            timeButton1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton1.setText("예약없음");
                            timeButton1.setEnabled(false);
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
                            timeButton2.setEnabled(true);
                            break;
                        case 404:
                            timeButton2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton2.setText("예약없음");
                            timeButton2.setEnabled(false);
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
                            timeButton3.setEnabled(true);
                            break;
                        case 404:
                            timeButton3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_gray_background));
                            timeButton3.setText("예약없음");
                            timeButton3.setEnabled(false);
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
                SelectedData.time = 1;
                new UserInfoDialog(getContext(), "20411방진혁", "7월 1일 5시~6시").show();
            }
            else if (v.equals(timeButton2)) {
                SelectedData.time = 2;
                new UserInfoDialog(getContext(), "20411방진혁", "7월 1일 7시~8시").show();

            }
            else if (v.equals(timeButton3)) {
                SelectedData.time = 3;
                new UserInfoDialog(getContext(), "20411방진혁", "7월 1일 8시~9시").show();
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
