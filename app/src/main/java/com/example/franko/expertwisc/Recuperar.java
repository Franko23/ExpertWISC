package com.example.franko.expertwisc;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Usuario;
import com.example.franko.expertwisc.FragmentosSubTest.I;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Recuperar extends AppCompatActivity {
    private static final String TAG = "Mensaje";
    String e,p;
    FirebaseFirestore dbFire = FirebaseFirestore.getInstance();
    Boolean existe = false;
    Button verificar;
    EditText email, password;
    ImageView checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        verificar = findViewById(R.id.verificar);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        checked = findViewById(R.id.checked);

        // Create a reference to the cities collection
        CollectionReference citiesRef = dbFire.collection("usuari");

// Create a query against the collection.
        Query query = citiesRef.whereEqualTo("nombre_usuario", "fran");


        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                dbFire.collection("usuarios")
//                        .whereEqualTo("usuario",email.getText().toString())
//                        .whereEqualTo("contraseña",password.getText().toString())
//                        .get()
//                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
//                            @Override
//                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                if (task.isSuccessful()){
//                                    for (QueryDocumentSnapshot document : task.getResult()){
//                                        Log.d(TAG, document.getId() + " => " + document.getData() +  "=>" + document.getData().values());
//                                        existe = true;
//                                        e = document.getString("usuario");
//                                        p = document.getString("contraseña");
//                                    }
//                                    if (existe){
//                                        checked.setVisibility(View.VISIBLE);
//                                        verificar.setVisibility(View.INVISIBLE);
//                                    }else {
//                                        verificar.setText("Error");
//                                        verificar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                                    }
//
//                                } else {
//                                    Log.d(TAG, "Error getting documents: ", task.getException());
//
//                                }
//                            }
//                        });


                DocumentReference docRef = dbFire.collection("usuarios").document("fran").collection("pacientes").document();
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getMetadata());
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });

            }
        });

    }
}
