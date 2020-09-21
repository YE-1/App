package com.example.a2208_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    RadioButton rdCall, rdCamera;
    Button btnMainBack;
    RadioGroup radioGroup;
    String tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rdCall = findViewById(R.id.rdCall);
        rdCamera = findViewById(R.id.rdCamera);
        btnMainBack = findViewById(R.id.btnMainBack);
        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        tv = getIntent().getStringExtra("name");
        textView.setText(tv);


        btnMainBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdCall.isChecked()){
                    Uri uri = Uri.parse("tel:0629496800");
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                }else if(rdCamera.isChecked()){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "골라야돼요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}