package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class screen2 extends AppCompatActivity {

    CalculateBMI cal = new CalculateBMI();
    EditText height, weight;
    TextView result;
    Button calculate;
    Switch switchButton;
    float w,h;
    boolean isMetric = true;
    float bmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        switchButton = findViewById(R.id.switch1);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen2.this, Results.class);
                intent.putExtra("bmiResult", Float.toString(getBMI()));
                startActivity(intent);
            }
        });
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchButton.isChecked()) {

                    switchButton.setText("Imperial");
                    isMetric = false;

                } else {

                    switchButton.setText("Metric");
                    isMetric = true;

                }
            }
        });


    }
    public void buttonClick(View v ){


        try {
            w = Float.parseFloat(weight.getText().toString());
            h = Float.parseFloat(height.getText().toString());


            if (isMetric) {
              //  metric formula

                if (w < 20 || w > 200 || h < 50 || h > 220) {
                    result.setText("Please enter correct weight and height");

                } else {
                   bmi = cal.calculateBMI(h,w,isMetric);
                    setBMI(bmi);
                    result.setText(Float.toString(getBMI()));
                }

            }
           else {
               if (w < 44 || w > 440 || h < 19 || h > 87) {
                    result.setText("Please enter correct weight and height");

                } else {
                   bmi = cal.calculateBMI(h,w,isMetric);
                   setBMI(bmi);
                   result.setText(Float.toString(getBMI()));
                }

           }


            if (bmi < 18.5) {
                result.setTextColor(Color.parseColor("#3498db"));
            }

            if (bmi > 18.5 && bmi < 24.9) {
                result.setTextColor(Color.parseColor("#27ae60"));
            }

            if (bmi > 25 && bmi < 29.9) {
                result.setTextColor(Color.parseColor("#f1c40f"));
            }

            if (bmi > 30 && bmi < 40) {
                result.setTextColor(Color.parseColor("#e67e22"));
            }

            if (bmi > 40) {
                result.setTextColor(Color.parseColor("#c0392b"));
            }



        }


        catch (Exception e){



            if(isEmptyField(weight)){
                result.setText("Please enter your weight");
            }
            if(isEmptyField(height)){
                result.setText("Please enter your height");
            }
            if(isEmptyField(weight)&& isEmptyField(height)){
                result.setText("Please enter your weight and height");
            }
            Log.d("error", e.toString());


        }


    }

    public void about (View v){
        Intent intent = new Intent(screen2.this, About.class);
        startActivity(intent);
    }


    public void setBMI(float bmi){this.bmi = bmi;}
    public float getBMI(){return bmi;}

    public  boolean isEmptyField(EditText etText) {
        return etText.getText().toString().trim().length() <= 0;
    }
}


