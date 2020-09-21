package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.customlistview.Fragment1;
import com.example.customlistview.Fragment2;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentTransaction transaction;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("OP.GG");

        frameLayout = findViewById(R.id.fragment_a);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_a, fragment1).commit();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.line);
                button2.setBackgroundResource(R.drawable.haejae);
                button3.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment1).commit();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundResource(R.drawable.line);
                button1.setBackgroundResource(R.drawable.haejae);
                button3.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment2).commit();


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setBackgroundResource(R.drawable.line);
                button2.setBackgroundResource(R.drawable.haejae);
                button1.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment3).commit();
            }
        });
    }
}