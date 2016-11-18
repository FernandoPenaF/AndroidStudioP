package com.example.lpenaf.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private RadioButton r1, r2, r3, r4, r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.ETnumero1);
        num2 = (EditText)findViewById(R.id.ETnumero2);
        r1 = (RadioButton)findViewById(R.id.rbSuma);
        r2 = (RadioButton)findViewById(R.id.rbResta);
        r3 = (RadioButton)findViewById(R.id.rbMultiplica);
        r4 = (RadioButton)findViewById(R.id.rbDivide);
        r5 = (RadioButton)findViewById(R.id.rbPotencia);
    }

    public void calcula(View view){
        int resp = 0;
        int oper1, oper2;
        if(num1.getText().toString().equals(""))
            oper1 = 0;
        else
            oper1 = Integer.parseInt(num1.getText().toString());
        if(num2.getText().toString().equals(""))
            oper2 = 0;
        else
            oper2 = Integer.parseInt(num2.getText().toString());

        if(r1.isChecked())
            resp = oper1 + oper2;
        else if(r2.isChecked())
            resp = oper1 - oper2;
        else if(r3.isChecked())
            resp = oper1 * oper2;
        else if(r4.isChecked()){
            if(oper2 != 0)
                resp = oper1 / oper2;
            else
                error();
        } else if(oper1 == 0 && oper2 == 0)
            error();
        else
            resp = (int) Math.pow(oper1, oper2);
        mostrar(resp);
    }

    public void mostrar(int num){
        Toast.makeText(this,"El resultado es " + num, Toast.LENGTH_LONG).show();
    }

    public void error(){
        Toast.makeText(this,"Algún número ingresado no es válido para esta operacion", Toast.LENGTH_LONG).show();
    }

}
