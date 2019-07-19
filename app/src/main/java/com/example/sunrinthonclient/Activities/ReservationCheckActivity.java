package com.example.sunrinthonclient.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sunrinthonclient.R;
import com.example.sunrinthonclient.ReservationAdapter;
import com.example.sunrinthonclient.ReservationData;
import com.example.sunrinthonclient.Retrofit.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationCheckActivity extends Activity implements View.OnClickListener {

    ReservationAdapter reservationAdapter;
    RecyclerView recyclerView;
    TextView edit;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_check);
        Calendar calendar = Calendar.getInstance();

        recyclerView = findViewById(R.id.recyclerView);
        edit = findViewById(R.id.edit);
        back = findViewById(R.id.button_back);

        Client.retrofitService.getreservedrooms(calendar.get(Calendar.MONTH)+1, Client.username).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ArrayList<ReservationData> datas = new ArrayList<>();

                try {
                    JSONObject object = new JSONObject(response.body().string());
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
                        datas.add(new ReservationData(roomname, time, day));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                reservationAdapter = new ReservationAdapter(datas);
                reservationAdapter.context = getApplicationContext();
                recyclerView.setAdapter(reservationAdapter);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        edit.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(edit)) {
            reservationAdapter.isEdit = !reservationAdapter.isEdit;
            reservationAdapter.notifyDataSetChanged();
        }
        else if (view.equals(back)) {
            finish();
        }
    }
}
