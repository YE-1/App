package com.example.practice6_1datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    RadioButton rd1, rd2;
    DatePicker dp;
    TimePicker tp;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약(수정)");

        chronometer = findViewById(R.id.chronometer);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        tv = findViewById(R.id.tv);

        tp.setVisibility(View.INVISIBLE);
        dp.setVisibility(View.INVISIBLE);
        rd1.setVisibility(View.INVISIBLE);
        rd2.setVisibility(View.INVISIBLE);


        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setVisibility(View.INVISIBLE);
                dp.setVisibility(View.VISIBLE);
            }
        });

        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setVisibility(View.VISIBLE);
                dp.setVisibility(View.INVISIBLE);
            }
        });

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                rd1.setVisibility(View.VISIBLE);
                rd2.setVisibility(View.VISIBLE);
            }
        });
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chronometer.stop();

                tv.setText(Integer.toString(dp.getYear())+"년 "+Integer.toString(1+dp.getMonth())+"월 "+Integer.toString(dp.getDayOfMonth())+"일 "+Integer.toString(tp.getCurrentHour())+"시 "+Integer.toString(tp.getCurrentMinute())+"분");

                tp.setVisibility(View.INVISIBLE);
                dp.setVisibility(View.INVISIBLE);
                rd1.setVisibility(View.INVISIBLE);
                rd2.setVisibility(View.INVISIBLE);

                return false;
            }
        });

    }
}
