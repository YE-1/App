package com.example.ex05_diy10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1, editTextNum2;
    Button btnCalculate;
    RadioButton add, sub, mul, div;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        btnCalculate = findViewById(R.id.btnCalculate);

        radioGroup = findViewById(R.id.radioGroup);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                switch (radioGroup.getCheckedRadioButtonId()){
                    case (R.id.add):
                        intent.putExtra("Operator","+");
                        break;
                    case (R.id.sub):
                        intent.putExtra("Operator","-");
                        break;
                    case (R.id.mul):
                        intent.putExtra("Operator","*");
                        break;
                    case (R.id.div):
                            intent.putExtra("Operator","/");
                        break;
                }

                intent.putExtra("Num1",Integer.parseInt(editTextNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(editTextNum2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    // startActivityForResult()의 응답이 돌아오면 자동 실행되는 메소드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            int hap = data.getIntExtra("Result", 0);
            Toast.makeText(this, "결과 : "+ hap, Toast.LENGTH_SHORT).show();
        }
    }
}


