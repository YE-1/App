package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btnUser, btnScore;
    ListView listView;

    ArrayList<String> titleData = getStringList("Title", 50);
    ArrayList<String> contentsData = getStringList("Contents", 50);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUser = findViewById(R.id.btnUser);
        btnScore = findViewById(R.id.btnScore);
        listView = findViewById(R.id.listView);



        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnScore.setBackgroundResource(R.drawable.line);
                btnUser.setBackgroundColor(Color.parseColor("#ffffff"));

                listView.setVisibility(View.VISIBLE);

                ArrayList<HashMap<String, String>> listViewData = new ArrayList<HashMap<String, String>>();
                for(int i=0; i<titleData.size(); i++){
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("title", titleData.get(i));
                    hashMap.put("contents", contentsData.get(i));

                    listViewData.add(hashMap);
                }

                // 한 항목에 해당하는 키값 배열
                String[] keys = {"title", "contents"};

                // 한 항목에 해당하는 TextView의 id값 배열
                int[] ids = {android.R.id.text1, android.R.id.text2};

                // SimpleAdapter에 ListView를 구성할 View와 데이터를 합침.
                // SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)
                SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), listViewData, android.R.layout.simple_list_item_2, keys, ids);

                // ListView에 ArrayAdapter 연결
                listView.setAdapter(adapter);


        }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUser.setBackgroundResource(R.drawable.line);
                btnScore.setBackgroundColor(Color.parseColor("#ffffff"));
                listView.setVisibility(View.GONE);
            }
        });
    }

    private ArrayList<String> getStringList(String s, int a) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for ( int i=1; i<=20; i++){
            arrayList.add("최근게임 "+i);
        }
        return arrayList;
    }
}