package com.example.example6_1_textclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1. 참조 변수 생성
    Button btn1;
    TextView tv1;
    TextClock tc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 참조변수에 객체 연결
        btn1=findViewById(R.id.btn1);
        tv1=findViewById(R.id.tv1);
        tc2=findViewById(R.id.tc2);

        // 3. 버튼 클릭 이벤트 처리
       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("Time:"+tc2.getText().toString());
            }
        });

    }
}
