package com.example.contador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperBBDD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NOMBRE = "POKEMON_BBDD";
    public HelperBBDD(Context context) {

        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(EstructuraBBDD.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(EstructuraBBDD.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);   //La agrego
    }

    public Boolean checkNombre(String nombre){
        SQLiteDatabase DdBb =  this.getWritableDatabase();
        Cursor c = DdBb.rawQuery("SELECT * FROM POKEMON_BBDD WHERE Usuario =?", new String[]{nombre});

        if (c.getCount() > 0) {
            return true;
        }else{
                return false;
        }
    }

    public Boolean checkContraseña(String nombre,String contraseña){
        SQLiteDatabase DdBb =  this.getWritableDatabase();
        Cursor c = DdBb.rawQuery("SELECT * FROM POKEMON_BBDD WHERE Usuario =? AND  Contraseña =?", new String[]{nombre,contraseña});

        if (c.getCount() > 0) {
            return true;
        }else{
            return false;
        }
    }
}
