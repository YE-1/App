package com.example.ex08_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;

    ArrayList<String> dataList = getStringList(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        // 문자열 리스트를 출력할 어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataList);

        // 드롭다운되었을 때의 뷰를 지정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Spinner에 어댑터 연결
        spinner.setAdapter(adapter);

        // Spinner에서 아이템을 선택하면 발생하는 이벤트 설정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(dataList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    // ListView에 표시될 데이터 ArrayList생성 메소드
    private ArrayList<String> getStringList(int count) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for ( int i=1; i<=count; i++){
            arrayList.add("스피너 아이템 "+i);
        }
        return arrayList;
    }

}
