package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }
    public void irMainActivity(View v){
        Intent i = new Intent(this, MainActivity.class);    // Intent se usa para hacer un salto de actividad
        startActivity(i);
    }
    public void irOpciones(View v){
        Intent i = new Intent(this, Opciones.class);    // Intent se usa para hacer un salto de actividad
        startActivity(i);
    }
    public void cerrarAplicaion(View v){
        finish();
    }
    public void irInfo(View v){
        Intent i = new Intent(this, Info.class);    // Intent se usa para hacer un salto de actividad
        startActivity(i);
    }
}