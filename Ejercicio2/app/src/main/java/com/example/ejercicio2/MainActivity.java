package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edVotos;
    private Button Calcular;


    String votos;
    Double Vot;
    Integer Cant1 = 0, Cant2 = 0, Cant3 = 0, Cant4 = 0, n = 0, nulo = 0;
    Double C1, C2, C3, C4, c1, c2, c3, c4, total;
    String vot1, cant1, cant2, cant3, cant4;
    String Gana, To1, nul, Ca1, Ca2, Ca3, Ca4;

    DecimalFormat df = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edVotos = (EditText)findViewById(R.id.Edvotos);
        Calcular = (Button)findViewById(R.id.btnContar);


        Calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                    try {
                        votos = edVotos.getText().toString();


                        String [] Cantvotos = votos.split("-");

                        for (String cantvoto : Cantvotos) {
                            vot1 = cantvoto;

                            Vot = Double.valueOf(vot1);

                            if (Vot == 1) {
                                Cant1++;
                            } else if (Vot == 2) {
                                Cant2++;
                            } else if (Vot == 3) {
                                Cant3++;
                            } else if (Vot == 4) {
                                Cant4++;
                            }else {
                                nulo++;
                            }
                        }

                        for (int i = 0; i < Cantvotos.length; i++){

                            n = n + 1;

                        }

                        // Calculando el porcentaje de votos obtenidos

                        C1 = Double.valueOf(Cant1);
                        C2 = Double.valueOf(Cant2);
                        C3 = Double.valueOf(Cant3);
                        C4 = Double.valueOf(Cant4);
                        total = Double.valueOf(n);

                        c1 = ((C1)/(total))*(100);
                        c2 = ((C2)/(total))*(100);
                        c3 = ((C3)/(total))*(100);
                        c4 = ((C4)/(total))*(100);

                        //Comparando las cantidades para ver quién es el ganador
                        if ((c1 > c2) && (c1 > c3) && (c1 > c4)){

                            Gana = "El Candidato #1 con el " + df.format(c1) + "% de los votos.";

                        }else if ((c2 > c1) && (c2 > c3) && (c2 > c4)){

                            Gana = "El Candidato #2 con el " + df.format(c2) + "% de los votos.";

                        }else if ((c3 > c1) && (c3 > c2) && (c1 > c4)){

                            Gana = "El Candidato #3 con el " + df.format(c3) + "% de los votos.";

                        }else if ((c4 > c2) && (c4 > c3) && (c4 > c1)){

                            Gana = "El Candidato #4 con el " + df.format(c4) + "% de los votos.";
                        }else {
                            Gana = "Hay empate entre candidatos con mayor voto.";
                        }

                        //Transformando las variables a String

                        cant1 = Cant1.toString();
                        cant2 = Cant2.toString();
                        cant3 = Cant3.toString();
                        cant4 = Cant4.toString();
                        nul = nulo.toString();
                        Ca1 = df.format(c1);
                        Ca2 = df.format(c2);
                        Ca3 = df.format(c3);
                        Ca4 = df.format(c4);


                        // Pasando las variables a la otra Activity

                        Intent intent = new Intent(MainActivity.this,ShowActivity.class);

                        intent.putExtra("Cantidad1",cant1);
                        intent.putExtra("Cantidad2",cant2);
                        intent.putExtra("Cantidad3",cant3);
                        intent.putExtra("Cantidad4",cant4);
                        intent.putExtra("Ganador",Gana);
                        intent.putExtra("Nulo",nul);
                        intent.putExtra("Porcentaje1", Ca1);
                        intent.putExtra("Porcentaje2", Ca2);
                        intent.putExtra("Porcentaje3", Ca3);
                        intent.putExtra("Porcentaje4", Ca4);


                        startActivity(intent);
                    }catch (IllegalArgumentException e) {
                        Toast.makeText(MainActivity.this, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}