package com.example.test2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button btnAdd, btnMod, btnDel;
    int selNum, count = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("2208 문예원");

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnMod = findViewById(R.id.btnMod);
        btnDel = findViewById(R.id.btnDel);

        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터1");
        dataSet.add("리스트 데이터2");
        dataSet.add("리스트 데이터3");
        dataSet.add("리스트 데이터4");
        dataSet.add("리스트 데이터5");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                dataSet
        );

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSet.add("리스트 데이터" + count);
                adapter.notifyDataSetChanged();
                count += 1;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selNum = i;
                textView.setText(dataSet.get(i));
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText et = new EditText(getApplicationContext());
                new AlertDialog.Builder(MainActivity.this)
                .setTitle("리스트 데이터 수정")
                .setMessage(dataSet.get(selNum))
                .setIcon(R.mipmap.ic_launcher_round)
                .setView(et)
                .setNegativeButton("취소", null)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataSet.set(selNum, et.getText().toString());
                        textView.setText(dataSet.get(selNum));
                        adapter.notifyDataSetChanged();
                    }
                })
                .show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSet.remove(selNum);
                textView.setText(dataSet.get(selNum));
                adapter.notifyDataSetChanged();
            }
        });
    }

}