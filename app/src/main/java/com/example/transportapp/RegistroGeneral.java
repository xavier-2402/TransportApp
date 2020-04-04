package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroGeneral extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText direccion;
    private EditText correo;
    private EditText telefono;
    private EditText cedula;
    private Button siguiente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cedula=findViewById(R.id.txtCedula);
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        direccion=findViewById(R.id.txtDireccion);
        correo=findViewById(R.id.txtCorreo);
        telefono=findViewById(R.id.txtTelefono);
        siguiente=findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarCampos();
            }
        });
        setContentView(R.layout.activity_registro_general);
    }

    public boolean ValidarCampos(){
        boolean retorno=true;
        String ced=cedula.getText().toString();
        String nom=nombre.getText().toString();
        String ape=apellido.getText().toString();
        String dir=direccion.getText().toString();
        String co=correo.getText().toString();
        String tel=telefono.getText().toString();
        if (ced.isEmpty()){
            cedula.setError("Campo vacio");
            retorno =false;
        }if (nom.isEmpty()){
            nombre.setError("Campo vacio");
            retorno =false;
        }if (ape.isEmpty()){
            apellido.setError("Campo vacio");
            retorno =false;
        }if (co.isEmpty()){
            correo.setError("Campo vacio");
            retorno =false;
        }if (dir.isEmpty()){
            direccion.setError("Campo vacio");
            retorno =false;
        }if (tel.isEmpty()){
            telefono.setError("Campo vacio");
            retorno =false;
        }
        return retorno;
    }
}
