package com.example.sunrinthonclient.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sunrinthonclient.AttendanceAdapter;
import com.example.sunrinthonclient.AttendanceData;
import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.ReservationAdapter;
import com.example.sunrinthonclient.ReservationData;
import com.example.sunrinthonclient.Retrofit.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceCheckActivity extends Activity implements View.OnClickListener {

    AttendanceAdapter attendanceAdapter;
    RecyclerView recyclerView;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_check);

        ArrayList<AttendanceData> datas = new ArrayList<>();
        datas.add(new AttendanceData("미래로 1", "7시~", "이우령"));
        datas.add(new AttendanceData("미래로 3", "8시~", "방진혁"));
        datas.add(new AttendanceData("미래로 2", "5시~", "염태민"));
        datas.add(new AttendanceData("세계로 4", "5시~", "이우령"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        attendanceAdapter = new AttendanceAdapter(datas);
        attendanceAdapter.context = getApplicationContext();
        attendanceAdapter.activity = this;
        recyclerView.setAdapter(attendanceAdapter);

        back = findViewById(R.id.button_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(back)) {
            finish();
        }
    }
}
