package com.example.ex01_practice10_1_diy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.ServiceWorkerController;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton sa, ta;
    Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sa = findViewById(R.id.secondac);
        ta = findViewById(R.id.thirdac);
        btnNew = findViewById(R.id.btnNew);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(sa.isChecked()){
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                }else{
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                }
                startActivity(intent);
            }
        });
    }
}
