package com.example.fernando.app1;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private final String[] txtSesion = {"Inicio de sesión", "Login", "Login"};
    private final String[] txtCorreo = {"Correo electrónico", "E-mail", "Courrier électronique"};
    private final String[] txtPass = {"Contraseña", "Password", "Mot de passe"};
    private final String[] txtButton = {"Iniciar sesión", "Login", "Commencer la session"};
    private final String correo = "expe316@hotmail.com";
    private final String contraseña = "123";
    private int selectedLanguage;
    private TextView label;
    private EditText mail;
    private EditText pass;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle = this.getIntent().getExtras();

        label = (TextView)findViewById(R.id.lbInicioSesion);
        mail = (EditText)findViewById(R.id.textMail);
        pass = (EditText)findViewById(R.id.textPass);
        btnAceptar = (Button)findViewById(R.id.btnInicia);
        selectedLanguage = (int) bundle.get("Idioma");
        setIdioma();
    }

    private void setIdioma(){
        label.setText(txtSesion[selectedLanguage]);
        mail.setHint(txtCorreo[selectedLanguage]);
        pass.setHint(txtPass[selectedLanguage]);
        btnAceptar.setText(txtButton[selectedLanguage]);
    }

    public void iniciarSesion(View v){
        if(mail.getText().toString().equals(correo) && pass.getText().toString().equals(contraseña)) {
            Intent intent = new Intent(Login.this, Main2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("Idioma", selectedLanguage);
            bundle.putString("Correo", mail.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        } else
            Toast.makeText(this,"El correo y/o la contraseña NO son correctos", Toast.LENGTH_LONG).show();
    }
}
