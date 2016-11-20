package com.example.sdist.ejerciciointegral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String correo = "expe316@hotmail.com";
    private final String contraseña = "123";
    private EditText mail;
    private EditText pass;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = (EditText)findViewById(R.id.textMail);
        pass = (EditText)findViewById(R.id.textPass);
        btnAceptar = (Button)findViewById(R.id.btnInicia);
    }

    public void iniciarSesion(View v){
        if(mail.getText().toString().equals(correo) && pass.getText().toString().equals(contraseña)) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Mail", mail.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        } else
            Toast.makeText(this,"El correo y/o la contraseña NO son correctos", Toast.LENGTH_LONG).show();
    }

}
