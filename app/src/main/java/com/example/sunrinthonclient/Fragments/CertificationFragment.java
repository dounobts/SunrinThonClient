package com.example.sunrinthonclient.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CertificationFragment extends Fragment implements View.OnClickListener {
    LoginActivity activity;
    View view;

    ImageButton back, check;
    EditText keyEdit, nameEdit, personalIdEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_certification, container, false);
        activity = (LoginActivity) getActivity();

        back = view.findViewById(R.id.button_back);
        check = view.findViewById(R.id.button_check);

        keyEdit = view.findViewById(R.id.input_code);
        nameEdit = view.findViewById(R.id.input_name);
        personalIdEdit = view.findViewById(R.id.input_student);

        back.setOnClickListener(this);
        check.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(back)) {
            activity.changeFragment(0);
        }
        else if (view.equals(check)) {
            Client.retrofitService.certificate(keyEdit.getText().toString(), Integer.parseInt(personalIdEdit.getText().toString())).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    switch(response.code()) {
                        case 200:
                            Client.personalid = personalIdEdit.getText().toString();
                            Client.name = nameEdit.getText().toString();
                            activity.changeFragment(2);
                            break;
                        case 403:
                            Snackbar.make(back, "인증 실패 : 올바르지 않은 인증키입니다.", Snackbar.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Snackbar.make(back, "인증 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
    }
}
