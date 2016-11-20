package com.example.sdist.ejemplosegundapantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener la referencia de los controles de la interfaz
        nombre = (EditText)findViewById(R.id.editText);
        btnAceptar = (Button)findViewById(R.id.button);
    }

    public void aceptar(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle bundle = new Bundle(); //Guardar string
        bundle.putString("Nombre", nombre.getText().toString()); //Nombre se "sesion" y el contenido
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
