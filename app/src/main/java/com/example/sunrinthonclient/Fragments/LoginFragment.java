package com.example.sunrinthonclient.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunrinthonclient.Activities.LoginActivity;
import com.example.sunrinthonclient.Activities.MainActivity;
import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Retrofit.Client;
import com.google.android.material.snackbar.Snackbar;

import androidx.fragment.app.Fragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements View.OnClickListener {
    LoginActivity activity;
    View view;

    TextView register;
    ImageButton loginButton;
    EditText usernameInput, passwordInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        activity = (LoginActivity) getActivity();

        register = view.findViewById(R.id.button_register);
        loginButton = view.findViewById(R.id.button_login);
        usernameInput = view.findViewById(R.id.input_username);
        passwordInput = view.findViewById(R.id.input_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                Client.retrofitService.login(username, password).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch(response.code()) {
                            case 200:
                                activity.finish();
                                startActivity(new Intent(activity, MainActivity.class));
                                break;
                            case 404:
                                Snackbar.make(loginButton, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 500:
                                Snackbar.make(loginButton, "로그인 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

            }
        });

        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(register)) {
            activity.changeFragment(1);
        }
    }
}
