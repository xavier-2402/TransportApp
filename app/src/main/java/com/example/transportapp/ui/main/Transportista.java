package com.example.transportapp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.Spinner;

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
    private Spinner marca;
    private Spinner tipo;
    private Spinner anio;
    private Button registrar;
    ArrayAdapter<CharSequence> adapter;
//https://www.androfast.com/2017/11/todo-sobre-como-usar-el-controlador.html
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_transportista, container, false);
        matricula=rootView.findViewById(R.id.txtMatricula);
        placa=rootView.findViewById(R.id.txtPlaca);
        color=rootView.findViewById(R.id.cbcolor);
        anio=rootView.findViewById(R.id.cbanio);
        tipo=rootView.findViewById(R.id.cbtipo);
        marca=rootView.findViewById(R.id.cbmarca);
       adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
       //color.setAdapter(adapter);

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
