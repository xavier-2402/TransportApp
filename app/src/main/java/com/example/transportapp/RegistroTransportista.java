package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroTransportista extends AppCompatActivity {

    private EditText nombre;
    private EditText matricula;
    private EditText placa;
    private EditText color;
    private Spinner marca;
    private Spinner tipo;
    private Spinner anio;
    private Button registrar;
    private Button anadirVehiculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_transportista);
        matricula=findViewById(R.id.txtMatricula);
        placa=findViewById(R.id.txtPlaca);
        // color=rootView.findViewById(R.id.cbcolor);
        anio=findViewById(R.id.cbanio);
        tipo=findViewById(R.id.cbtipo);
        marca=findViewById(R.id.cbmarca);
        anadirVehiculo=findViewById(R.id.btnAñadirVechiculo);
        anadirVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidarCampos()==true){
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                    matricula.setText("");
                    placa.setText("");
                }
            }
        });

        registrar=findViewById(R.id.btnRegistrarTransportista);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidarCampos()==true){
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Loguin.class);
                    startActivity(intent);

                }
            }
        });
    }

    public boolean ValidarCampos(){
        boolean retorno=true;
        String matri=matricula.getText().toString();
        String pla=placa.getText().toString();


        if (matri.isEmpty()){
            matricula.setError("Campo vacio");
            retorno =false;
        }if (pla.isEmpty()){
            placa.setError("Campo vacio");
            retorno =false;
        }

        return retorno;
    }

}
