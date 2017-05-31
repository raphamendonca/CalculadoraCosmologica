package com.github.rhapsody.calculadoracosmologica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalculadoraActivity extends AppCompatActivity {

    private double tH0 = 69.6;
    private double tz = 3;
    private double tWM = 0.286;
    private double tWV = 0.714;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


    }

    //calc.doOpen(tH0, tWM, tz);
    //calc.doFlat(tH0, tWM, tz);
    //calc.doGeneral(tH0, tWM, tWV, tz);



}
