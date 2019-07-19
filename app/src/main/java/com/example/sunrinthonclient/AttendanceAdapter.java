package com.example.sunrinthonclient;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunrinthonclient.Dialogs.CompleteDialog;
import com.example.sunrinthonclient.Dialogs.PenaltyDialog;
import com.example.sunrinthonclient.Dialogs.UserInfoDialog;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AttendanceAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    ArrayList<AttendanceData> datas;
    public Activity activity;
    public Context context;

    public AttendanceAdapter(ArrayList<AttendanceData> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        final View view = inflater.inflate(R.layout.attendance_item, viewGroup, false);
        RecyclerView.ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder)viewHolder;
        vh.time.setText(datas.get(i).time);
        vh.name.setText(datas.get(i).name);
        vh.place.setText(datas.get(i).place);
        vh.index.setText(i + "");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View view) {
        new PenaltyDialog(activity).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, time, place, index;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            place = itemView.findViewById(R.id.place);
            index = itemView.findViewById(R.id.index);
        }
    }
}
