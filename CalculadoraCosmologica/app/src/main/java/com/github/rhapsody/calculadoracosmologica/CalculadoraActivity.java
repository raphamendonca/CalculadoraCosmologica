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

    EditText iH0, iZ, iWM, itWV;
    TextView bigBangeAge, redshiftAge, lightTravelTime, comovingRadialMpc, comovingRadialGly, comovingVolume, angularDistanceMpc, angularDistanceGly, scaleFactor, lumDistanceMpc, lumDistanceGly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        iH0 = (EditText) findViewById(R.id.inputH0);
        iZ = (EditText) findViewById(R.id.inputZ);
        iWM = (EditText) findViewById(R.id.inputOmegaM);
        itWV = (EditText) findViewById(R.id.inputOmegaV);

        resetarCampos();

        calc = new Calculadora();

        Button btOpen = (Button) findViewById(R.id.calcOpen);
        Button btFlat = (Button) findViewById(R.id.calcFlat);
        Button btGeneral = (Button) findViewById(R.id.calcGeneral);
        Button btReset = (Button) findViewById(R.id.restoreBtn);

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
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetarCampos();
            }
        });


        bigBangeAge = (TextView) findViewById(R.id.bigBangAge);
        redshiftAge = (TextView) findViewById(R.id.redshiftAge);
        lightTravelTime = (TextView) findViewById(R.id.lightTravelTime);
        comovingRadialMpc = (TextView) findViewById(R.id.comovingRadialMpc);
        //comovingRadialGly = (TextView) findViewById(R.id.comovingRadialGly);
        comovingVolume = (TextView) findViewById(R.id.comovingVolume);
        angularDistanceMpc = (TextView) findViewById(R.id.angularDistanceMpc);
        //angularDistanceGly = (TextView) findViewById(R.id.angularDistanceGly);
        scaleFactor = (TextView) findViewById(R.id.scaleFactor);
        lumDistanceMpc= (TextView) findViewById(R.id.lumDistanceMpc);
        //lumDistanceGly = (TextView) findViewById(R.id.lumDistanceGly);


    }

    protected void recarregaDados() {
        bigBangeAge.setText(calc.stround(calc.age_Gyr, 3) + " Gyr");
        redshiftAge.setText(calc.stround(calc.zage_Gyr, 3) + calc.tunit);
        lightTravelTime.setText(calc.stround(calc.DTT_Gyr, 3) + " Gyr");

        comovingRadialMpc.setText(calc.stround(calc.DCMR_Mpc, 1) + " Mpc");
        //comovingRadialGly.setText(calc.stround(calc.DCMR_Gyr, 3) + " Gly");

        comovingVolume.setText(calc.stround(calc.V_Gpc, 3) + " Gpc³");

        angularDistanceMpc.setText(calc.stround(calc.DA_Gyr, 3) + " Mpc");
        //angularDistanceGly.setText(calc.stround(calc.DTT_Gyr, 3) + " Gly");

        scaleFactor.setText(calc.stround(calc.kpc_DA, 3) + " kpc");

        lumDistanceMpc.setText(calc.stround(calc.DL_Mpc, 1) + " Mpc");
        //lumDistanceGly.setText(calc.stround(calc.DTT_Gyr, 3) + " Gly");

    }

    protected void resetarCampos() {
        iH0.setText(String.valueOf(tH0));
        iZ.setText(String.valueOf(tz));
        iWM.setText(String.valueOf(tWM));
        itWV.setText(String.valueOf(tWV));
    }

}
