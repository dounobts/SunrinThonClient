package com.example.sunrinthonclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sunrinthonclient.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View reservation, reservation_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reservation = findViewById(R.id.reservation);
        reservation_check = findViewById(R.id.reservation_check);

        reservation.setOnClickListener(this);
        reservation_check.setOnClickListener(this);
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
