package com.example.ejercicio3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Activity2 extends Activity {
    private Bundle bundle;
    private TextView tvFN1, tvFN2, tvFN3, tvI1, tvI2, tvI3, tvA1,
            tvA2, tvA3, tvR1, tvR2, tvR3, tvSL1, tvSL2, tvSL3, tvB1, tvB2, tvB3, tvMS, tvMN, tvCant;


    String Full1, Full2, Full3, IS1, IS2, IS3, AF1, AF2, AF3, RE1, RE2, RE3, SAL1, SAL2, SAL3, BO1, BO2, BO3, Mayor, Menor, Cant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        /* Asignando los TextViews a las variables creadas */

        tvFN1 = (TextView)findViewById(R.id.tvFullName1);
        tvFN2 = (TextView)findViewById(R.id.tvFullName2);
        tvFN3 = (TextView)findViewById(R.id.tvFullName3);

        tvI1 = (TextView)findViewById(R.id.tvISSS1);
        tvI2 = (TextView)findViewById(R.id.tvISSS2);
        tvI3 = (TextView)findViewById(R.id.tvISSS3);

        tvA1 = (TextView)findViewById(R.id.tvAFP1);
        tvA2 = (TextView)findViewById(R.id.tvAFP2);
        tvA3 = (TextView)findViewById(R.id.tvAFP3);

        tvR1 = (TextView)findViewById(R.id.tvRENTA1);
        tvR2 = (TextView)findViewById(R.id.tvRENTA2);
        tvR3 = (TextView)findViewById(R.id.tvRENTA3);

        tvSL1 = (TextView)findViewById(R.id.tvSL1);
        tvSL2 = (TextView)findViewById(R.id.tvSL2);
        tvSL3 = (TextView)findViewById(R.id.tvSL3);

        tvB1 = (TextView)findViewById(R.id.tvBONO1);
        tvB2 = (TextView)findViewById(R.id.tvBONO2);
        tvB3 = (TextView)findViewById(R.id.tvBONO3);

        tvMS = (TextView)findViewById(R.id.tvMayorS);
        tvMN = (TextView)findViewById(R.id.tvMenorS);

        tvCant = (TextView)findViewById(R.id.tvSueldosMayores);

        /* Fin de asignación */

        bundle = getIntent().getExtras();

        /* Asignando los valores que vienen de la Activity de Captura en las Variables String*/

        Full1 = bundle.getString("FullName1");
        Full2 = bundle.getString("FullName2");
        Full3 = bundle.getString("FullName3");

        IS1 = bundle.getString("IS1");
        IS2 = bundle.getString("IS2");
        IS3 = bundle.getString("IS3");

        AF1 = bundle.getString("AFP1");
        AF2 = bundle.getString("AFP2");
        AF3 = bundle.getString("AFP3");

        RE1 = bundle.getString("REN1");
        RE2 = bundle.getString("REN2");
        RE3 = bundle.getString("REN3");

        SAL1 = bundle.getString("SL1");
        SAL2 = bundle.getString("SL2");
        SAL3 = bundle.getString("SL3");

        BO1 = bundle.getString("BO1");
        BO2 = bundle.getString("BO2");
        BO3 = bundle.getString("BO3");

        Cant = bundle.getString("Cant");

        Mayor = bundle.getString("Ma");
        Menor = bundle.getString("Men");

        /* Fin de Asignación*/


        /* Mostrando en pantalla los datos obtenidos */

        tvFN1.append("               "+Full1);
        tvFN2.append("               "+Full2);
        tvFN3.append("               "+Full3);

        tvI1.append("                              $"+IS1);
        tvI2.append("                              $"+IS2);
        tvI3.append("                              $"+IS3);

        tvA1.append("                              $"+AF1);
        tvA2.append("                              $"+AF2);
        tvA3.append("                              $"+AF3);

        tvR1.append("                              $"+RE1);
        tvR2.append("                              $"+RE2);
        tvR3.append("                              $"+RE3);

        tvSL1.append("                              $"+SAL1);
        tvSL2.append("                              $"+SAL2);
        tvSL3.append("                              $"+SAL3);

        tvB1.append("                              $"+BO1);
        tvB2.append("                              $"+BO2);
        tvB3.append("                              $"+BO3);

        tvMS.append("          "+Mayor);
        tvMN.append("          "+Menor);

        tvCant.append("               " + Cant + " sueldos mayores a $300");


        /*Finaliza el muestreo de datos */
    }
}
