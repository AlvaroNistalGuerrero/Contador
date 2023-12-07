package com.example.contador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EstructuraBBDD { //extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "POKEMON_DB";

    /*
    Tablas y Columnas
     */
    public static final String TABLE_USERS = "t_users";

    public static final String COLUMN_USER = "Usuario";
    public static final String COLUMN_PASSWORD = "Contraseña";

    /*
    Especificaciones generales
     */
    private static final String TEXT_TYPE = " TEXT";
    private static final String SEP = ",";

    /*
    Creador de tabla y eliminador de tablas
     */
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EstructuraBBDD.TABLE_USERS + " (" +
                    EstructuraBBDD.COLUMN_USER + " INTEGER PRIMARY KEY," +
                    EstructuraBBDD.COLUMN_PASSWORD + TEXT_TYPE + SEP + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EstructuraBBDD.TABLE_USERS;


}
