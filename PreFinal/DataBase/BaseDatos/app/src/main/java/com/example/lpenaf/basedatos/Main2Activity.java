package com.example.lpenaf.basedatos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    private SimpleCursorAdapter sca;
    private Cursor lista;
    private Adapter adapter;
    private ListView vista;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vista = (ListView)findViewById(R.id.listView);

        String col[] = {"_id", "nombre", "correo", "carrera", "universidad"};
        int to[] = {R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10};
        lista = getList();
        sca = new SimpleCursorAdapter(this, R.layout.formato_renglon, lista, col, to, 0);
        vista.setAdapter(sca);
    }

    private Cursor getList(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ITAMa", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String query = "SELECT * FROM alumno";
        Cursor lista = database.rawQuery(query, null);
        return lista;
    }

    private void regresar(View view){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}