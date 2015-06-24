package com.example.android.countdown;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View v){
        final Calendar c = Calendar.getInstance();
        Date prDate = c.getTime();
        long prTime = prDate.getTime();
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        GregorianCalendar calendar = new GregorianCalendar(year,month,day,hour,minute);
        Date date = calendar.getTime();
        long time = date.getTime();
        long dfTime = time - prTime;
        Intent intent = new Intent(this,CountDownActivity.class);
        intent.putExtra("time",dfTime);
        startActivity(intent);
    }


}
