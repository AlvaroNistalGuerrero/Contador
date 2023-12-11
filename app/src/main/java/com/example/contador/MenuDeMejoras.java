package com.example.contador;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class MenuDeMejoras extends AppCompatActivity {
    TextView image_name;
    Button BotonMejora;
    int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_mejoras);
        image_name = (TextView) findViewById(R.id.image_name);
        BotonMejora = (Button) findViewById(R.id.selectButton);
        Bundle param = getIntent().getExtras();
        puntos = param.getInt("pts");
        image_name.setText(" " + param.getString("pts"));
        BotonMejora.setOnClickListener(v ->{
            Intent intent = new Intent();
            intent.putExtra("mejora", "Multi");
            setResult(MenuDeMejoras.RESULT_OK, intent);
//            costeBillete = costeBillete + 20;
//            BotonMejora.setText(costeBillete + " pokemons");
            finish();
        } );
    }

//    public void retornaMejora1(View v) {
//        Intent intent = new Intent();
//        intent.putExtra("mj", image_name.getText().toString());
//        setResult(Activity.RESULT_OK, intent);
//    }
    public void Atras(View v) {
            finish();
    }
}