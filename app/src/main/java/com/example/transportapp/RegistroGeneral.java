package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroGeneral extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText direccion;
    private EditText correo;
    private EditText telefono;
    private EditText cedula;
    private EditText usuario;
    private EditText pass;
    private EditText passverifica;
    private Button siguiente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cedula=findViewById(R.id.txtCedula);
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        direccion=findViewById(R.id.txtDireccion);
        correo=findViewById(R.id.txtCorreo);
        usuario=findViewById(R.id.txtUsuarioRegistro);
        pass=findViewById(R.id.txtPasswordRegistro);
        passverifica=findViewById(R.id.txtPasswordVerificar);
        telefono=findViewById(R.id.txtTelefono);
        siguiente=findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidarCampos()==true){
                    Intent intent = new Intent(getApplicationContext(),RegistroDetallado.class);
                    startActivity(intent);
                            finish();
                }

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
        String us=usuario.getText().toString();
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
        if (us.isEmpty()){
            usuario.setError("Campo vacio");
            retorno =false;
        }
        if (pas1.isEmpty()){
            pass.setError("Campo vacio");
            retorno =false;
        }if (pas2.isEmpty()){
            passverifica.setError("Campo vacio");
            retorno =false;
        }
        return retorno;
    }

    public void validarContraseña(){
        String pas1= pass.getText().toString();
        String pas2=passverifica.getText().toString();

        if(pas1.equals(pas2)){

        }
        else{
            Toast.makeText(getApplicationContext(),"No coinciden las contraseñas", Toast.LENGTH_SHORT).show();
            passverifica.setText("");
        }

    }

}
