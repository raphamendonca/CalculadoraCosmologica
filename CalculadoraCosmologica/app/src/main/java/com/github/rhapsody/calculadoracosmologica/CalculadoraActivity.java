package com.github.rhapsody.calculadoracosmologica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    Calculadora calc;

    private double tH0 = 69.6;
    private double tz = 3;
    private double tWM = 0.286;
    private double tWV = 0.714;

    EditText iH0,iZ, iWM, itWV;
    TextView bigBangeAge, redshiftAge, lightTravelTime, comovingRadial, comovingVolume, bigBangeAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        iH0 = (EditText) findViewById(R.id.inputH0);
        iH0.setText(String.valueOf(tH0));

        iZ = (EditText) findViewById(R.id.inputZ);
        iZ.setText(String.valueOf(tz));

        iWM = (EditText) findViewById(R.id.inputOmegaM);
        iWM.setText(String.valueOf(tWM));

        itWV = (EditText) findViewById(R.id.inputOmegaV);
        itWV.setText(String.valueOf(tWV));

        calc = new Calculadora();

        Button btOpen =  (Button) findViewById(R.id.calcOpen);
        Button btFlat =  (Button) findViewById(R.id.calcFlat);
        Button btGeneral =  (Button) findViewById(R.id.calcGeneral);

        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doOpen(Double.parseDouble(iH0.getText().toString()), Double.parseDouble(iWM.getText().toString()), Double.parseDouble(iZ.getText().toString()));
                recarregaDados();
            }
        });
        btFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doFlat(Double.parseDouble(iH0.getText().toString()), Double.parseDouble(iWM.getText().toString()), Double.parseDouble(iZ.getText().toString()));
                recarregaDados();
            }
        });
        btGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doGeneral(Double.parseDouble(iH0.getText().toString()), Double.parseDouble(iWM.getText().toString()), Double.parseDouble(itWV.getText().toString()), Double.parseDouble(iZ.getText().toString()));
                recarregaDados();
            }
        });

        bigBangeAge = (TextView) findViewById(R.id.bigBangAge);
        redshiftAge = (TextView) findViewById(R.id.redshiftAge);
        lightTravelTime = (TextView) findViewById(R.id.lightTravelTime);
        //final TextView comovingRadial = (TextView) findViewById(R.id.bigBangAge);
        //final TextView comovingVolume = (TextView) findViewById(R.id.bigBangAge);
        //final TextView bigBangeAnge = (TextView) findViewById(R.id.bigBangAge);

    }

    private void recarregaDados(){
        bigBangeAge.setText(calc.stround(calc.age_Gyr, 3));
        redshiftAge.setText(calc.stround(calc.zage_Gyr, 3) + calc.tunit );
        lightTravelTime.setText(calc.stround(calc.DTT_Gyr, 3));
    }


}
