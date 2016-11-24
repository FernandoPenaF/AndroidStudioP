package com.example.sdist.ejemplofragmentoslistas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by sdist on 24/11/2016.
 */
public class InterfazBD {
    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD(Context context){
        con = new ConexionBD(context);
    }

    public void open() throws SQLiteException{
        db = con.getWritableDatabase();
    }

    public void close() throws SQLiteException{
        con.close();
    }

    public long insertarDatos(String dato){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos", dato);
        long clave = db.insert("tablaprueba", null, valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos", "Hola");
        db.insert("tablaprueba", null, valores);
        valores = new ContentValues();
        valores.put("datos", "Adios");
        db.insert("tablaprueba", null, valores);
        valores = new ContentValues();
        valores.put("datos", "ESNAJ");
        db.insert("tablaprueba", null, valores);
        valores = new ContentValues();
        valores.put("datos", "Messi");
        db.insert("tablaprueba", null, valores);
    }

    public Cursor traerDatos(){
        Cursor res = null;
        open();
        String cadena = "SELECT * from tablaprueba";
        res = db.rawQuery(cadena, null);
        if(res.getCount() == 0){
            insertarDatosPrueba();
            res = db.rawQuery(cadena, null);
        }
        return res;
    }

}
