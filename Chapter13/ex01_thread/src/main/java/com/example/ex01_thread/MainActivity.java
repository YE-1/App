package com.example.ex01_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1, pb2;
    Button btnThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.progressBar1);
        pb2 = findViewById(R.id.progressBar2);
        btnThread = findViewById(R.id.btnThread);

        // region 1. 반복문을 이용하여 ProgressBar 상태 변화
        /*btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<=100; i++){
                    pb1.setProgress(pb1.getProgress()+2);
                    pb1.setProgress(pb2.getProgress()+1);
                    SystemClock.sleep(100);
                }
            }
        });*/
        // endregion

        // region 2. Thread를 상속받은 클래스를 이용한 ProgressBar 상태 변화
       /* btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressThread pt1 = new ProgressThread(pb1, 2);
                pt1.start();

                ProgressThread pt2 = new ProgressThread(pb2, 1);
                pt2.start();
            }
        });*/
        // endregion

        // region 3. 익명 Thread 객체를 이용한 ProgressBar
        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        for(int i=0; i<=100; i++){
                            pb1.setProgress(pb1.getProgress()+2);
                            pb2.setProgress(pb2.getProgress()+1);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
        // endregion

        // region 4. 익명의 Runnable 객체를 이용한 ProgressBar 상태 변화
        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        for(int i=0; i<=100; i++){
                            pb1.setProgress(pb1.getProgress()+2);
                            pb2.setProgress(pb2.getProgress()+1);
                            SystemClock.sleep(100);
                        }
                    }
                }).start();
            }
        });
        // endregion

        // region 5. 무한 루프 Thread 테스트
        while(true){
            SystemClock.sleep(100);
            Log.d("SubThread", String.value())
        }
        // endregion
    }

    private class ProgressThread extends Thread{

        ProgressBar pb;
        int increaseValue;

        public ProgressThread(ProgressBar pb, int increaseValue){
            this.pb = pb;
            this.increaseValue = increaseValue;
        }

        public void run(){
            // 반복문을 이용하여 ProgressBar의 상태를 일정하게 변화
            for(int i=0; pb.getProgress()<=100; i+=increaseValue){
                pb.setProgress(pb.getProgress()+increaseValue);
                SystemClock.sleep(100);
            }
        }
    }
}
