package com.example.sunrinthonclient.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sunrinthonclient.Activities.LoginActivity;
import com.example.sunrinthonclient.Activities.ReservationActivity;
import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Retrofit.Client;
import com.google.android.material.snackbar.Snackbar;

import androidx.fragment.app.Fragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    LoginActivity activity;
    View view;

    ImageButton back, register;
    EditText usernameEdit, passwordEdit, checkEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        activity = (LoginActivity) getActivity();

        back = view.findViewById(R.id.button_back);
        register = view.findViewById(R.id.button_register);

        usernameEdit = view.findViewById(R.id.input_student);
        passwordEdit = view.findViewById(R.id.input_name);
        checkEdit = view.findViewById(R.id.input_code);

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
            if (passwordEdit.getText().toString().equals(checkEdit.getText().toString())) {
                Client.retrofitService.register(usernameEdit.getText().toString(), passwordEdit.getText().toString(), Client.name, Client.personalid).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch (response.code()) {
                            case 200:
                                startActivity(new Intent(activity, ReservationActivity.class));
                                activity.finish();
                                break;
                            case 403:
                                Snackbar.make(back, "회원 가입 실패 : 이미 존재하는 계정입니다.", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 500:
                                Snackbar.make(back, "회원 가입 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            } else {
                Snackbar.make(back, "회원 가입 실패 : 비밀번호가 잘못 입력되었습니다.", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}
