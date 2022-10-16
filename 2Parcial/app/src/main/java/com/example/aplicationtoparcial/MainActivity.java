package com.example.aplicationtoparcial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Parte de los button
    public void seccionStart (View view){
        Intent strSeccion = new Intent(this, Inventario1.class);
        startActivity(strSeccion);
    }

}