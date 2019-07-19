package com.example.sunrinthonclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sunrinthonclient.Activities.MainActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarPagerAdapter extends PagerAdapter {

    private Context mContext = null ;

    public CalendarPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;

        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.calendar_pager_layout, container, false);
            TextView textView = (TextView) view.findViewById(R.id.text) ;
            textView.setText(position + 1 + "월") ;
            setCalendar(view, position);
        }
        container.addView(view) ;

        return view ;
    }

    private void setCalendar(View view, final int month) {
        Calendar nowCalendar = Calendar.getInstance();
        final int year = nowCalendar.get(Calendar.YEAR);

        Calendar calendar = new GregorianCalendar(year, month, 1);
        int nowDay = 1;
        int firstWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        int index = firstWeek - 2;

        if (firstWeek == 1) {
            index = 0;
            nowDay = 2;
        }
        if (firstWeek == 7) {
            index = 0;
            nowDay = 3;
        }

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add((Button)view.findViewById(R.id.date1));
        buttons.add((Button)view.findViewById(R.id.date2));
        buttons.add((Button)view.findViewById(R.id.date3));
        buttons.add((Button)view.findViewById(R.id.date4));
        buttons.add((Button)view.findViewById(R.id.date5));
        buttons.add((Button)view.findViewById(R.id.date6));
        buttons.add((Button)view.findViewById(R.id.date7));
        buttons.add((Button)view.findViewById(R.id.date8));
        buttons.add((Button)view.findViewById(R.id.date9));
        buttons.add((Button)view.findViewById(R.id.date10));
        buttons.add((Button)view.findViewById(R.id.date11));
        buttons.add((Button)view.findViewById(R.id.date12));
        buttons.add((Button)view.findViewById(R.id.date13));
        buttons.add((Button)view.findViewById(R.id.date14));
        buttons.add((Button)view.findViewById(R.id.date15));
        buttons.add((Button)view.findViewById(R.id.date16));
        buttons.add((Button)view.findViewById(R.id.date17));
        buttons.add((Button)view.findViewById(R.id.date18));
        buttons.add((Button)view.findViewById(R.id.date19));
        buttons.add((Button)view.findViewById(R.id.date20));
        buttons.add((Button)view.findViewById(R.id.date21));
        buttons.add((Button)view.findViewById(R.id.date22));
        buttons.add((Button)view.findViewById(R.id.date23));
        buttons.add((Button)view.findViewById(R.id.date24));
        buttons.add((Button)view.findViewById(R.id.date25));

        while (nowDay <= maxDay){
            buttons.get(index).setText("" + nowDay);

            index++;

            if (index % 5 == 0) {
                nowDay += 2;
            }
            nowDay++;
        }

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("calendar", "year : " + year);
                    Log.i("calendar", "month : " + month);
                    Log.i("calendar", "day : " + ((TextView)view).getText().toString());

                    new SelectTimeDialog(mContext).show();
                }
            });
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        // 전체 페이지 수는 10개로 고정.
        return 12;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
