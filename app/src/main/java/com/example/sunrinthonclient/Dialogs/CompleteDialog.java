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

public class CompleteDialog extends Dialog {
    Activity activity;
    SelectDateBottomSheetFragment fragment;

    public CompleteDialog(Context context, final SelectDateBottomSheetFragment fragment, final Activity activity) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.complete_dialog_layout);

        this.activity = activity;
        this.fragment = fragment;

        findViewById(R.id.board).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        try {
            dismiss();
            fragment.dismiss();
            activity.finish();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
