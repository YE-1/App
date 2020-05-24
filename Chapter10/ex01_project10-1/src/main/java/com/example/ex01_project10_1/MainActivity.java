package com.example.ex01_project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton radioBtn1 = findViewById(R.id.radioBtn1);
        final RadioButton radioBtn2 = findViewById(R.id.radioBtn2);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);

/*
        radioBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);  // SecondActivity 시작
            }
        });

        radioBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });*/

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioBtn1.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);  // SecondActivity 시작
                }
                if (radioBtn2.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);  // SecondActivity 시작
                }

            }
        });
    }
}
