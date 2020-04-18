package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class InformacionFinal extends AppCompatActivity {

    private Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_final);

        finalizar = (Button)findViewById(R.id.btnFinalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abrir();
            }
        });
    }



    public void Abrir(){

        Intent intent  =new Intent(getApplicationContext(),InformacionFinal.class);
        startActivity(intent);
        finish();
    }
}
