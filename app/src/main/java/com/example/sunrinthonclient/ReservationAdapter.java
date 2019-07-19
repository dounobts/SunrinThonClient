package com.example.sunrinthonclient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunrinthonclient.Retrofit.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationAdapter extends RecyclerView.Adapter {
    ArrayList<ReservationData> datas;
    public boolean isEdit = false;
    public Context context;

    public ReservationAdapter(ArrayList<ReservationData> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        final View view = inflater.inflate(R.layout.reservation_item, viewGroup, false) ;
        TextView close = view.findViewById(R.id.time);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEdit) {
                    Calendar calendar = Calendar.getInstance();
                    int roomnum = 0, a = 1;
                    switch (datas.get(i).place) {
                        case "세계로 1": roomnum = 0; break;
                        case "세계로 2": roomnum = 1; break;
                        case "세계로 3": roomnum = 2; break;
                        case "세계로 4": roomnum = 3; break;
                        case "세계로 5": roomnum = 4; break;
                        case "세계로 6": roomnum = 5; break;
                        case "미래로 1": roomnum = 6; break;
                        case "미래로 2": roomnum = 7; break;
                        case "미래로 3": roomnum = 8; break;
                    }
                    switch (datas.get(i).time) {
                        case "5시~6시": a = 1; break;
                        case "7시~8시": a = 2; break;
                        case "8시~9시": a = 3; break;
                    }
                    Client.retrofitService.cancel(Client.username, roomnum, calendar.get(Calendar.MONTH) + 1, Integer.parseInt(datas.get(i).day.split("/")[1]), a).enqueue(new Callback<ResponseBody>() {

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            TextView index = view.findViewById(R.id.index);
                            datas.remove(Integer.parseInt(index.getText().toString()));
                            notifyDataSetChanged();
                        }
                    });
                }
            }
        });
        RecyclerView.ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder)viewHolder;
        vh.day.setText(datas.get(i).day);
        vh.place.setText(datas.get(i).place);
        vh.index.setText(i + "");

        if (isEdit) {
            vh.time.setText("X");
            vh.time.setTextColor(ContextCompat.getColor(context, R.color.red));
        }
        else {
            vh.time.setText(datas.get(i).time);
            vh.time.setTextColor(ContextCompat.getColor(context, R.color.gray70));
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView day, time, place, index;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            day = itemView.findViewById(R.id.day);
            time = itemView.findViewById(R.id.time);
            place = itemView.findViewById(R.id.place);
            index = itemView.findViewById(R.id.index);
        }
    }
}
