package com.example.p1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edNum1, edNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;
    int num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum1 = findViewById(R.id.etNum1);
        edNum2 = findViewById(R.id.etNum2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = findViewById(R.id.tvResult);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(edNum1.getText().toString());
                num2 = Integer.parseInt(edNum2.getText().toString());

                switch (v.getId()){
                    case (R.id.btnAdd):
                        result = num1+num2;
                        tvResult.setText("계산결과 "+result);
                        break;
                    case (R.id.btnSub):
                        result = num1-num2;
                        tvResult.setText("계산결과 "+result);
                        break;

                    case (R.id.btnMul):
                        result = num1*num2;
                        tvResult.setText("계산결과 "+result);
                        break;

                    case (R.id.btnDiv):
                        result = num1/num2;
                        tvResult.setText("계산결과 "+result);
                        break;

                }

            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
    }
}
