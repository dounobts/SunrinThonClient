package com.example.sunrinthonclient;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunrinthonclient.Activities.MainActivity;
import com.example.sunrinthonclient.Activities.ReservationActivity;
import com.example.sunrinthonclient.Fragments.SelectDateBottomSheetFragment;
import com.example.sunrinthonclient.Retrofit.Client;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                Client.retrofitService.reserve(Client.username, SelectedData.place, SelectedData.month + 1, SelectedData.day, SelectedData.time). enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch(response.code()) {
                            case 200:
                                new CompleteDialog(context, fragment, activity).show();
                                break;
                            case 403:
                                Snackbar.make(yes, "예약 실패 : 예약이 불가능한 공간입니다.", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 500:
                                Snackbar.make(yes, "예약 실패 : 서버 오류", Snackbar.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
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
