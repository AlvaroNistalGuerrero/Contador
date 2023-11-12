package com.example.contador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PantallaInicio extends AppCompatActivity {
    private TextView text;
    private TextView text1, text2;
    private static final String msg = "Has seleccionado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

    }
        public void irMainActivity (View v){
            Intent i = new Intent(this, MainActivity.class);    // Intent se usa para hacer un salto de actividad
            startActivity(i);
        }
        public void ApuntarMisRecords(View v) {
        Intent i = new Intent(this, ApuntarMisRecords.class);    // Intent se usa para hacer un salto de actividad
        startActivity(i);
    }
        public void irOpciones (View v){
            Intent i = new Intent(this, Opciones.class);    // Intent se usa para hacer un salto de actividad
            startActivity(i);
        }
        public void cerrarAplicaion (View v){
            finish();
        }



}