package com.example.bmi;


import android.util.Log;


public class CalculateBMI {


    public float calculateBMI (float heightValue,  float weightValue, boolean isMetric){

        float bmi = 0.0f;

        try {

            if (isMetric) {
                // Metric Formula
                    bmi = (float) (weightValue / Math.pow(heightValue / 100, 2));

            }

             else {
                    //Imperial Formula
                    bmi = (float) ((703 * weightValue) / Math.pow(heightValue, 2));
            }

        }

        catch(Exception e){
            Log.e("erorr", e.toString());
        }

        return bmi;
    }


}

