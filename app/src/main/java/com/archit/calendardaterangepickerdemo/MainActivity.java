package com.archit.calendardaterangepickerdemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DateRangeCalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = findViewById(R.id.calendar);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "JosefinSans-Regular.ttf");
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "LobsterTwo-Regular.ttf");
        calendar.setFonts(typeface);

        calendar.setCalendarListener(new DateRangeCalendarView.CalendarListener() {
            @Override
            public void onFirstDateSelected(@NonNull Calendar startDate) {
                Toast.makeText(MainActivity.this, "Start Date: " + startDate.getTime().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(@NonNull Calendar startDate, @NonNull Calendar endDate) {
                Toast.makeText(MainActivity.this, "Start Date: " + startDate.getTime().toString() + " End date: " + endDate.getTime().toString(), Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.resetAllSelectedViews();
            }
        });

        final Calendar current = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.set(Calendar.MONTH, Calendar.JANUARY);
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.YEAR, 2018);
        calendar.setVisibleMonthRange(start, current);
        calendar.setSelectableDateRange(start, current);
        calendar.setCurrentMonth(current);
    }
}
