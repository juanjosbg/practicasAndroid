package com.example.parcial1;
import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText Cedula, Nombre, Apellido, NivelEmoglobina, Correo, Edad, Sexo;
    Button btnClose;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cedula = (EditText)findViewById(R.id.textBoxCedula);
        Nombre = (EditText)findViewById(R.id.TextBoxNombre);
        Apellido = (EditText)findViewById(R.id.textBoxApellido);
        NivelEmoglobina = (EditText)findViewById(R.id.textBoxNivelEmoglo);
        Correo = (EditText)findViewById(R.id.textBoxCorreo);
        Edad = (EditText)findViewById(R.id.textBoxEdad);
        Sexo = (EditText)findViewById(R.id.textBoxSexo);
    }

    public void Ingresar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = Cedula.getText().toString();
        String nombre = Nombre.getText().toString();
        String apellido = Apellido.getText().toString();
        String nivelEmoglo = NivelEmoglobina.getText().toString();
        String correo = Correo.getText().toString();
        String edad = Edad.getText().toString();
        String sexo = Sexo.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("cedula", cedula);
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);
        registro.put("nivelEmoglo", nivelEmoglo);
        registro.put("correo", correo);
        registro.put("edad", edad);
        registro.put("sexo", sexo);
        bd.insert("personas", null, registro);
        bd.close();
        Cedula.setText("");
        Nombre.setText("");
        Apellido.setText("");
        NivelEmoglobina.setText("");
        Correo.setText("");
        Edad.setText("");
        Sexo.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona", Toast.LENGTH_SHORT).show();
    }
    public void consulta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = Cedula.getText().toString();
        Cursor fila = bd.rawQuery("select nombre, apellido, nivelEmoglo, correo, edad, sexo from personas where cedula=" + cedula, null);
        if(fila.moveToFirst()){
            Nombre.setText(fila.getString(0));
            Apellido.setText(fila.getString(1));
            NivelEmoglobina.setText(fila.getString(2));
            Correo.setText(fila.getString(3));
            Edad.setText(fila.getString(4));
            Sexo.setText(fila.getString(5));
        }else
            Toast.makeText(this,"No existe una persona con dicha cedula",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = Cedula.getText().toString();
        int cant = bd.delete("personas","cedula="+cedula,null);
        bd.close();
        Cedula.setText("");
        Nombre.setText("");
        Apellido.setText("");
        NivelEmoglobina.setText("");
        Correo.setText("");
        Edad.setText("");
        Sexo.setText("");
        if (cant==1)
            Toast.makeText(this,"Se borró la persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
    }
    public void modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cedula = Cedula.getText().toString();
        String nombre = Nombre.getText().toString();
        String apellido = Apellido.getText().toString();
        String nivelEmoglobina = NivelEmoglobina.getText().toString();
        String correo = Correo.getText().toString();
        String edad = Edad.getText().toString();
        String sexo = Sexo.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);
        registro.put("nivelEmoglo", nivelEmoglobina);
        registro.put("correo", correo);
        registro.put("edad", edad);
        registro.put("sexo", sexo);
        int cant = bd.update("personas", registro, "cedula="+ cedula,null);
        bd.close();
        if (cant ==1)
            Toast.makeText(this,"se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this,"No existe una persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
    }
        protected void alertanemia(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setMessage("Usted tiene anemia")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        alerta.show();
    }
    protected void alertano(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setMessage("Usted no tiene anemia")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        alerta.show();
    }
    protected void alertaedad(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setMessage("Esta edad no esta disponible")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        alerta.show();

    }
    public void calcularAnemia(View view){
        String ValorEdad = Edad.getText().toString();
        String ValorEmoglo = NivelEmoglobina.getText().toString();
        String ValorSexo = Sexo.getText().toString();
        Double edad = Double.parseDouble(ValorEdad);
        double emoglo = Double.parseDouble(ValorEmoglo);
        Boolean Condicion = false;

        Log.d("ValorEdad", String.valueOf(edad));
        Log.d("ValorEmoglo", String.valueOf(emoglo));
        Log.d("ValorSexo", String.valueOf(ValorSexo));

        if ((edad<0.1) && (emoglo>=13.0) && (emoglo<=26.0)){
            alertano(view);
            Condicion = true;
        }
        if (edad>0.1 && edad<=0.6 && emoglo>=10.0 && emoglo<=18.0){
            Log.d("Prueba2", "Anémico caso 2");
            alertano(view);
            Condicion = true;
        }
        if (edad>0.6 && edad<=1 && emoglo>=11.0 && emoglo<=15.0){
            Log.d("Prueba3", "Anémico caso 3");
            alertano(view);
            Condicion = true;
        }
        if (edad>1 && edad<=5 && emoglo>=11.5 && emoglo <=15.0){
            Log.d("Prueba4", "Anémico caso 4");
            alertano(view);
            Condicion = true;
        }
        if (edad>5 && edad<=10 && emoglo>=12.6 && emoglo<=15.5){
            Log.d("Prueba5", "Anémico caso 5");
            alertano(view);
            Condicion = true;
        }
        if (ValorSexo.equalsIgnoreCase("mujer") && edad>15 && emoglo>=12.0 && emoglo<=16.0){
            Log.d("Prueba6", "Anémico caso mujer mayor 15 años");
            alertano(view);
            Condicion = true;
        }
        if (ValorSexo.equalsIgnoreCase("hombre") && edad>15 && emoglo>=14.0 && emoglo<=18){
            Log.d("Prueba7", "Anémico caso hombre mayor 15 años");
            alertano(view);
            Condicion = true;
        }
        if (edad>10 && edad<=15) {
            Log.d("Prueba8", "Por favor indiquele al medico que su rango de edad no está disponible");
            alertaedad(view);
            Condicion = true;
        }
        if (Condicion == true){
            Log.d("TodoCorrecto", "Y yo que me alegro");
        }else if (Condicion == false){
            alertanemia(view);
        }

    }
}