package com.example.desarrolloparcial;

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


    }
}