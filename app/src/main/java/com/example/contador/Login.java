package com.example.contador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed1 = (EditText) findViewById(R.id.editTextText);
        ed2 = (EditText) findViewById(R.id.editTextTextPassword);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE); //Vamos a editar el archivo "datos"
        ed1.setText(preferences.getString("name", "")); //Cuando se arranca la app por primera vez no hay nada, por lo que se queda solo las comillas
        ed2.setText(preferences.getString("password", ""));
    }
    /*
    Metodo para registrar los datos
     */
    public void Guardar(View v){
        SharedPreferences p = getSharedPreferences("datos", Context.MODE_PRIVATE); //Vamos a editar el archivo "datos"
        SharedPreferences.Editor editor = p.edit();
        editor.putString("name", ed1.getText().toString());
        editor.putString("password", ed2.getText().toString());
        editor.commit();    //Confirmo que quiero guardar los datos escritos por el usuario

        Intent intent = new Intent(this, PantallaInicio.class);
        startActivity(intent);
    }

}
