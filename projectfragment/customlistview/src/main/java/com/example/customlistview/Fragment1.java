package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Fragment1 extends Fragment {

    TextView nickName;
    ImageView beforeCart, beforeMap, beforeCharac;

    int trackView, characterView, kartView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment1, container, false);

        nickName = v.findViewById(R.id.nickName);
        beforeCart = v.findViewById(R.id.beforeCart);
        beforeMap = v.findViewById(R.id.beforeMap);
        beforeCharac = v.findViewById(R.id.beforeCharac);

        Bundle bundle = getArguments();

        String text = bundle.getString("text");
        nickName.setText(text);

        trackView =getArguments().getInt("trackview");
        characterView =getArguments().getInt("characterView");
        kartView =getArguments().getInt("kartview");

        beforeMap.setImageResource(trackView);
        beforeCharac.setImageResource(characterView);
        beforeCart.setImageResource(kartView);


        return v;
    }

}


