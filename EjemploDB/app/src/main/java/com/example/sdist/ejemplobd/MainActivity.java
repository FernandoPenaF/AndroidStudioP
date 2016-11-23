package com.example.sdist.ejemplobd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.etClave);
        et2 = (EditText) findViewById(R.id.etNombre);
        et3 = (EditText) findViewById(R.id.etCarrera);
        et4 = (EditText) findViewById(R.id.etUniversidad);
    }

    public void limpiar(View view) {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
    }

    public void alta(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String cu = et1.getText().toString();
        String nombre = et2.getText().toString();
        String carrera = et3.getText().toString();
        String universidad = et4.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("cu", cu);
        registro.put("nombre", nombre);
        registro.put("carrera", carrera);
        registro.put("universidad", universidad);
        database.insert("alumnos", null, registro);
        database.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");

        Toast.makeText(this, "Alta de datos exitosa", Toast.LENGTH_LONG).show();
    }

    public void consulta(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String cu = et1.getText().toString();
        Cursor file = database.rawQuery("SELECT nombre, carrera, universidad FROM alumnos WHERE cu = " + cu, null);
        if (file.moveToFirst()) {
            et2.setText(file.getString(0));
            et3.setText(file.getString(1));
            et4.setText(file.getString(2));
        } else
            Toast.makeText(this, "No existe una persona con dicho CU", Toast.LENGTH_SHORT).show();
        database.close();
    }

    public void modifica(View view) {
        if (!estaVacia()) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();
            String cu = et1.getText().toString();
            String nombre = et2.getText().toString();
            String carrera = et3.getText().toString();
            String universidad = et4.getText().toString();
            ContentValues registro = new ContentValues();

            registro.put("cu", cu);
            registro.put("nombre", nombre);
            registro.put("carrera", carrera);
            registro.put("universidad", universidad);
            database.update("alumnos", registro,"cu = " + cu, null);
            database.close();

            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            Toast.makeText(this, "Datos modificados con éxito", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Busca un alumno para modificar su información", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View view){
        if(!estaVacia()){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();
            String cu = et1.getText().toString();

            database.delete("alumnos", "cu = " + cu, null);
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Busca un alumno para eliminarlo", Toast.LENGTH_SHORT).show();
        }
    }
    
    public boolean estaVacia(){
        return et1.getText().toString().equals("") && et2.getText().toString().equals("") && et3.getText().toString().equals("") && et4.getText().toString().equals("");
    }

}
