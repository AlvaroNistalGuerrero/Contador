package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class MenuDeMejoras extends AppCompatActivity {
    TextView image_name;
    int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_de_mejoras);
        image_name = (TextView) findViewById(R.id.image_name);
        Bundle param = getIntent().getExtras();
        puntos = param.getInt("pts");
        image_name.setText(" " + param.getString("pts"));
    }
    public void retornaMejora1(View v) {
        Intent intent = new Intent();
        intent.putExtra("mj", image_name.getText().toString());
        setResult(Activity.RESULT_OK, intent);
    }
    public void Atras(View v) {
            finish();
    }
}