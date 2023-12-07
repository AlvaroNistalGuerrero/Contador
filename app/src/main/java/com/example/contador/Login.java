package com.example.contador;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText edC,edN;
    Button botonRegistrar,botonAcceder,botonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edC = (EditText) findViewById(R.id.editContraseña);
        edN = (EditText) findViewById(R.id.editNombre);

        botonRegistrar = (Button) findViewById(R.id.register);
        botonAcceder = (Button) findViewById(R.id.acceder);
        botonEliminar = (Button) findViewById(R.id.elminar);

        final HelperBBDD helper = new HelperBBDD(this);
        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase bbdd = helper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(EstructuraBBDD.COLUMN_USER, edN.getText().toString());
                //Primer dato del parentesis es a donde se inserta y el segundo es QUE se inserta
                values.put(EstructuraBBDD.COLUMN_PASSWORD, edC.getText().toString());

                //Le paso los valores añadidos en las dos lineas de arriba(44,43)
                long newRowId = bbdd.insert(EstructuraBBDD.TABLE_USERS,null ,values);

                //para mostar un mensaje Toast por consola y verificar que esta bien insertado el dato
                Toast.makeText(getApplicationContext(), "Registro guardado con exito el registro : " + newRowId ,Toast.LENGTH_LONG).show();

            }
        });
        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE); //Vamos a editar el archivo "datos"
//        ed1.setText(preferences.getString("name", "")); //Cuando se arranca la app por primera vez no hay nada, por lo que se queda solo las comillas
//        ed2.setText(preferences.getString("password", ""));


    }
    /*
    Metodo para registrar los datos
     */
//    public void Guardar(View v){
//        SharedPreferences p = getSharedPreferences("datos", Context.MODE_PRIVATE); //Vamos a editar el archivo "datos"
//        SharedPreferences.Editor editor = p.edit();
//        editor.putString("name", ed1.getText().toString());
//        editor.putString("password", ed2.getText().toString());
//        editor.commit();    //Confirmo que quiero guardar los datos escritos por el usuario
//
//        Intent intent = new Intent(this, PantallaInicio.class);
//        startActivity(intent);
//    }
////    public void crearDB(View v){
////        HelperBD helperBD = new HelperBD(Login.this);
////        SQLiteDatabase db = helperBD.getWritableDatabase();
////
////        if(db != null){
////            Toast.makeText(Login.this,"BASE DE DATOS CREADA CON EXITO", Toast.LENGTH_LONG).show();
////        }else {
////            Toast.makeText(Login.this,"LA BASE DE DATOS NO SE HA CREADO", Toast.LENGTH_LONG).show();
////        }
////    }

    public void SalirDelTodo(View view) {
        finish();
    }
}
