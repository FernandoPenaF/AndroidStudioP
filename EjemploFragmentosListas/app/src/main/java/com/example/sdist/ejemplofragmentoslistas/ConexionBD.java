package com.example.sdist.ejemplofragmentoslistas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sdist on 24/11/2016.
 */
public class ConexionBD extends SQLiteOpenHelper{

    String cadenaCreate = "CREATE TABLE IF NOT EXISTS tablaprueba(_id integer primary key autoincrement, datos text not null);";

    public ConexionBD(Context context) {
        super(context, "prueba.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cadenaCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String cadenaUpdate = "DROP TABLE IF EXISTS tablaprueba;";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }
}
