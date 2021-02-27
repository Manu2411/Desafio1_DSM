package com.example.ejercicio2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class ShowActivity extends Activity{

    private Bundle bundle;
    private TextView tvCant1, tvCant2, tvCant3, tvCant4, tvGana, tvNull, tvPor1, tvPor2, tvPor3, tvPor4;
    private ImageView Image;

    String canti1, canti2, canti3, canti4;

    String Gana, nulo, Porce1, Porce2, Porce3, Porce4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        try {

            //Colocando las imagenes en los ImageView
            Image = (ImageView)findViewById(R.id.ivImg1); Image.setImageResource(R.drawable.img1);
            Image = (ImageView)findViewById(R.id.ivImg2); Image.setImageResource(R.drawable.img2);
            Image = (ImageView)findViewById(R.id.ivImg3); Image.setImageResource(R.drawable.img3);
            Image = (ImageView)findViewById(R.id.ivImg4); Image.setImageResource(R.drawable.img4);

            // Asignando los valores a las TextView
            tvCant1 = (TextView)findViewById(R.id.txtCant1);
            tvCant2 = (TextView)findViewById(R.id.txtCant2);
            tvCant3 = (TextView)findViewById(R.id.txtCant3);
            tvCant4 = (TextView)findViewById(R.id.txtCant4);
            tvGana = (TextView)findViewById(R.id.txtGanador);
            tvNull =(TextView)findViewById(R.id.tvNulo);
            tvPor1 = (TextView)findViewById(R.id.tvPorc1);
            tvPor2 = (TextView)findViewById(R.id.tvPorc2);
            tvPor3 = (TextView)findViewById(R.id.tvPorc3);
            tvPor4 = (TextView)findViewById(R.id.tvPorc4);

            //Capturando los datos recibidos del MainActivity
            bundle = getIntent().getExtras();

            // Asignando los valores recibidos a las variables correspondientes
            canti1 = bundle.getString("Cantidad1");
            canti2 = bundle.getString("Cantidad2");
            canti3 = bundle.getString("Cantidad3");
            canti4 = bundle.getString("Cantidad4");
            Gana = bundle.getString("Ganador");
            nulo = bundle.getString("Nulo");
            Porce1 = bundle.getString("Porcentaje1");
            Porce2 = bundle.getString("Porcentaje2");
            Porce3 = bundle.getString("Porcentaje3");
            Porce4 = bundle.getString("Porcentaje4");



            // Mostrando los valores de los valores
            tvCant1.append(canti1);
            tvCant2.append(canti2);
            tvCant3.append(canti3);
            tvCant4.append(canti4);
            tvPor1.append(Porce1 + "%");
            tvPor2.append(Porce2 + "%");
            tvPor3.append(Porce3 + "%");
            tvPor4.append(Porce4 + "%");
            tvGana.append(Gana);
            tvNull.append("Hubieron " + nulo + " votos nulos");

        }catch (IllegalArgumentException e){
            Toast.makeText(ShowActivity.this,"Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}
