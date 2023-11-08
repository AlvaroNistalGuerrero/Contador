package com.example.contador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorViewHolder> {

    Context context;
    List<Jugador> jugadores;
    public JugadorAdapter(Context context, List<Jugador> jugadores) {
        this.context = context;
        this.jugadores = jugadores;
    }

    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JugadorViewHolder(LayoutInflater.from(context).inflate(R.layout.jugador_vista,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        holder.nick.setText(jugadores.get(position).getNick());
        holder.nick.setText(jugadores.get(position).getImagen());
        holder.nick.setText(jugadores.get(position).getCapturas());
    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }
}
