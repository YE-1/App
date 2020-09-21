package com.example.fragmentex;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment2 extends Fragment{

    public Fragment2(){

    }
    ArrayList<ItemVO> dataList = new ArrayList<ItemVO>();
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.row, dataList);


        // 리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment2, container, false);
    }

    /*ListView listView;

    ArrayList<String> titleData = getStringList("Title", 50);
    ArrayList<String> contentsData = getStringList("Contents", 50);

    public Fragment2(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container, false);
        ArrayList<HashMap<String, String>> listViewData = new ArrayList<HashMap<String, String>>();
        for(int i=0; i<titleData.size(); i++){
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("title", titleData.get(i));
            hashMap.put("contents", contentsData.get(i));

            listViewData.add(hashMap);
        }

        String[] keys = {"title", "contents"};


        int[] ids = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listViewData, android.R.layout.simple_list_item_2, keys, ids);

        listView.setAdapter(adapter);

        return view;
    }

    private ArrayList<String> getStringList(String s, int a) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for ( int i=1; i<=20; i++){
            arrayList.add("최근게임 "+i);
        }
        return arrayList;
    }
*/



}
