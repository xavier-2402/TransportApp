package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroClientes extends AppCompatActivity {
    private EditText titulartarjeta;
    private EditText numTarjeta;
    private EditText fecha;
    private EditText codSeguridad;
    private Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clientes);
        titulartarjeta= findViewById(R.id.txtTitulartarjeta);
        numTarjeta=findViewById(R.id.txtNumtarjeta);
        fecha=findViewById(R.id.txtFechaTarjeta);
        codSeguridad=findViewById(R.id.txtCodigotarjeta);
        registrar=findViewById(R.id.btnRegistrarCliente);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidarCampos()==true){
                    Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Loguin.class);
                    startActivity(intent);
                }

            }
        });

    }
    public boolean ValidarCampos(){
        boolean retorno=true;
        String titu=titulartarjeta.getText().toString();
        String num=numTarjeta.getText().toString();
        String fe=fecha.getText().toString();
        String cod=codSeguridad.getText().toString();
        if (titu.isEmpty()){
            titulartarjeta.setError("Campo vacio");
            retorno =false;
        }if (num.isEmpty()){
            numTarjeta.setError("Campo vacio");
            retorno =false;
        }if (fe.isEmpty()){
            fecha.setError("Campo vacio");
            retorno =false;
        }if (cod.isEmpty()){
            codSeguridad.setError("Campo vacio");
            retorno =false;
        }

        return retorno;
    }
}
