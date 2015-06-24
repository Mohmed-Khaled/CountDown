package com.example.android.countdown;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;


public class CountDownActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        final TextView days = (TextView) findViewById(R.id.days);
        final TextView hours = (TextView) findViewById(R.id.hours);
        final TextView minutes = (TextView) findViewById(R.id.minutes);
        final TextView seconds = (TextView) findViewById(R.id.seconds);

        Intent intent = getIntent();
        final long time = intent.getLongExtra("time", 0);
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                long day = millisUntilFinished / (1000*60*60*24) ;
                long hour = millisUntilFinished / (1000*60*60) - 24 * day ;
                long minute = millisUntilFinished / (1000*60) - 24 * 60 * day - 60 * hour ;
                long second = millisUntilFinished / (1000) - 24 * 3600 * day - 3600 * hour - 60 * minute ;
                if ( day == 1){
                    days.setText(String.valueOf(day) + " Day");
                }else {
                    days.setText(String.valueOf(day) + " Days");
                } if ( hour == 1){
                    hours.setText(String.valueOf(hour) + " Hour");
                }else {
                    hours.setText(String.valueOf(hour) + " Hours");
                }
                if ( minute == 1){
                    minutes.setText(String.valueOf(minute) + " Minute");
                }else {
                    minutes.setText(String.valueOf(minute) + " Minutes");
                }
                if ( second == 1){
                    seconds.setText(String.valueOf(second) + " Second");
                }else {
                    seconds.setText(String.valueOf(second) + " Seconds");
                }
            }

            public void onFinish() {
            }
        }.start();

    }

}
