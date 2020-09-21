package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    TextView textView;
    RadioButton rdCall, rdCamera;
    Button btnBack;
    String tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView);
        rdCall = findViewById(R.id.rdCall);
        rdCamera = findViewById(R.id.rdCamera);
        btnBack = findViewById(R.id.btnBack);

        Intent outintent = getIntent();
        tv = outintent.getStringExtra("name");
        textView.setText(tv);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdCall.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    int i = 1;
                    intent.putExtra("gab", i);
                    setResult(RESULT_OK, intent);
                    finish();
                }else if(rdCamera.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    int i = 2;
                    intent.putExtra("gab", i);
                    setResult(RESULT_OK, intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "체크해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}