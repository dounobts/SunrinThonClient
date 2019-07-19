package com.example.sunrinthonclient.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.ReservationAdapter;
import com.example.sunrinthonclient.ReservationData;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReservationCheckActivity extends Activity implements View.OnClickListener {

    ReservationAdapter reservationAdapter;
    RecyclerView recyclerView;
    TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_check);

        recyclerView = findViewById(R.id.recyclerView);
        edit = findViewById(R.id.edit);

        ArrayList<ReservationData> datas = new ArrayList<>();
        datas.add(new ReservationData("미래로 1", "7시~8시", "9/13"));
        datas.add(new ReservationData("미래로 2", "7시~8시", "9/11"));
        datas.add(new ReservationData("세계로 1", "7시~8시", "9/2"));
        datas.add(new ReservationData("세계로 2", "7시~8시", "9/4"));
        datas.add(new ReservationData("미래로 3", "7시~8시", "9/5"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reservationAdapter = new ReservationAdapter(datas);
        reservationAdapter.context = getApplicationContext();
        recyclerView.setAdapter(reservationAdapter);

        edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(edit)) {
            reservationAdapter.isEdit = !reservationAdapter.isEdit;
            reservationAdapter.notifyDataSetChanged();
        }
    }
}
