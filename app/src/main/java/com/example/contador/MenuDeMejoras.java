package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class MenuDeMejoras extends AppCompatActivity {
    //MenuDeMejorasCallback menuDeMejorasCallback;
    TextView image_name;
    Button botonMejora1;
    int puntos;
    int mejoras;

//    public MenuDeMejoras(MenuDeMejorasCallback menuDeMejorasCallback){
//        this.menuDeMejorasCallback = menuDeMejorasCallback;
//
//    }

//    public void setMenuDeMejorasCallback(){
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_mejoras);
        image_name = (TextView)findViewById(R.id.image_name);
        botonMejora1 = (Button) findViewById(R.id.button1);
        Bundle param = getIntent().getExtras();
        puntos = param.getInt("pts");
//        mejoras = param.getInt("update");
        image_name.setText(" " + param.getString("pts"));
//        botonMejora1.setText(" " + param.getString("update"));

//        image_name.setText(" " + param.getString("botonMejora1"));
    }
    public void retornaMejora1(View v){
       Intent intent = new Intent(this, MainActivity.class);
       intent.putExtra("update", botonMejora1.getText());
       startActivity(intent);
//        setResult(RESULT_OK, intent);
    }

    public void Atras(View v)   { finish(); }

//    public interface MenuDeMejorasCallback {
//        void displayMejoras();
//    }
}