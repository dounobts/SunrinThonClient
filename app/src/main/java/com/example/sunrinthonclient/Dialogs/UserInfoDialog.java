package com.example.sunrinthonclient.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Retrofit.Client;
import com.example.sunrinthonclient.SelectedData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoDialog extends Dialog {

    TextView nameText, whenText;
    public UserInfoDialog(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.userinfo_dialog_layout);

        nameText = findViewById(R.id.name);
        whenText = findViewById(R.id.when);

        Client.retrofitService.getroom(SelectedData.month+1, SelectedData.day, SelectedData.time, SelectedData.place).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject object = new JSONObject(response.body().string());
                    Client.retrofitService.getprofile("test1").enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                nameText.setText(jsonObject.getString("personalID") + jsonObject.getString("name"));
                                whenText.setText((SelectedData.month+1) + "월" + SelectedData.day + "일");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        findViewById(R.id.board).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        try {
            dismiss();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
