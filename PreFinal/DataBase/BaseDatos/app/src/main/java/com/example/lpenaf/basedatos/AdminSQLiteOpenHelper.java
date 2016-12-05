package com.example.lpenaf.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LPENAF on 05/12/2016.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    private final String alumno = "CREATE TABLE IF NOT EXISTS alumno(cu INTEGER primary key not null, nombre text not null, correo text not null, carrera text not null, universidad text not null);";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(alumno);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop = "DROP TABLE IF EXISTS alumno;";
        sqLiteDatabase.execSQL(drop);
        onCreate(sqLiteDatabase);
    }
}
