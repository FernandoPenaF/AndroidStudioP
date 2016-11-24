package com.example.sdist.ejemplofragmentoslistas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft;

        Fragment f1 = new BlankFragment();
        ft = fm.beginTransaction();
        ft.add(R.id.fragmento_agregar, f1);
        ft.commit();

        Fragment f2 = new FragmentoLista();
        ft = fm.beginTransaction();
        ft.add(R.id.actividadPrincipal, f2);
        ft.commit();
    }
}
