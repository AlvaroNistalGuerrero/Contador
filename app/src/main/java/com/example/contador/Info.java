package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
    }
    public void irInicio(View v){
//        Intent i = new Intent(this, PantallaInicio.class);    // Intent se usa para hacer un salto de actividad
//        startActivity(i);
        finish(); //cerrar actual
    }
}