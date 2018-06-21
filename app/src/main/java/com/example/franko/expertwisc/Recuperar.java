package com.example.franko.expertwisc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Usuario;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Recuperar extends AppCompatActivity {
    FirebaseFirestore dbFire = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        // Create a reference to the cities collection
        CollectionReference citiesRef = dbFire.collection("usuari");

// Create a query against the collection.
        Query query = citiesRef.whereEqualTo("nombre_usuario", "fran");


    }
}
