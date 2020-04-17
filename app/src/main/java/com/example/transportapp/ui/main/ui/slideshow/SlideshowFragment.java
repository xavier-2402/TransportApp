package com.example.transportapp.ui.main.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.transportapp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SlideshowFragment extends Fragment {

    private List<Trans>listaPerson=new ArrayList<Trans>();
    ArrayAdapter<Trans> arrayAdapterPersona;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListView lv_datosPersonas;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);

        lv_datosPersonas= lv_datosPersonas.findViewById(R.id.lv_datosPersonas);
        iniciarFirabase();
        listarDatos();

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void iniciarFirabase() {
        FirebaseApp.initializeApp(this.getContext());
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

    }

    private void listarDatos() {
        Trans t=new Trans();
        t.setConductor_id(UUID.randomUUID().toString());
        t.setNombre_trans("Tebo");
        t.setTarifa_trans("345$");
        t.setMatricula_vehi("TTT-111");
        databaseReference.child("Transportista").child(t.getConductor_id()).setValue(t);

        databaseReference.child("Transportista").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPerson.clear();
                for(DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Trans p=objSnaptshot.getValue(Trans.class);
                    listaPerson.add(p);

                    arrayAdapterPersona=new ArrayAdapter<Trans>(SlideshowFragment.this.getContext(),android.R.layout.simple_list_item_1,listaPerson);
                    lv_datosPersonas.setAdapter(arrayAdapterPersona);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
