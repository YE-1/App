package com.example.a2208_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        editText = findViewById(R.id.editText);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("name", editText.getText().toString());
                startActivityForResult(intent, 0);
            }
        });

    /*    Intent outIntent;
        switch(radioGroup.getCheckedRadioButtonId()){
            case(R.id.rdCall):
                Uri uri = Uri.parse("tel:0629496800");
                outIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(outIntent);
                break;
            case(R.id.rdCamera):
                outIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivity(outIntent);
                break;
        }*/


    }
}
