package com.example.primerapractica_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

//importamos las librerias faltantes
import android.view.View;
import android.widget.*;

//------------------------------------------------------------------------------------------
import org.w3c.dom.Text;
public class MainActivity extends AppCompatActivity {

    // Se crean las variables en forma privadas
    private EditText peso, estatura;
    private TextView imc, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // llamado de las variables (Estos son los Datos de entrada)
        peso =(EditText) findViewById(R.id.MensajeIngresoPeso);
        estatura =(EditText) findViewById(R.id.MensajeIngresoEstatura);

        //// llamado de las variables (Estos son los Datos de salida)
        imc =(EditText) findViewById(R.id.MensajEgresoIMC);
        resultado =(EditText) findViewById(R.id.MensagEgreso);
    }

    // Para calcular el peso
    public void calcular(View view){
        String val1 = peso.getText().toString();
        String val2 = estatura.getText().toString();

        double peso1 = Double.parseDouble(val1);
        double est1 = Double.parseDouble(val2);

        // Calculo que realizara el IMC
        double operacion = peso1/(est1*est1);

        String calc = String.valueOf(operacion);
        imc.setText(calc);

        if(operacion <= 18.5){
            resultado.setText("Esta en desnutrición");
        }
        if((operacion >= 18.5)&&(operacion <25)){
            resultado.setText("Esta en bajo peso");
        }
        if((operacion >= 25)&&(operacion <30)){
            resultado.setText("Felicitaciones estas en un estado Estable");
        }
        if((operacion >= 30)&&(operacion <40)){
            resultado.setText("Preocupate tienes problemas de obecidad");
        }
        if(operacion >= 40){
            resultado.setText("Empieza hacer ejericicios gordinflon");
        }

    }
}