package sv.edu.udb.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {
    private Bundle bundle;
    private TextView tvx1, tvx2, tvA, tvB, tvC;

    String x1, x2, A, B, C, Discriminante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

       try {
           //Asignando valores a TextView
           tvx1=(TextView)findViewById(R.id.tvx1);
           tvx2=(TextView)findViewById(R.id.tvx2);
           tvA=(TextView)findViewById(R.id.tvA);
           tvB=(TextView)findViewById(R.id.tvB);
           tvC=(TextView)findViewById(R.id.tvC);

           //Capturando los datos recibidos del MainActivity
           bundle = getIntent().getExtras();

           x1 = bundle.getString("valor1");
           x2 = bundle.getString("valor2");
           A = bundle.getString("valorA");
           B = bundle.getString("valorB");
           C = bundle.getString("valorC");
           Discriminante = bundle.getString("discriminante");

           // Mostrando los valores de los valores
           tvx1.append(x1);
           tvx2.append(x2);
           tvA.append(A);
           tvB.append(B);
           tvC.append(C);

           //tvx1.setText(""+x1);
           //tvx2.setText(""+x2);

       }
       catch (IllegalArgumentException e) {
           Toast.makeText(ShowActivity.this,"Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
       }
    }
}