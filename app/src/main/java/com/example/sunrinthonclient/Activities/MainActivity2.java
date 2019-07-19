package com.example.sunrinthonclient.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.sunrinthonclient.R;

public class MainActivity2 extends Activity {

    View reservation, reservation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        reservation = findViewById(R.id.reservation);
        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReservationActivity.class);
                startActivity(intent);
            }
        });

        reservation2 = findViewById(R.id.reservation2);
        reservation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AttendanceCheckActivity.class);
                startActivity(intent);
            }
        });
    }
}
