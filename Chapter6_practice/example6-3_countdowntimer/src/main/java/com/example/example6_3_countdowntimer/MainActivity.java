package com.example.example6_3_countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textViewTimer;
    Button btnStart, btnStop, btnPause;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 참조변수에 위젯 연결
        textViewTimer=findViewById(R.id.tv1);
        btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);
        btnPause=findViewById(R.id.btnPause);

      /*  countDownTimer=new CountDownTimer(30*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"CountDown Finished",Toast.LENGTH_SHORT).show();
            }
        };*/

        countDownTimer(30*1000, 1000);

        // 3. 버튼 이벤트
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnPause.getText().equals("PAUSE")){
                    btnPause.setText("RESTART");
                }else{
                    btnPause.setText("PAUSE");
                }
            }
        });
    }

    private void countDownTimer(long millisInFuture, long countDownInterval){
        countDownTimer=new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"CountDown Finished",Toast.LENGTH_SHORT).show();
            }
        };
    }
}
