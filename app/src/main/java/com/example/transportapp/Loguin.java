package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Loguin extends AppCompatActivity {
private EditText usuario;
private EditText contrasenia;
private Button ingresar;
private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);
        usuario=findViewById(R.id.txtUsuario);
        contrasenia=findViewById(R.id.txtContraseña);
        ingresar=findViewById(R.id.btnIngresar);
        registrar=findViewById(R.id.btnRegistro);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarCampos();

            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(getApplicationContext(),RegistroGeneral.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public boolean ValidarCampos(){
        boolean retorno=true;
        String us = usuario.getText().toString();
        String con=contrasenia.getText().toString();
        if (us.isEmpty()){
            usuario.getText().toString();
            retorno =false;
        }if (con.isEmpty()){
            contrasenia.getText().toString();
            retorno =false;
        }
            return retorno;
    }
}
