package com.example.drone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    LinearLayout linearLayout, linearLayout2, linearLayout3;
    Intent drone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);

        linearLayout.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.linearLayout:
                drone = new Intent(this,  drone_control.class);
                startActivity(drone);
                break;
            case R.id.linearLayout2:
                drone = new Intent(this, drone_place.class);
                startActivity(drone);
                break;
            case R.id.linearLayout3:
                drone = new Intent(this, drone_video.class);
                startActivity(drone);
                break;
        }
    }
}