package com.example.transportapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.transition.PatternPathMotion;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity   {

    //Declaración de variables
    private Button transportista;
    private EditText nombre;
    private EditText apellido;
    private EditText direccion;
    private EditText correo;
    private EditText telefono;
    private EditText cedula;
    private EditText pass;
    private EditText passverifica;
    private Button clientes;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Casting
        cedula=findViewById(R.id.txtCedula);
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        direccion=findViewById(R.id.txtDireccion);
        correo=findViewById(R.id.txtCorreo);
        telefono=findViewById(R.id.txtTelefono);
        pass=findViewById(R.id.txtPasswordRegistro);
        passverifica=findViewById(R.id.txtPasswordVerificar);
        transportista=findViewById(R.id.btnTranportista);
        img =findViewById(R.id.imagen);
        clientes=findViewById(R.id.btnCliente);
        clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidarCampos()== true){
                    Intent intent = new Intent(getApplicationContext(),RegistroClientes.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        transportista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(), "Registro Detallado", Toast.LENGTH_SHORT).show();
                if(ValidarCampos()==true){

                    Intent intent = new Intent(getApplicationContext(), RegistroTransportista.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }



    //Metodo para validar los Campos

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
        }
        if (validadorDeCedula(ced)==false){
            cedula.setError("Cedula Incorrecta");
            retorno =false;
        }
        if (nom.isEmpty()){
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


    //Metodo para validar que la cédula sea ecuatoriana
    public boolean validadorDeCedula(String ced) {
        boolean cedulaCorrecta=true;
        int aux;
        try {
            if (cedula.length() == 10){
                int tercerDigito = Integer.parseInt(ced.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(ced.substring(9,10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (ced.length() - 1); i++){
                        digito = Integer.parseInt(ced.substring(i, i + 1))* coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    }
                    else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                        aux=1;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            Toast.makeText(getApplicationContext(),"Una excepcion ocurrio en el proceso de validadcion", Toast.LENGTH_SHORT).show();
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            Toast.makeText(getApplicationContext(),"La Cédula ingresada es Incorrecta", Toast.LENGTH_SHORT).show();
        }
        return cedulaCorrecta;
    }

    public void onclick(View view) {
        cargarImagen();

    }

    //Metodo para cargar Imagen
    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),10);

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            Uri pathlocal = data.getData();
            img.setImageURI(pathlocal);
        }
    }



}
