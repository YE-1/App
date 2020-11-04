package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    TextView nickName;
    ImageView beforeCart, beforeMap, beforeCharac;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment1, container, false);

        nickName= v.findViewById(R.id.nickName);
        beforeCart = v.findViewById(R.id.beforeCart);
        beforeMap = v.findViewById(R.id.beforeMap);
        beforeCharac = v.findViewById(R.id.beforeCharac);


        return v;
    }
}