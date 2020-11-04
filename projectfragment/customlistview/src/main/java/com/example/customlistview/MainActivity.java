package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.customlistview.Fragment1;
import com.example.customlistview.Fragment2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentTransaction transaction;
    FrameLayout frameLayout;

    EditText editText;
    Button button_search;

    String text;

    ImageView kartView, characterview, trackView;

    Fragment1 fragment = new Fragment1();
    Bundle bundle = new Bundle(3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("OP.GG");

        editText = findViewById(R.id.nickNameBadgi);
        button_search = findViewById(R.id.searchBtn);

        frameLayout = findViewById(R.id.fragment_a);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editText.getText().toString();

                transaction = getSupportFragmentManager().beginTransaction();

                Fragment1 fragment1 = new Fragment1();

                Bundle bundle = new Bundle();
                bundle.putString("text",text);
                fragment1.setArguments(bundle);
                transaction.replace(R.id.fragment_a, fragment1).commit();
            }
        });




        //region
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.line);
                button2.setBackgroundResource(R.drawable.haejae);
                button3.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment1).commit();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundResource(R.drawable.line);
                button1.setBackgroundResource(R.drawable.haejae);
                button3.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment2).commit();


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setBackgroundResource(R.drawable.line);
                button2.setBackgroundResource(R.drawable.haejae);
                button1.setBackgroundResource(R.drawable.haejae);
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_a, fragment3).commit();
            }
        });
        //endregion
    }
    private class Connecting extends Thread
    {
        URL kartrequesturl = null;
        JsonReader jsonReader;
        HttpsURLConnection myConnection;
        String key = "Authorization";
        String value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTY0NDQyMzc3NiIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTM5MyIsIlgtQXBwLVJhdGUtTGltaXQiOiIyMDAwMDoxMCIsIm5iZiI6MTU3NDY3MTM3NSwiZXhwIjoxNjM3NzQzMzc1LCJpYXQiOjE1NzQ2NzEzNzV9.MrI87qOGv3ejTAKrPC5yZxZi6VO3zYnZvaUAdDKchIE";
        InputStreamReader responsebodyreader = null;
        InputStream responsebody = null;
        String name;
        String username;
        String accessid;
        String Urlstring;
        String showvalue;

        int number;

        void getusernumber() throws Exception{
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });
            String nickname = text;
            Urlstring = "https://api.nexon.co.kr/kart/v1.0/users/nickname/" + nickname;
            connect();

        }

        void getuserresult () throws Exception {
            Urlstring = "https://api.nexon.co.kr/kart/v1.0/users/" + accessid + "/matches?start_date=&end_date= &offset=0&limit=1&match_types=";
            connect();
        }

        <T> void runuiname ( final T value){
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //resultview.setText(resultview.getText() + "\n" + value + "\n");
                    String information = value.toString();
                }
            });
        }


        void connect () throws Exception {
            kartrequesturl = new URL(Urlstring);
            try {
                myConnection = (HttpsURLConnection) kartrequesturl.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            myConnection.setRequestProperty(key, value);
        }

        void startjsonread () throws Exception {
            responsebody = myConnection.getInputStream();
            responsebodyreader = new InputStreamReader(responsebody);
            jsonReader = new JsonReader(responsebodyreader);
        }


        @Override
        public void run()
        {
            try {
                getusernumber();
            } catch (Exception e) {
                e.printStackTrace();
            }


            try {

                if (myConnection.getResponseCode() == 200)
                {
                    startjsonread();

                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        name = jsonReader.nextName();
                        if (name.equals("name")) {
                            username = jsonReader.nextString();
                        } else if (name.equals("accessId")) {
                            accessid = jsonReader.nextString();
                        }
                        final String Username = username;
                        final String finalAccesssid = accessid;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //userview.setText(Username + "\n" + finalAccesssid);
                                String userView = Username + "\n" + finalAccesssid;
                            }
                        });
                    }

                    jsonReader.endObject();
                }

                //region 유저의 정보를 불러오는 곳
                getuserresult();
                if (myConnection.getResponseCode() == 200) {
                    startjsonread();
                    String license;
                    while (jsonReader.hasNext()) {
                        if (jsonReader.peek().toString().equals("BEGIN_ARRAY")) {
                            jsonReader.beginArray();
                        } else if (jsonReader.peek().toString().equals("BEGIN_OBJECT")) {
                            jsonReader.beginObject();
                        } else if (jsonReader.peek().toString().equals("STRING")) {
                            jsonReader.nextString();
                        } else if (jsonReader.peek().toString().equals("END_ARRAY")) {
                            jsonReader.endArray();
                        } else if (jsonReader.peek().toString().equals("END_OBJECT")) {
                            jsonReader.endObject();
                        } else if (jsonReader.peek().toString().equals("NAME")) {
                            name = jsonReader.nextName();
                            final String trackId;

                            Resources resources = getResources();
                            int resourceid;

                            if (name.equals("matchRank")) {

                                name = "순위";
                                String rank = jsonReader.nextString();
                                if (rank.equals("99")) {
                                    rank = "리타이어";
                                }

                                runuiname("순위 : " + rank);

                            } else if (name.equals("rankinggrade2")) {
                                name = "라이센스";

                                switch (jsonReader.nextString()) {
                                    case "1":
                                        license = "초보";
                                        break;
                                    case "2":
                                        license = "루키";
                                        break;
                                    case "3":
                                        license = "L3";
                                        break;
                                    case "4":
                                        license = "L2";
                                        break;
                                    case "5":
                                        license = "L1";
                                        break;
                                    case "6":
                                        license = "프로";
                                        break;
                                    default:
                                        license = "알 수 없음";


                                }
                                runuiname(name + " : " + license);


                            } else if (name.equals("channelName")) {
                                runuiname("채널 이름 : " + jsonReader.nextString());
                            } else if (name.equals("playerCount")) {
                                runuiname("플레이어 수 : " + jsonReader.nextString());
                            } else if (name.equals("nickName")) {
                                runuiname("닉네임 : " + jsonReader.nextString());
                            } else if (name.equals("trackId")) {
                                trackId = jsonReader.nextString();
                                resourceid = resources.getIdentifier("_" + trackId, "drawable", getPackageName());
                                trackView.setImageResource(resourceid);

                                bundle.putInt("trackView", resourceid);
                                fragment.setArguments(bundle);


                            } else if (name.equals("character")) {
                                trackId = jsonReader.nextString();
                                resourceid = resources.getIdentifier("_" + trackId, "drawable", getPackageName());
                                characterview.setImageResource(resourceid);

                                bundle.putInt("characterView", resourceid);
                                fragment.setArguments(bundle);

                            } else if (name.equals("matchWin")) {
                                String result;
                                if (jsonReader.nextString().equals("0"))
                                    result = "패배";
                                else
                                    result = "승리";

                                runuiname("결과 : " + result);
                            } else if (name.equals("kart")) {


                                trackId = jsonReader.nextString();
                                if (trackId.equals("")) {
                                    runuiname("연습카트 X를 탔을 확률이 높음...");
                                    kartView.setImageResource(R.drawable.ic_launcher_background);

                                    bundle.putInt("kartView", R.drawable.ic_launcher_background);
                                    fragment.setArguments(bundle);
                                } else {
                                    resourceid = resources.getIdentifier("_" + trackId, "drawable", getPackageName());
                                    kartView.setImageResource(resourceid);

                                    bundle.putInt("kartView", resourceid);
                                    fragment.setArguments(bundle);
                                }


                            }


                        } else if (jsonReader.peek().toString().equals("NUMBER")) {
                            number = jsonReader.nextInt();
                            runuiname(number);
                        }
                    }
                } else {

                }
                //endregion

                Thread.sleep(1000);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

    }

}

class item_info {
    Bitmap map_image;
    String map_name;
    String date;
    int person;
    int rank;
    String mode;
}