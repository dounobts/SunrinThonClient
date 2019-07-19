package com.example.sunrinthonclient.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.sunrinthonclient.Fragments.SelectDateBottomSheetFragment;
import com.example.sunrinthonclient.R;
import com.google.android.material.snackbar.Snackbar;

public class PenaltyDialog extends Dialog {
    public PenaltyDialog(final Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.penalty_dialog_layout);
        final LinearLayout yes = findViewById(R.id.yes);
        final LinearLayout no = findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("벌점", "부과");
                dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
