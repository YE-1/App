package com.example.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<ItemVO> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<ItemVO> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    // 리스트뷰의 아이템 개수 반환
    @Override
    public int getCount() {
        return dataList.size();
    }

    // 리스트뷰의 아이템 반환
    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 화면에 보여지는 리스트뷰의 아이템 표시를 위한 뷰 생성 및 반환
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // 재사용 가능한 뷰가 없으면 새로 생성
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
             view = inflater.inflate(resource, null);   // R.layout.row xml을 view 객체로 생성
        }

        // view의 구성요소인 View들을 참조변수에 연결
        ImageView imageViewIcon = view.findViewById(R.id.imageViewIcon);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView  textViewContent = view.findViewById(R.id.textViewContent);


        textViewTitle.setText(dataList.get(position).getTitleStr());
        textViewContent.setText(dataList.get(position).getContentStr());

        return view;
    }
}
