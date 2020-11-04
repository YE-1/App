package com.example.drone;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.ListView;

public class drone_place extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drone_place);

        listView = findViewById(R.id.listView);

        dataSetting();
    }

    private void dataSetting() {
        MyAdapter myAdpter = new MyAdapter();

        for( int i=0; i<10; i++){
            myAdpter.addItem("listView: "+i);
        }

        listView.setAdapter(myAdpter);
    }
}