package com.example.transportapp.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.transportapp.Loguin;
import com.example.transportapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Clientes extends Fragment {
    private EditText titulartarjeta;
    private EditText numTarjeta;
    private EditText fecha;
    private EditText codSeguridad;
    private Button registrar;


    public Clientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_clientes, container, false);
        titulartarjeta= rootView.findViewById(R.id.txtTitulartarjeta);
        numTarjeta=rootView.findViewById(R.id.txtNumtarjeta);
        fecha=rootView.findViewById(R.id.txtFechaTarjeta);
        codSeguridad=rootView.findViewById(R.id.txtCodigotarjeta);
        registrar=rootView.findViewById(R.id.btnRegistrarCliente);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarCampos();
                Intent intent = new Intent(getActivity().getApplication(), Loguin.class);
                startActivity(intent);
            }
        });
        return inflater.inflate(R.layout.fragment_clientes, container, false);
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
