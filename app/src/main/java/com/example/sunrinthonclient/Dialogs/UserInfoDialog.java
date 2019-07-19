package com.example.sunrinthonclient.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.sunrinthonclient.R;

public class UserInfoDialog extends Dialog {

    TextView nameText, whenText;
    public UserInfoDialog(Context context, String name, String when) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.userinfo_dialog_layout);

        nameText = findViewById(R.id.name);
        whenText = findViewById(R.id.when);

        nameText.setText(name);
        nameText.setText(when);

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
