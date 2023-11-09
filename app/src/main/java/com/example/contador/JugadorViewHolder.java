package com.example.contador;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JugadorViewHolder extends RecyclerView.ViewHolder{

    ImageView imagen;
    TextView nick,capturados;
    public JugadorViewHolder(@NonNull View itemView){
        super(itemView);
        nick = itemView.findViewById(R.id.nick);
        capturados = itemView.findViewById(R.id.cap);
        imagen = itemView.findViewById(R.id.img);
    }
}
