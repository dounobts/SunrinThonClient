package com.example.sunrinthonclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.Retrofit.Client;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View reservation, reservation_check;
    TextView penaltyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reservation = findViewById(R.id.reservation);
        reservation_check = findViewById(R.id.reservation_check);

        reservation.setOnClickListener(this);
        reservation_check.setOnClickListener(this);

        penaltyText = findViewById(R.id.penaltyText);

        Client.retrofitService.getPenalty(Client.username).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @EverythingIsNonNull Response<ResponseBody> response) {
                switch(response.code()) {
                    case 200:
                        try {
                            JSONObject object = new JSONObject(response.body().string());
                            penaltyText.setText(object.getString("data")+"/3");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.equals(reservation)) {
            Intent intent = new Intent(getApplicationContext(), ReservationActivity.class);
            startActivity(intent);
        }
        else if (view.equals(reservation_check)) {
            Intent intent = new Intent(getApplicationContext(), ReservationCheckActivity.class);
            startActivity(intent);
        }
    }
}
