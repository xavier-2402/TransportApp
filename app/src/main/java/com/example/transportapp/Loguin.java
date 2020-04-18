package com.example.transportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.transportapp.ui.main.ui.slideshow.Trans;
import com.example.transportapp.ui.main.ui.slideshow.Usuarios;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Loguin extends AppCompatActivity {
    private EditText usuario;
    private EditText contrasenia;
    private Button ingresar;
    private Button registrar;
    String mensaje = "";
    String mensaje2 = "";
    ArrayAdapter<Usuarios> arrayAdapterPersona;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Usuarios usuValidar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);

        usuario = findViewById(R.id.txtUsuario);
        contrasenia = findViewById(R.id.txtContraseña);
        ingresar = findViewById(R.id.btnIngresar);
        registrar = findViewById(R.id.btnRegistro);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menuIntegrado();
                ValidarCampos();


            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Registro General", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void iniciarFirabase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }


    public boolean ValidarCampos() {
        boolean retorno = true;

        String us = usuario.getText().toString();
        String con = contrasenia.getText().toString();

        if (us.isEmpty()) {
            usuario.setError("Campo vacio");
            retorno = false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(us).matches()) {
            usuario.setError("Correo invalido");
            retorno = false;
        }
        if (con.isEmpty()) {
            contrasenia.setError("Campo vacio");
            retorno = false;
        }
        if (!us.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(us).matches()) {
            Intent intent = new Intent(getApplicationContext(), InformacionFinal.class);
            startActivity(intent);
            finish();
            retorno= true ;
        }
        return retorno;
    }



    public void ValidarUsuarioContrasenia() {
        String sql = "http://10.0.2.2:8090/personas";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = null;
        HttpURLConnection conn;


        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            String json = "";
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();
            JSONArray jsonArr = null;
            jsonArr = new JSONArray(json);

            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                JSONObject jsonObject2 = jsonArr.getJSONObject(i);
                mensaje = jsonObject.getString("contraseña");
                mensaje2 = jsonObject2.getString("usuario");
                if (mensaje.equals(contrasenia.getText().toString()) && mensaje2.equals(usuario.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    usuario.setText("");
                    contrasenia.setText("");
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void menuIntegrado() {
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
        finish();
    }

}
