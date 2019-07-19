package com.example.sunrinthonclient;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.sunrinthonclient.Fragments.SelectDateBottomSheetFragment;

public class UserInfoDialog extends Dialog {

    public UserInfoDialog(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.userinfo_dialog_layout);

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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
