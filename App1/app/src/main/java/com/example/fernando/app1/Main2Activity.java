package com.example.fernando.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private String[] txtSaludo = {"Bienvenido", "Welcome", "Bienvenue"};
    private int selectedLanguage;
    private String correo;
    private TextView label;
    private EditText celcius, farenheit;
    private boolean changed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = this.getIntent().getExtras();

        label = (TextView)findViewById(R.id.lbBienvenido);
        celcius = (EditText)findViewById(R.id.etCelcius);
        farenheit = (EditText)findViewById(R.id.etFarenheit);
        selectedLanguage = (int) bundle.get("Idioma");
        correo = (String) bundle.get("Correo");
        changed = false;
        setSaludo();

        final TextWatcher twCelcius = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!changed) {
                    changed = true;
                    if (!celcius.getText().toString().equals(""))
                        farenheit.setText(String.valueOf(toFarenheit(Double.valueOf(celcius.getText().toString()))));
                    else
                        farenheit.setText("");
                    changed = false;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        final TextWatcher twFarenheit = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!changed) {
                    changed = true;
                    if (!farenheit.getText().toString().equals(""))
                        celcius.setText(String.valueOf(toCelcius(Double.valueOf(farenheit.getText().toString()))));
                    else
                        celcius.setText("");
                    changed = false;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        celcius.addTextChangedListener(twCelcius);
        farenheit.addTextChangedListener(twFarenheit);
    }

    public void setSaludo(){
        label.setText(txtSaludo[selectedLanguage] + ", " + correo);
    }

    public double toFarenheit(double cel){
        return ((9 / 5.0) * cel) + 32;
    }

    public double toCelcius(double far){
        return (5 / 9.0) * (far - 32);
    }

    public double toKelvin(double cel){
        return cel + 273.15;
    }
}
