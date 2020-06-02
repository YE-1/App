package com.example.example6_2_chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    Chronometer ch;
    long timeWhenStopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch=findViewById(R.id.ch);
        btn1=findViewById(R.id.start);
        btn2=findViewById(R.id.stop);
        btn3=findViewById(R.id.reset);

        // 3. 버튼 클릭 이벤트 처리

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime()+timeWhenStopped);
                ch.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeWhenStopped=ch.getBase()-SystemClock.elapsedRealtime();
                ch.stop();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.stop();
                timeWhenStopped=0;
            }
        });



        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                Log.d("realTime", String.valueOf(SystemClock.elapsedRealtime()));
            }
        });

    }

}
