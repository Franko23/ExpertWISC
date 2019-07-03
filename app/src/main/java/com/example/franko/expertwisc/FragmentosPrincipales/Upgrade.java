package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Splash;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Upgrade.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Upgrade#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Upgrade extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FirebaseFirestore dbFire = FirebaseFirestore.getInstance();

    ConexionHelper con;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Boolean free;
    private OnFragmentInteractionListener mListener;
    View view;
    private Button verificar;

    public Upgrade() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Upgrade.
     */
    // TODO: Rename and change types and number of parameters
    public static Upgrade newInstance(String param1, String param2) {
        Upgrade fragment = new Upgrade();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        con = new ConexionHelper(getContext(), "bd_wisc", null, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upgrade, container, false);



        verificar = view.findViewById(R.id.verificar);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbFire.collection("usuarios")
                        .whereEqualTo("usuario", Utilidades.currentUser)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                        free = document.getBoolean("free");
                                    }
                                    if (!free){
//                                        Snackbar.make(view, "Res = " + free, Snackbar.LENGTH_LONG).show();

                                        actualizarUsuario();

                                        new AlertDialog.Builder(getContext())
                                                .setTitle("Felicidades, ahora ya tienes lo siguiente:")
                                                .setMessage("1.Registrar pacientes ilimitadamente." + "\n" +
                                                        "2. Crear test ilimitadamente para los pacientes." + "\n" +
                                                        "3. Subir los datos de pacientes y test a la nube." + "\n" +
                                                        "4. Visualización del panel 'Sugerencias'.")
                                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        restart();
                                                    }
                                                }).show();
                                    }else{
                                        new AlertDialog.Builder(getContext())
                                                .setTitle("Actualización fallida!")
                                                .setMessage("Lo sentimos, aún no está la disponible la versión mejorada para ti.")
                                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Log.d("MainActivity", "Sending atomic bombs to Jupiter");
                                                    }
                                                }).show();
                                    }
                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());

                                }
                            }
                        });
            }
        });



        return view;
    }

    private void actualizarUsuario() {
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues usuarioUpdate = new ContentValues();

        usuarioUpdate.put(Utilidades.CAMPO_FREE_USUARIO, free);

        try{
            db.update(Utilidades.TABLA_USUARIO,usuarioUpdate,Utilidades.CAMPO_ID_USUARIO+" = "+Utilidades.currentUserIdUsuario,null);

        }catch (Exception e){
            Toast.makeText(getContext(),"Error al actualizar Datos del paciente", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void restart(){
        Intent intent = new Intent(getContext(), Splash.class);
        this.startActivity(intent);
        getActivity().finishAffinity();
    }
}
