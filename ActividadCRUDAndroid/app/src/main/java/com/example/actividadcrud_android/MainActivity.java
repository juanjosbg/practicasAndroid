package com.example.actividadcrud_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText Cedula, NomApellido, NomCole, NoMesa;
    private TextView CC, NameAndLastName, SchoolName, NumMesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ----------------------
        Cedula = (EditText) findViewById(R.id.MensajeIngresoCC);
        NomApellido =(EditText) findViewById(R.id.MensajeIngresoNomApellido);
        NomCole = (EditText) findViewById(R.id.MensajeIngresoNomColegio);
        NoMesa = (EditText) findViewById(R.id.MensajeIngresoNumMesa);
    }

    // Creación de los metodos

    // BTN Ingreso
    public void ingresar(View view){
        String val1 = Cedula.getText().toString();
        String val2 = NoMesa.getText().toString();

        String val3 = NomApellido.getText().toString();
        String val4 = NomCole.getText().toString();

        // pasamos de String a int
        Integer.parseInt(Cedula.getText().toString());
        Integer.parseInt(NoMesa.getText().toString());

    }

    // BTN Consultar
    public void consul (View view){
        String val1 = Cedula.getText().toString();
        String val2 = NoMesa.getText().toString();

        String val3 = NomApellido.getText().toString();
        String val4 = NomCole.getText().toString();

        // pasamos de String a int
        Integer.parseInt(Cedula.getText().toString());
        Integer.parseInt(NoMesa.getText().toString());

    }
    // BTN Eliminar
    public void eliminar (View view){

    }

    // BTN Modificar
    public void modificar (View view){

    }
}