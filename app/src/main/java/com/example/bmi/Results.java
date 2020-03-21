package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    String bmi;
    TextView result;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);
        result= findViewById(R.id.result2);
        description= findViewById(R.id.disc);
        Intent intent = getIntent();
        bmi = intent.getStringExtra("bmiResult");
        result.setText(bmi);
        msg(bmi);

    }


    public void msg(String resultBMI) {

        float BMI = Float.parseFloat(bmi);

        if (BMI > 40) {
            description.setText("Extremely Obese");
            description.setTextColor(Color.parseColor("#c0392b"));
        }

        if (BMI > 30 && BMI < 40) {
            description.setText("Obese");
            description.setTextColor(Color.parseColor("#e67e22"));
        }

        if(BMI > 25 && BMI < 29.9){
            description.setText("Overweight");
            description.setTextColor(Color.parseColor("#f1c40f"));
        }

        if(BMI > 18.5 && BMI < 24.9){
            description.setText("Normal weight");
            description.setTextColor(Color.parseColor("#27ae60"));
        }

        if(BMI < 18.5 ){
            description.setText("Underweight");
            description.setTextColor(Color.parseColor("#3498db"));
        }
    }

    public void goBack(View v){
        Intent intent = new Intent(Results.this,screen2.class);
        startActivity(intent);

    }
}
