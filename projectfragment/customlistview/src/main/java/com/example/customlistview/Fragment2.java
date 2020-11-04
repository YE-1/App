package com.example.customlistview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    ListView lv;
    MyAdapter myAdapter = new MyAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.activity_fragment2, container, false);

        lv = v.findViewById(R.id.listView);

        for(int i=0;i<20;i++) {
            myAdapter.addItem("노스테유담", "2020.09.04");
        }
        lv.setAdapter(myAdapter);


        return v;
    }
}