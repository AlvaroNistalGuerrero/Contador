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
        jugadores.add(new Jugador("Ash","984", R.drawable.ash));
        jugadores.add(new Jugador("Mark Evans","13", R.drawable.mark_evans));
        jugadores.add(new Jugador("Mortadelo","8", R.drawable.mortadelo_sin_fondo));
        jugadores.add(new Jugador("Oliver","6", R.drawable.oliver));
        jugadores.add(new Jugador("Benji","1", R.drawable.benji));

    }
    public void volverJuego(View v){
        finish();
}



}
