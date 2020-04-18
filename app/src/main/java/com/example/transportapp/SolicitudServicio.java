package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SolicitudServicio extends AppCompatActivity implements MapasFragment.OnFragmentInteractionListener {

    private Button btnTrazar;
    private Button btncancelar;
    private Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudservicio);

        btnAceptar=findViewById(R.id.btnAceptar);
        btncancelar=findViewById(R.id.btncancelar);
        btnTrazar=findViewById(R.id.btnTrazar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abrir();
            }
        });
    }




    public void onFragmentInteraction(Uri uri) {

    }

    public void trazar(View view) {

        Fragment fragmento = new MapasFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmento).commit();


        btnTrazar.setVisibility(View.INVISIBLE);
        btnAceptar.setVisibility(View.INVISIBLE);
        btncancelar.setVisibility(View.INVISIBLE);
    }

    public void Abrir(){

        Intent intent  =new Intent(getApplicationContext(),InformacionFinal.class);
        startActivity(intent);
        finish();
    }
    public void fina(View view) {
        Intent intent = new Intent(getApplicationContext(), InformacionFinal.class);
        startActivity(intent);
        finish();

    }
}