package com.example.lpenaf.basedatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText cu, nombre, correo, carrera, universidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cu = (EditText)findViewById(R.id.etCu);
        nombre = (EditText)findViewById(R.id.etNombre);
        correo = (EditText)findViewById(R.id.etCorreo);
        carrera = (EditText)findViewById(R.id.etCarrera);
        universidad = (EditText)findViewById(R.id.etUniversidad);
    }

    public void clear(){
        cu.setText("");
        nombre.setText("");
        correo.setText("");
        carrera.setText("");
        universidad.setText("");
    }

    public boolean algoVacio(){
        return cu.getText().toString().equals("") || nombre.getText().toString().equals("")
                || correo.getText().toString().equals("") || carrera.getText().toString().equals("")
                || universidad.getText().toString().equals("");
    }

    public void alta(View view){
        if(!algoVacio()) {
            //Abrir base
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ITAMa", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();

            int clave = Integer.valueOf(cu.getText().toString());
            String nom = nombre.getText().toString();
            String mail = correo.getText().toString();
            String carre = carrera.getText().toString();
            String uni = universidad.getText().toString();

            //añadir valores
            ContentValues registro = new ContentValues();
            registro.put("_id", clave);
            registro.put("nombre", nom);
            registro.put("correo", mail);
            registro.put("carrera", carre);
            registro.put("universidad", uni);

            //Añadir a la base
            database.insert("alumno", null, registro);
            database.close();

            clear();
            Toast.makeText(this, "Alta exitosa", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_LONG).show();
    }

    public void busca(View view){
        if(!cu.getText().toString().equals("")){
            //Abrir base
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ITAMa", null, 1);
            SQLiteDatabase database = admin.getReadableDatabase();

            int clave = Integer.valueOf(cu.getText().toString());
            Cursor busqueda = database.rawQuery("SELECT * FROM alumno WHERE _id =" + clave, null);
            if (busqueda.moveToFirst()){
                cu.setText(busqueda.getString(0));
                nombre.setText(busqueda.getString(1));
                correo.setText(busqueda.getString(2));
                carrera.setText(busqueda.getString(3));
                universidad.setText(busqueda.getString(4));
            }else
                Toast.makeText(this, "No existe algún alumno con clave " + clave, Toast.LENGTH_LONG).show();
            database.close();
        }else
            Toast.makeText(this, "Ingresa una clave única para buscar", Toast.LENGTH_LONG).show();
    }

    public void baja(View view){
        if (!cu.getText().toString().equals("")){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ITAMa", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();

            int clave = Integer.valueOf(cu.getText().toString());
            Cursor busqueda = database.rawQuery("SELECT _id FROM alumno WHERE _id =" + clave, null);
            if(busqueda.moveToFirst()){
                database.delete("alumno", "_id = " + busqueda.getString(0), null);
                Toast.makeText(this, "Baja exitosa", Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(this, "No existe algún alumno con clave " + clave, Toast.LENGTH_LONG).show();
            database.close();
            clear();
        }else
            Toast.makeText(this, "Ingresa una clave única para dar de baja", Toast.LENGTH_LONG).show();
    }

    public void reporte(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}
