package com.example.fernando.app1;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView label;
    private RadioButton r1, r2, r3;
    private Button bt;
    private int selectedLanguage;
    private final String[] txtLabels = {"Selecciona el idioma", "Select the language", "Sélectionnez la langue"};
    private final String[] txtButton = {"Continuar", "Continue", "Continuer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = (TextView)findViewById(R.id.lbIdioma);
        r1 = (RadioButton)findViewById(R.id.rbEsp);
        r2 = (RadioButton)findViewById(R.id.rbIng);
        r3 = (RadioButton)findViewById(R.id.rbFran);
        bt = (Button)findViewById(R.id.btContinuar);
        selectedLanguage = 0;
    }

    public void cambiaIdioma(View view){
        if(r1.isChecked()) {
            label.setText(txtLabels[0]);
            bt.setText(txtButton[0]);
            selectedLanguage = 0;
        }
        else if (r2.isChecked()) {
            label.setText(txtLabels[1]);
            bt.setText(txtButton[1]);
            selectedLanguage = 1;
        }
        else if (r3.isChecked()) {
            label.setText(txtLabels[2]);
            bt.setText(txtButton[2]);
            selectedLanguage = 2;
        }
    }

    public void continuar(View view){
        Intent intent = new Intent(MainActivity.this, Login.class);
        Bundle bundle = new Bundle();
        bundle.putInt("Idioma", selectedLanguage);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
