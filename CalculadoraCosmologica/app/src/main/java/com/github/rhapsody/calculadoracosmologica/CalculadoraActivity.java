package com.github.rhapsody.calculadoracosmologica;

import android.graphics.PorterDuff;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    Calculadora calc;

    private double tH0 = 69.6;
    private double tz = 3;
    private double tWM = 0.286;
    private double tWV = 0.714;
    StringBuffer alerta = new StringBuffer();
    EditText iH0, iZ, iWM, iWV;
    TextView bigBangeAge, redshiftAge, lightTravelTime, comovingRadialMpc, comovingRadialGly, comovingVolume, angularDistanceMpc, angularDistanceGly, scaleFactor, lumDistanceMpc, lumDistanceGly, alertMSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        iH0 = (EditText) findViewById(R.id.inputH0);
        iZ = (EditText) findViewById(R.id.inputZ);
        iWM = (EditText) findViewById(R.id.inputOmegaM);
        iWV = (EditText) findViewById(R.id.inputOmegaV);

        resetarCampos();

        calc = new Calculadora();

        Button btOpen = (Button) findViewById(R.id.calcOpen);
        Button btFlat = (Button) findViewById(R.id.calcFlat);
        Button btGeneral = (Button) findViewById(R.id.calcGeneral);
        Button btReset = (Button) findViewById(R.id.restoreBtn);
        alertMSG = (TextView) findViewById(R.id.alertMSG);

        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaCampos()) {
                    calc.doOpen(Double.parseDouble(iH0.getText().toString()), Double.parseDouble(iWM.getText().toString()), Double.parseDouble(iZ.getText().toString()));
                    recarregaDados();
                } else {
                    alertMSG.setText(alerta.toString());
                }
            }
        });
        btFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaCampos()) {
                    calc.doFlat(Double.parseDouble(iH0.getText().toString()), Double.parseDouble(iWM.getText().toString()), Double.parseDouble(iZ.getText().toString()));
                    recarregaDados();
                } else {
                    alertMSG.setText(alerta.toString());
                }
            }
        });
        btGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaCampos()) {
                    calc.doGeneral(Double.parseDouble(iH0.getText().toString()), Double.parseDouble(iWM.getText().toString()), Double.parseDouble(iWV.getText().toString()), Double.parseDouble(iZ.getText().toString()));
                    recarregaDados();
                } else {
                    alertMSG.setText(alerta.toString());
                }
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
        lumDistanceMpc = (TextView) findViewById(R.id.lumDistanceMpc);
        //lumDistanceGly = (TextView) findViewById(R.id.lumDistanceGly);


    }

    protected void recarregaDados() {
        bigBangeAge.setText(calc.stround(calc.age_Gyr, 3));
        redshiftAge.setText(calc.stround(calc.zage_Gyr, 3));
        lightTravelTime.setText(calc.stround(calc.DTT_Gyr, 3));

        comovingRadialMpc.setText(calc.stround(calc.DCMR_Mpc, 1));
        //comovingRadialGly.setText(calc.stround(calc.DCMR_Gyr, 3) + " Gly");

        comovingVolume.setText(calc.stround(calc.V_Gpc, 3));

        angularDistanceMpc.setText(calc.stround(calc.DA_Gyr, 3));
        //angularDistanceGly.setText(calc.stround(calc.DTT_Gyr, 3) + " Gly");

        scaleFactor.setText(calc.stround(calc.kpc_DA, 3));

        lumDistanceMpc.setText(calc.stround(calc.DL_Mpc, 1));
        //lumDistanceGly.setText(calc.stround(calc.DTT_Gyr, 3) + " Gly");


    }

    protected void resetarCampos() {
        tirarFoco();
        iH0.setText(String.valueOf(tH0));
        iZ.setText(String.valueOf(tz));
        iWM.setText(String.valueOf(tWM));
        iWV.setText(String.valueOf(tWV));
    }
    protected void tirarFoco(){
        iH0.clearFocus();
        iZ.clearFocus();
        iWM.clearFocus();
        iWV.clearFocus();

    }

    protected boolean validaCampos() {
        tirarFoco();
        alerta.delete(0, alerta.length());

        boolean isOk = true;
        if (iH0.getText().toString().equals("")) {
            //alerta.append(" H0  ");
            iH0.getBackground().setColorFilter(getResources().getColor(R.color.colorAlert), PorterDuff.Mode.SRC_OVER);
            isOk = false;
        }
        if (iWM.getText().toString().equals("")) {
            //alerta.append(" Omega M ");
            iWM.getBackground().setColorFilter(getResources().getColor(R.color.colorAlert), PorterDuff.Mode.SRC_OVER);
            isOk = false;
        }
        if (iWV.getText().toString().equals("")) {
            //alerta.append(" Omega V  ");
            iWV.getBackground().setColorFilter(getResources().getColor(R.color.colorAlert), PorterDuff.Mode.SRC_OVER);
            isOk = false;
        }
        if (iZ.getText().toString().equals("")) {
            //alerta.append(" Z  ");
            iZ.getBackground().setColorFilter(getResources().getColor(R.color.colorAlert), PorterDuff.Mode.SRC_OVER);
            isOk = false;
        }

        if (!isOk) {
            alerta.insert(0, "Os campos marcados ");
            alerta.append("são obrigatório");
        }

        return isOk;
    }
}
