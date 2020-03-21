package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    String bmi;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        result= findViewById(R.id.result2);
        Intent intent = getIntent();
        bmi = intent.getStringExtra("bmiResult");
        result.setText(bmi);

    }
}
