package sv.edu.udb.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText etA, etB, etC;
    private Button Calcular;
    private ImageView Image;

    Double resultado, A, B, C, discriminante, numeradorPos, numeradorNega, denominador, x1, x2;

    DecimalFormat df = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignando valores a los TextEdit
        etA = (EditText)findViewById(R.id.etA);
        etB = (EditText)findViewById(R.id.etB);
        etC = (EditText)findViewById(R.id.etC);

        //Agregando Imagen al ImageView
        Image =(ImageView)findViewById(R.id.imageView4); Image.setImageResource(R.drawable.cuadratica);

        Calcular=(Button)findViewById(R.id.btnCalcular);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                try {
                    A= Double.parseDouble(etA.getText().toString());
                    B= Double.parseDouble(etB.getText().toString());
                    C= Double.parseDouble(etC.getText().toString());

                    discriminante = ((B*B)-(4*A*C));

                    if(discriminante<0){
                        Toast.makeText(getApplicationContext(),"No es posible realizar la operación, el discriminante es menor a 0",
                                Toast.LENGTH_LONG).show();
                    } else {
                        numeradorPos = -B + Math.sqrt(discriminante);
                        numeradorNega = -B - Math.sqrt(discriminante);
                        denominador = 2*A;
                        x1 = numeradorPos/denominador;
                        x2 = numeradorNega/denominador;

                        //Redondeando cifras
                        A = Math.round(A*100.0)/100.0;
                        B = Math.round(B*100.0)/100.0;
                        C = Math.round(C*100.0)/100.0;
                        discriminante = Math.round(discriminante*100.0)/100.0;
                        x1= Math.round(x1*100.0)/100.0;
                        x2= Math.round(x2*100.0)/100.0;

                        // Pasando las variables a la otra Activity
                        Intent intent = new Intent(MainActivity.this,ShowActivity.class);

                        //Convirtiendo valores a String
                        String X1= x1.toString();
                        String X2= x2.toString();
                        String a = A.toString();
                        String b = B.toString();
                        String c = C.toString();
                        String Discriminante = discriminante.toString();

                        intent.putExtra("valor1",X1);
                        intent.putExtra("valor2",X2);
                        intent.putExtra("discriminante",Discriminante);
                        intent.putExtra("valorA",a);
                        intent.putExtra("valorB",b);
                        intent.putExtra("valorC",c);
                       // intent.putExtra("Porcentaje1", Ca1);
                       // intent.putExtra("Porcentaje2", Ca2);
                       // intent.putExtra("Porcentaje3", Ca3);
                       // intent.putExtra("Porcentaje4", Ca4);

                        startActivity(intent);

                    }
                } catch (IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(),"Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}