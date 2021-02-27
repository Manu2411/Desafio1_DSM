package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edName1, edName2, edName3, edLast1, edLast2, edLast3, edCar1, edCar2, edCar3, edHo1, edHo2, edHo3;
    private Button btnCalcular;

    String Name1, Name2, Name3, Cargo1, Cargo2, Cargo3, Mayor, Menor;

    Integer Cant = 0;

    Double Bono1 = 0.0, Bono2 = 0.0, Bono3 = 0.0, SB1 = 0.0, SB2 = 0.0, SB3 = 0.0,  SL1 = 0.0, SL2 = 0.0, SL3 = 0.0, Dif = 0.0;

    Double Horas1, Horas2, Horas3, A1, I1, Re1, A2, I2, Re2, A3, I3, Re3;

    String afp1, afp2, afp3, isss1, isss2, isss3, renta1, renta2, renta3, sl1, sl2, sl3,  B1, B2, B3, Canti;

    DecimalFormat df = new DecimalFormat("###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignando los valores de los controles a las variables
        edName1 = (EditText)findViewById(R.id.edName1);
        edName2 = (EditText)findViewById(R.id.edName2);
        edName3 = (EditText)findViewById(R.id.edName3);

        edLast1 = (EditText)findViewById(R.id.edLast1);
        edLast2 = (EditText)findViewById(R.id.edLast2);
        edLast3 = (EditText)findViewById(R.id.edLast3);

        edCar1 = (EditText)findViewById(R.id.edCargo1);
        edCar2 = (EditText)findViewById(R.id.edCargo2);
        edCar3 = (EditText)findViewById(R.id.edCargo3);

        edHo1 = (EditText)findViewById(R.id.edHoras1);
        edHo2 = (EditText)findViewById(R.id.edHoras2);
        edHo3 = (EditText)findViewById(R.id.edHoras3);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    //Convirtiendo Horas a Double
                    Horas1 = Double.parseDouble(edHo1.getText().toString());
                    Horas2 = Double.parseDouble(edHo2.getText().toString());
                    Horas3 = Double.parseDouble(edHo3.getText().toString());

                    // Uniendo Nombres y Apellidos para completar el Nombre Completo
                    Name1 = edName1.getText().toString() + " " + edLast1.getText().toString();
                    Name2 = edName2.getText().toString() + " " + edLast2.getText().toString();
                    Name3 = edName3.getText().toString() + " " + edLast3.getText().toString();

                    //Convirtiendo Cargos a String
                    Cargo1 = edCar1.getText().toString();
                    Cargo2 = edCar2.getText().toString();
                    Cargo3 = edCar3.getText().toString();

                    if (Horas1 != 0.00 && Horas2 != 0.00 && Horas3 != 0.00 ){

                        /* Calculando el sueldo base de los 3 empleados */
                        if (Horas1 <= 160) {
                            SB1 = Horas1 * 9.75;
                        } else {
                            Dif = Horas1 - 160;

                            SB1 = (160 * 9.75) + (Dif * 11.50);
                        }

                        if (Horas2 <= 160) {
                            SB2 = Horas2 * 9.75;
                        } else {
                            Dif = Horas2 - 160;

                            SB2 = (160 * 9.75) + (Dif * 11.50);
                        }

                        if (Horas3 <= 160) {
                            SB3 = Horas3 * 9.75;
                        } else {
                            Dif = Horas3 - 160;

                            SB3 = (160 * 9.75) + (Dif * 11.50);
                        }
                        /* Aqui termina el calculo del sueldo base */

                        /* Cálculo de Descuentos AFP, ISSS, RENTA */

                        A1 = (SB1) * (0.0688);
                        A2 = (SB2) * (0.0688);
                        A3 = (SB3) * (0.0688);

                        I1 = (SB1) * (0.0525);
                        I2 = (SB2) * (0.0525);
                        I3 = (SB3) * (0.0525);

                        Re1 = (SB1) * (0.1);
                        Re2 = (SB2) * (0.1);
                        Re3 = (SB3) * (0.1);

                        /* Fin de calculos de Descuento */

                        /* Cálculo de Sueldos Líquidos de los 3 trabajadores */

                        SL1 = SB1 - (I1 + A1 + Re1);
                        SL2 = SB2 - (I2 + A2 + Re2);
                        SL3 = SB3 - (I3 + A3 + Re3);

                        /* Aqui termina el calculo del sueldo liquido */


                        /* Calculando los bonos dependiendo de los cargos */

                        switch (Cargo1) {
                            case "Gerente":
                            case "gerente":
                            case "GERENTE":
                                Bono1 = (SL1) * (0.1);
                                break;
                            case "Asistente":
                            case "asistente":
                            case "ASISTENTE":
                                Bono1 = (SL1) * (0.05);
                                break;
                            case "Secretaria":
                            case "secretaria":
                            case "SECRETARIA":
                                Bono1 = (SL1) * (0.03);
                                break;
                            default:
                                Bono1 = (SL1) * (0.02);
                                break;
                        }

                        switch (Cargo2) {
                            case "Gerente":
                            case "gerente":
                            case "GERENTE":
                                Bono2 = (SL2) * (0.1);
                                break;
                            case "Asistente":
                            case "asistente":
                            case "ASISTENTE":
                                Bono2 = (SL2) * (0.05);
                                break;
                            case "Secretaria":
                            case "secretaria":
                            case "SECRETARIA":
                                Bono2 = (SL2) * (0.03);
                                break;
                            default:
                                Bono2 = (SL2) * (0.02);
                                break;
                        }


                        switch (Cargo3) {
                            case "Gerente":
                            case "gerente":
                            case "GERENTE":
                                Bono3 = (SL3) * (0.1);
                                break;
                            case "Asistente":
                            case "asistente":
                            case "ASISTENTE":
                                Bono3 = (SL3) * (0.05);
                                break;
                            case "Secretaria":
                            case "secretaria":
                            case "SECRETARIA":
                                Bono3 = (SL3) * (0.03);
                                break;
                            default:
                                Bono3 = (SL3) * (0.02);
                                break;
                        }

                        /* Aquí termina el calculo de los bonos */

                        /* Restricción sobre el Bono */

                        if ((Cargo1.equals("Gerente") || Cargo1.equals("gerente") || Cargo1.equals("GERENTE")) && (Cargo2.equals("Asistente") || Cargo2.equals("asistente") || Cargo2.equals("ASISTENTE"))
                                && (Cargo3.equals("Secretaria") || Cargo3.equals("secretaria") || Cargo3.equals("SECRETARIA"))) {
                            Bono1 = 0.0;
                            Bono2 = 0.0;
                            Bono3 = 0.0;
                        }

                        /* Fin de la Restricción */

                        /* Buscando el mayor y menor salario */
                        if ((SL1 > SL2) && (SL1 > SL3) && (SL2 > SL3)) {
                            Mayor = "Mayor salario es: $" + df.format(SL1) + ".";
                            Menor = "Menor salario es: $" + df.format(SL3) + ".";
                        } else if ((SL1 > SL2) && (SL1 > SL3) && (SL3 > SL2)) {
                            Mayor = "Mayor salario es: $" + df.format(SL1) + ".";
                            Menor = "Menor salario es: $" + df.format(SL2) + ".";
                        } else if ((SL2 > SL1) && (SL2 > SL3) && (SL1 > SL3)) {
                            Mayor = "Mayor salario es: $" + df.format(SL2) + ".";
                            Menor = "Menor salario es: $" + df.format(SL3) + "." ;
                        } else if ((SL2 > SL1) && (SL2 > SL3) && (SL3 > SL1)) {
                            Mayor = "Mayor salario es: $" + df.format(SL2) + ".";
                            Menor = "Menor salario es: $" + df.format(SL1) + ".";
                        } else if ((SL3 > SL1) && (SL3 > SL2) && (SL1 > SL2)) {
                            Mayor = "Mayor salario es: $" + df.format(SL3) + ".";
                            Menor = "Menor salario es: $" + df.format(SL2) + ".";
                        } else if ((SL3 > SL1) && (SL3 > SL2) && (SL2 > SL1)) {
                            Mayor = "Mayor salario es: $" + df.format(SL3) + ".";
                            Menor = "Menor salario es: $" + df.format(SL1) + ".";
                        } else if ((SL1 > SL2) && (SL1 > SL3) && (SL2 == SL3)) {
                            Mayor = "Mayor salario es: $" + df.format(SL1) + ".";
                            Menor = "Menores salarios son: $" + df.format(SL2) + " y $" + df.format(SL3) + " ya que son iguales";
                        } else if ((SL2 > SL1) && (SL2 > SL3) && (SL1 == SL3)) {
                            Mayor = "Mayor salario es: $" + df.format(SL2) + ".";
                            Menor = "Menores salarios son: $" + df.format(SL1) + " y $" + df.format(SL3) + " ya que son iguales";
                        } else if ((SL3 > SL1) && (SL3 > SL2) && (SL1 == SL2)) {
                            Mayor = "Mayor salario es: $" + df.format(SL3) + ".";
                            Menor = "Menores salarios son: $" + df.format(SL1) + " y $" + df.format(SL2) + " ya que son iguales";
                        } else if ((SL1 > SL2) && (SL3 > SL2) && (SL1 == SL3)) {
                            Mayor = "Mayores salarios son: $" + df.format(SL1) + " y $" + df.format(SL3) + " ya que son iguales";
                            Menor = "Menor salario es: $" + df.format(SL2) + ".";
                        } else if ((SL2 > SL1) && (SL3 > SL1) && (SL2 == SL3)) {
                            Mayor = "Mayores salarios son: $" + df.format(SL2) + " y $" + df.format(SL3) + " ya que son iguales";
                            Menor = "Menor salario es: $" + df.format(SL1) + ".";
                        } else if ((SL1 > SL3) && (SL2 > SL3) && (SL1 == SL2)) {
                            Mayor = "Mayores salarios son: $" + df.format(SL1) + " y $" + df.format(SL2) + " ya que son iguales";
                            Menor = "Menor salario es: $" + df.format(SL3) + ".";
                        } else {
                            Mayor = "No hay mayor salario ya que los 3 Salarios son Iguales";
                            Menor = "No hay menor salario ya que los 3 Salarios son Iguales";
                        }
                        /* Fin de Busqueda de Mayor y menor Salario */

                        /* Comparando Salarios con $300 */
                        if ((SL1 > 300.00) && (SL2 > 300.00) && (SL3 > 300.00)) {
                            Cant = 3;
                        } else if (((SL1 > 300.00) && (SL2 > 300.00)) || ((SL2 > 300.00) && (SL3 > 300.00)) || ((SL1 > 300.00) && (SL3 > 300.00))) {
                            Cant = 2;
                        } else if ((SL1 > 300.00) || (SL2 > 300.00) || (SL3 > 300.00)) {
                            Cant = 1;
                        } else {
                            Cant = 0;
                        }
                        /* Fin de la comparacion con los $300*/

                        /* Convirtiendo a String las variables a pasar */

                        afp1 = df.format(A1);
                        afp2 = df.format(A2);
                        afp3 = df.format(A3);

                        isss1 = df.format(I1);
                        isss2 = df.format(I2);
                        isss3 = df.format(I3);

                        renta1 = df.format(Re1);
                        renta2 = df.format(Re2);
                        renta3 = df.format(Re3);

                        sl1 = df.format(SL1);
                        sl2 = df.format(SL2);
                        sl3 = df.format(SL3);

                        B1 = df.format(Bono1);
                        B2 = df.format(Bono2);
                        B3 = df.format(Bono3);

                        Canti = Cant.toString();


                        /* Fin de la conversión*/

                        // Pasando las variables a la siguiente Activity para mostrarlas
                        Intent intent = new Intent(MainActivity.this, Activity2.class);

                        intent.putExtra("FullName1", Name1);
                        intent.putExtra("FullName2", Name2);
                        intent.putExtra("FullName3", Name3);

                        intent.putExtra("IS1", isss1);
                        intent.putExtra("IS2", isss2);
                        intent.putExtra("IS3", isss3);

                        intent.putExtra("AFP1", afp1);
                        intent.putExtra("AFP2", afp2);
                        intent.putExtra("AFP3", afp3);

                        intent.putExtra("REN1", renta1);
                        intent.putExtra("REN2", renta2);
                        intent.putExtra("REN3", renta3);

                        intent.putExtra("SL1", sl1);
                        intent.putExtra("SL2", sl2);
                        intent.putExtra("SL3", sl3);

                        intent.putExtra("BO1", B1);
                        intent.putExtra("BO2", B2);
                        intent.putExtra("BO3", B3);

                        intent.putExtra("Cant", Canti);

                        intent.putExtra("Ma", Mayor);
                        intent.putExtra("Men", Menor);

                        startActivity(intent);

                        /* Fin de pasar las variables */

                    }else {

                        if (Horas1 == 0.00){

                            Toast.makeText(MainActivity.this, "ERROR: Las horas trabajadas del empleado 1 no pueden ser 0!!!", Toast.LENGTH_LONG).show();

                        }else if (Horas2 == 0.00){

                            Toast.makeText(MainActivity.this, "ERROR: Las horas trabajadas del empleado 2 no pueden ser 0!!!", Toast.LENGTH_LONG).show();

                        }else {

                            Toast.makeText(MainActivity.this, "ERROR: Las horas trabajadas del empleado 3 no pueden ser 0!!!", Toast.LENGTH_LONG).show();

                        }

                    }
                }catch (IllegalArgumentException e){
                    Toast.makeText(MainActivity.this,"ERROR: Las horas laboradas son un campo obligatorio.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
