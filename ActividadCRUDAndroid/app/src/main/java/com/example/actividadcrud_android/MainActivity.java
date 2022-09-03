package com.example.actividadcrud_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText Cedula, NomApellido, NomCole, NoMesa;
    private TextView CC, NameAndLastName, SchoolName, NumMesa;
    private Object context;

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


    // BTN Ingreso
    public void ingresar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"ResultEjercice", null, 1 );
        SQLiteDatabase db = admin.getWritableDatabase();

        // se envian los tributos
        String CC = Cedula.getText().toString();
        String noMesa = NoMesa.getText().toString();
        String noApellido = NomApellido.getText().toString();
        String nomColegio = NomCole.getText().toString();

        // pasamos de String a int
        Integer.parseInt(Cedula.getText().toString());
        Integer.parseInt(NoMesa.getText().toString());




        if(!CC.isEmpty() && !noMesa.isEmpty() && !noApellido.isEmpty() && !nomColegio.isEmpty()){
            // parte del registro
            ContentValues registro = new ContentValues();
            registro.put("CC",CC);
            registro.put("noMesa",noMesa);
            registro.put("noApellido",noApellido);
            registro.put("nomColegio",nomColegio);

            db.insert("personas", null, registro);
            db.close();

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
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