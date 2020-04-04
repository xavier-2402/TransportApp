package com.example.transportapp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.transportapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Transportista extends Fragment {

    public Transportista() {
        // Required empty public constructor
    }

    private EditText nombre;
    private EditText matricula;
    private EditText placa;
    private EditText color;
    private EditText modelo;
    private EditText marca;
    private EditText tipo;
    private EditText anio;
    private Button registrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_transportista, container, false);
        nombre=rootView.findViewById(R.id.txtNombrePV);
        matricula=rootView.findViewById(R.id.txtMatricula);
        placa=rootView.findViewById(R.id.txtPlaca);
        color=rootView.findViewById(R.id.txtColor);
        modelo=rootView.findViewById(R.id.txtModelo);
        marca=rootView.findViewById(R.id.txtMarca);
        tipo=rootView.findViewById(R.id.txtTipo);
        anio=rootView.findViewById(R.id.txtAnio);
        registrar=rootView.findViewById(R.id.btnRegistrarTransportista);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarCampos();
            }
        });
        return inflater.inflate(R.layout.fragment_transportista, container, false);
    }

    public boolean ValidarCampos(){
        boolean retorno=true;
        String matri=matricula.getText().toString();
        String nom=nombre.getText().toString();
        String pla=placa.getText().toString();
        String co=color.getText().toString();
        String mo=modelo.getText().toString();
        String ma=marca.getText().toString();
        String ti=tipo.getText().toString();
        String an=anio.getText().toString();
        if (matri.isEmpty()){
            matricula.setError("Campo vacio");
            retorno =false;
        }if (nom.isEmpty()){
            nombre.setError("Campo vacio");
            retorno =false;
        }if (pla.isEmpty()){
            placa.setError("Campo vacio");
            retorno =false;
        }if (co.isEmpty()){
            color.setError("Campo vacio");
            retorno =false;
        }if (mo.isEmpty()){
            modelo.setError("Campo vacio");
            retorno =false;
        }if (ma.isEmpty()){
            marca.setError("Campo vacio");
            retorno =false;
        }if (ti.isEmpty()){
            tipo.setError("Campo vacio");
            retorno =false;
        }if (an.isEmpty()){
            anio.setError("Campo vacio");
            retorno =false;
        }

        return retorno;
    }

}
