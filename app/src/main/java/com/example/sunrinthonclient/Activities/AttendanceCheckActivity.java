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
import com.example.sunrinthonclient.SelectedData;

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
    ArrayList<AttendanceData> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_check);

        datas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Client.retrofitService.getallrooms(calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JSONObject object = null;
                try {
                    object = new JSONObject(response.body().string());
                    JSONArray data = object.getJSONArray("data");
                    for (int i=0; i<data.length(); i++) {
                        JSONObject room = data.getJSONObject(i);
                        String roomname = "", time = "", day;
                        switch (room.getInt("roomnumber")) {
                            case 0: roomname = "세계로 1"; break;
                            case 1: roomname = "세계로 2"; break;
                            case 2: roomname = "세계로 3"; break;
                            case 3: roomname = "세계로 4"; break;
                            case 4: roomname = "세계로 5"; break;
                            case 5: roomname = "세계로 6"; break;
                            case 6: roomname = "미래로 1"; break;
                            case 7: roomname = "미래로 2"; break;
                            case 8: roomname = "미래로 3"; break;
                        }
                        switch (room.getInt("time")) {
                            case 1: time = "5시~6시"; break;
                            case 2: time = "7시~8시"; break;
                            case 3: time = "8시~9시"; break;
                        }
                        day = room.getString("months") + "/" + room.getString("days");
                        datas.add(new AttendanceData(roomname, time, day));
                        attendanceAdapter.notifyDataSetChanged();
                    }
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
