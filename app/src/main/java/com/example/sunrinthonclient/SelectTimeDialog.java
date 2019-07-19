package com.example.sunrinthonclient;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class SelectTimeDialog extends Dialog {
    public SelectTimeDialog(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.select_dialog_layout);
        final Button close = findViewById(R.id.close);
        final Button time1 = findViewById(R.id.time1);
        final Button time2 = findViewById(R.id.time2);
        final Button time3 = findViewById(R.id.time3);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("time", "time1");
                dismiss();
            }
        });
        time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("time", "time2");
                dismiss();
            }
        });
        time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("time", "time3");
                dismiss();
            }
        });
    }
}
