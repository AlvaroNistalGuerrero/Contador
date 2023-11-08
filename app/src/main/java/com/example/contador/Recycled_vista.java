package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycled_vista extends AppCompatActivity {
    List<Jugador> jugadores = new ArrayList<Jugador>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);
        RecyclerView rv = findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new JugadorAdapter(getApplicationContext(),jugadores));
        jugadores.add(new Jugador("Raul","23534645", R.drawable.ash));
        jugadores.add(new Jugador("Pepe","834645", R.drawable.ash));
        jugadores.add(new Jugador("Manu","934645", R.drawable.ash));
        jugadores.add(new Jugador("Juan","13535", R.drawable.ash));
    }
    public void volverJuego(View v){
        finish();
}



}
