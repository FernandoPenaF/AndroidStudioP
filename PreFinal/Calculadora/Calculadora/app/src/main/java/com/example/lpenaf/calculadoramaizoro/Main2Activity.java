package com.example.lpenaf.calculadoramaizoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private String nombre;
    private TextView tvNombre;
    private EditText etNum1, etNum2;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Obtener el nombre dado por el usuario en la ventana anterior
        Bundle bundle = this.getIntent().getExtras();
        this.tvNombre = (TextView)findViewById(R.id.tvBienvenido);
        this.nombre = bundle.get("nombre").toString();
        tvNombre.setText("Bienvenido, " + nombre + " a tu calculadora");

        //Llenar el spinner, ver res/values/strings.xml
        this.spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operaciones, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        this.etNum1 = (EditText)findViewById(R.id.etNum1);
        this.etNum2 = (EditText)findViewById(R.id.etNum2);
    }

    public void calcula(View view){
        double resp = 0;
        String op = spinner.getSelectedItem().toString();
        boolean valido = true;

        if(!(etNum1.getText().toString().equals("") || etNum2.getText().toString().equals(""))) {
            double num1 = Double.valueOf(etNum1.getText().toString());
            double num2 = Double.valueOf(etNum2.getText().toString());

            switch (op) {
                case "Suma":
                    resp = num1 + num2;
                    break;
                case "Resta":
                    resp = num1 - num2;
                    break;
                case "Multiplicación":
                    resp = num1 * num2;
                    break;
                case "División":
                    if (num2 != 0)
                        resp = num1 / num2;
                    else
                        valido = false;
                    break;
                case "Modulo":
                    if (num2 != 0)
                        resp = num1 % num2;
                    else
                        valido = false;
                    break;
                case "Potencia":
                    if (num1 == 0 && num2 == 0)
                        valido = false;
                    else
                        resp = Math.pow(num1, num2);
                    break;
                default:
                    valido = false;
                    break;
            }
            if(valido)
                Toast.makeText(this, "La respuesta es " + resp, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "La operación no es válida para alguno de los números ingresados", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "Ingresa los dos números", Toast.LENGTH_LONG).show();
    }
}
