package com.example.sunrinthonclient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ReservationAdapter extends RecyclerView.Adapter {
    ArrayList<ReservationData> datas;
    public boolean isEdit = false;
    public Context context;

    public ReservationAdapter(ArrayList<ReservationData> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        final View view = inflater.inflate(R.layout.reservation_item, viewGroup, false) ;
        TextView close = view.findViewById(R.id.time);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEdit) {
                    TextView index = view.findViewById(R.id.index);
                    datas.remove(Integer.parseInt(index.getText().toString()));
                    notifyDataSetChanged();
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
