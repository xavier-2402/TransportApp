package com.example.transportapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.transportapp.ui.main.ui.slideshow.Trans;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Selected extends AppCompatActivity {

    private List<Trans> listaPerson = new ArrayList<Trans>();
    private ArrayAdapter<Trans> arrayAdapterPersona;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListView lv_datosPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);
        lv_datosPersonas = (ListView) findViewById(R.id.listachofer);
        iniciarFirabase();
        listarDatos();


    }

    private void iniciarFirabase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    private void listarDatos() {
        /*Trans t=new Trans();
        t.setConductor_id(UUID.randomUUID().toString());
        t.setNombre_trans("Tebo");
        t.setTarifa_trans("4564$");
        t.setMatricula_vehi("AAA-345");
        databaseReference.child("Transportista").child(t.getConductor_id()).setValue(t);
*/

        databaseReference.child("Transportista").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPerson.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()) {
                    Trans p = objSnaptshot.getValue(Trans.class);
                    listaPerson.add(p);

                    arrayAdapterPersona = new ArrayAdapter<Trans>(Selected.this, android.R.layout.simple_list_item_1, listaPerson);
                    lv_datosPersonas.setAdapter(arrayAdapterPersona);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void solicitar(View view) {
        Intent intent = new Intent(getApplicationContext(), SolicitudServicio.class);
        startActivity(intent);
        finish();

    }
}
