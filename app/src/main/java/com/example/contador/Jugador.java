package com.example.contador;

public class Jugador {

    String nick;
    String capturas;
    int imagen;


    public Jugador(String nick, String capturas, int imagen) {
        this.nick = nick;
        this.capturas = capturas;
        this.imagen = imagen;
    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCapturas() {
        return capturas;
    }

    public void setCapturas(String monedas) {
        this.capturas = monedas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }



}
