package com.example.contador;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InicioDeSesion extends AppCompatActivity {
    private EditText edC2,edN2;
    Button botonSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciodesesion);

        edC2 = (EditText) findViewById(R.id.editContraseña2);
        edN2 = (EditText) findViewById(R.id.editNombre2);

        botonSignIn = (Button) findViewById(R.id.acceder2);

        final HelperBBDD helper = new HelperBBDD(this);

        botonSignIn.setOnClickListener(view -> {

            String usuario = edN2.getText().toString();
            String contraseña = edC2.getText().toString();

            if(usuario.equals("")||contraseña.equals("")) {
                Toast.makeText(InicioDeSesion.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
            }
            if (helper.checkContraseña(usuario,contraseña) == true && helper.checkNombre(usuario) == true){
                Toast.makeText(InicioDeSesion.this, "Acceso identificado", Toast.LENGTH_LONG).show();
                      Intent intent = new Intent(getApplicationContext(),PantallaInicio.class);
                      startActivity(intent);
            }else{
                Toast.makeText(InicioDeSesion.this, "Credenciales no coinciden, registrese si no lo ha hecho", Toast.LENGTH_LONG).show();

            }

        });

    }
//            }else{
//                Boolean checkPassword = helper.checkContraseña(usuario,contraseña);
//                if(checkPassword==true){
//                    Toast.makeText(InicioDeSesion.this, "Acceso identificado", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getApplicationContext(),PantallaInicio.class);
//                    startActivity(intent);
//                }

    public void VolverALogin(View view) {
        finish();
    }
}
