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

public class SelectTimeDialog extends Dialog {
    public SelectTimeDialog(final Context context, final SelectDateBottomSheetFragment fragment, final Activity activity) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.select_dialog_layout);
        final LinearLayout yes = findViewById(R.id.yes);
        final LinearLayout no = findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("예약", "YES");
                dismiss();
                new CompleteDialog(context, fragment, activity).show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("예약", "NO");
                dismiss();
            }
        });
    }
}
