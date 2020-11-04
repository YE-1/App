package com.example.p2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;
    RadioButton rdCall, rdCamera;
    Button btnBack;
    String getTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.tv);
        rdCall = findViewById(R.id.rdCall);
        rdCamera = findViewById(R.id.rdCamera);
        btnBack = findViewById(R.id.btnBack);

        final Intent outintent = getIntent();
        getTv = getIntent().getStringExtra("name");
        tv.setText(getTv);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdCall.isChecked()){
                    Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                    int i=1;
                    intent.putExtra("gab", i);
                    setResult(RESULT_OK, intent);
                    finish();
                }else if(rdCamera.isChecked()){
                    Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                    int i=2;
                    intent.putExtra("gab", i);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}