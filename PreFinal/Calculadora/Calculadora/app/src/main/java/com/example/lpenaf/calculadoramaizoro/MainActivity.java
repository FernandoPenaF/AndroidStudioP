package com.example.lpenaf.calculadoramaizoro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String nombre;
    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombre = "";
        this.etNombre = (EditText)findViewById(R.id.etNombre);
    }

    public void iniciarSesion(View view){
        this.nombre = this.etNombre.getText().toString();
        if(!nombre.equals("")){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nombre", nombre);
            intent.putExtras(bundle);
            startActivity(intent);
        }else
            Toast.makeText(this,"El nombre está vació", Toast.LENGTH_LONG).show();
    }
}
