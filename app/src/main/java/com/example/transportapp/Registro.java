package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.PatternPathMotion;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity   {

    private Button siguiente;
    private EditText nombre;
    private EditText apellido;
    private EditText direccion;
    private EditText correo;
    private EditText telefono;
    private EditText cedula;
    private EditText pass;
    private EditText passverifica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        cedula=findViewById(R.id.txtCedula);
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        direccion=findViewById(R.id.txtDireccion);
        correo=findViewById(R.id.txtCorreo);
        telefono=findViewById(R.id.txtTelefono);
        pass=findViewById(R.id.txtPasswordRegistro);
        passverifica=findViewById(R.id.txtPasswordVerificar);
        siguiente=findViewById(R.id.btnSiguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Registro Detallado", Toast.LENGTH_SHORT).show();
                ValidarCampos();
                Intent intent = new Intent(getApplicationContext(), RegistroDetallado.class);
                startActivity(intent);
                finish();
            }
        });
    }



    public boolean ValidarCampos(){
        boolean retorno=true;
        String ced=cedula.getText().toString();
        String nom=nombre.getText().toString();
        String ape=apellido.getText().toString();
        String dir=direccion.getText().toString();
        String co=correo.getText().toString();
        String tel=telefono.getText().toString();
        String pas1=pass.getText().toString();
        String pas2= passverifica.getText().toString();
        if (ced.isEmpty()){
            cedula.setError("Campo vacio");
            retorno =false;
        }if (nom.isEmpty()){
            nombre.setError("Campo vacio");
            retorno =false;
        }if (ape.isEmpty()){
            apellido.setError("Campo vacio");
            retorno =false;
        }
        if (co.isEmpty()) {
            correo.setError("Campo vacio");
            retorno = false;
        }
            if(!Patterns.EMAIL_ADDRESS.matcher(co).matches()){
                    correo.setError("Correo invalido");
                    retorno= false;
        }
            if (dir.isEmpty()){
            direccion.setError("Campo vacio");
            retorno =false;
        }
            if (tel.isEmpty()){
            telefono.setError("Campo vacio");
            retorno =false;
        }
        if (pas1.isEmpty()){
            pass.setError("Campo vacio");
            retorno =false;
        }if (pas2.isEmpty()){
            passverifica.setError("Campo vacio");
            retorno =false;
        }
        if(pas1.equals(pas2)){
        }
        else{
            Toast.makeText(getApplicationContext(),"No coinciden las contraseñas", Toast.LENGTH_SHORT).show();
            passverifica.setText("");
            pass.setText("");
        }
        return retorno;
    }

   /* public void validarContraseña(){
        String pas1= pass.getText().toString();
        String pas2=passverifica.getText().toString();

        if(pas1.equals(pas2)){

        }
        else{
            Toast.makeText(getApplicationContext(),"No coinciden las contraseñas", Toast.LENGTH_SHORT).show();
            passverifica.setText("");
        }

    }*/


}
