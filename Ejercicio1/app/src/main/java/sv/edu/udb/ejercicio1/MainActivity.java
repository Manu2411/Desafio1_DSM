package sv.edu.udb.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etA, etB, etC;
    private Button Calcular;
    private ImageView Image;

    Float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Asignando valores a los TextEdit
            etA = (EditText)findViewById(R.id.etA);
            etB = (EditText)findViewById(R.id.etB);
            etC = (EditText)findViewById(R.id.etC);

            //Agregando Imagen al ImageView
            Image =(ImageView)findViewById(R.id.imageView4); Image.setImageResource(R.drawable.cuadratica);

        } catch (IllegalArgumentException e){
           // Toast.makeText(ShowActivity.this,"Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}