package com.example.transportapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroTransportista extends AppCompatActivity {

    private EditText matricula;
    private EditText placa;
    private Spinner color;
    private Spinner marca;
    private Spinner tipo;
    private Spinner anio;
    private Button registrar;
    private Button anadirVehiculo;
    private Button cargar;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_transportista);
        matricula=findViewById(R.id.txtMatricula);
        placa=findViewById(R.id.txtPlaca);
        color=findViewById(R.id.cbcolor);
        anio=findViewById(R.id.cbanio);
        tipo=findViewById(R.id.cbtipo);
        marca=findViewById(R.id.cbmarca);
        cargar = findViewById(R.id.cargar);
        img = findViewById(R.id.imagen);
        cargarCombos();
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
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagen();
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
    public  void cargarCombos(){
        ArrayAdapter<CharSequence> adaptercolor = ArrayAdapter.createFromResource(this,R.array.color,android.R.layout.simple_spinner_item);
        ArrayAdapter <CharSequence> adapteranio = ArrayAdapter.createFromResource(this,R.array.anio,android.R.layout.simple_spinner_item);
        ArrayAdapter <CharSequence> adaptermarca = ArrayAdapter.createFromResource(this,R.array.marca,android.R.layout.simple_spinner_item);
        ArrayAdapter <CharSequence> adaptertipo = ArrayAdapter.createFromResource(this,R.array.tipo,android.R.layout.simple_spinner_item);

        color.setAdapter(adaptercolor);
        anio.setAdapter(adapteranio);
        tipo.setAdapter(adaptertipo);
        marca.setAdapter(adaptermarca);
    }

    //Metodos para cargar Imagen
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
