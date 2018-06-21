package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Datos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Datos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Datos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="FireDatos";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ConexionHelper con;
    View view;
    ListView list_up;
    TextView text_up;
    Button btn_up;
    ArrayAdapter<String> adapter;
    Boolean up=false;
    FirebaseFirestore dbFire = FirebaseFirestore.getInstance();
    private OnFragmentInteractionListener mListener;

    public Datos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Datos.
     */
    // TODO: Rename and change types and number of parameters
    public static Datos newInstance(String param1, String param2) {
        Datos fragment = new Datos();
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
        con = new ConexionHelper(getContext(),"bd_wisc", null, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_datos, container, false);

        list_up = view.findViewById(R.id.list_up);
        btn_up = view.findViewById(R.id.btn_up);
        text_up = view.findViewById(R.id.text_up);

        consultarPacientes(up);


        if(!adapter.isEmpty()){
            list_up.setAdapter(adapter);
            text_up.setVisibility(View.GONE);
        }else{
            list_up.setVisibility(View.GONE);
            btn_up.setVisibility(View.GONE);
            text_up.setVisibility(View.VISIBLE);
        }

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean internet = isOnline();

                if (internet==true){
                    up=true;
                consultarPacientes(up);
                    up=false;
                    Fragment fragment = new Datos();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
                    Snackbar.make(view, "Datos Subidos", Snackbar.LENGTH_LONG)
                            .setActionTextColor(Color.CYAN)
                            .setAction("OK", null).show();
                }else{
                    Snackbar.make(view, "No hay conexión a internet", Snackbar.LENGTH_LONG)
                            .setActionTextColor(Color.CYAN)
                            .setAction("OK", null).show();
                }
            }
        });


        return view;
    }

    private Boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        return info != null && info.isAvailable() && info.isConnected();

    }

    private void consultarPacientes(Boolean up) {
        SQLiteDatabase db = con.getReadableDatabase();
        Persona persona;
        Paciente paciente;
        List<Paciente> listaIdPersona = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM paciente WHERE up_paciente = 'NO'",null);
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                paciente = new Paciente();
                paciente.setId_paciente(cursor.getInt(0));
                paciente.setMotivoConsulta_paciente(cursor.getString(1));
                paciente.setAntecedentes_paciente(cursor.getString(2));
                paciente.setUp_paciente(cursor.getString(3));
                paciente.setId_persona(cursor.getInt(4));
                paciente.setId_usuario(cursor.getInt(5));
                if (up==true){
                    subirPaciente(paciente);
                }
                listaIdPersona.add(paciente);
            }
        }
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        for (int i = 0; i<listaIdPersona.size(); i++){
            cursor = db.rawQuery("SELECT * FROM persona WHERE id_persona="+listaIdPersona.get(i).getId_persona().toString(),null);
            while (cursor.moveToNext()){
                persona = new Persona();
                persona.setId_persona(cursor.getInt(0));
                persona.setNombre_persona(cursor.getString(1));
                persona.setApellido_persona(cursor.getString(2));
                persona.setFecha_nacimiento_persona(cursor.getString(3));;
                persona.setImagen_persona(cursor.getBlob(4));
                persona.setTipo_persona(cursor.getString(5));
                if (up==true){
                    subirPersona(persona);
                }else {
                    adapter.add(persona.getNombre_persona()+" "+persona.getApellido_persona());
                }
            }

        }

        db.close();
    }

    private void subirPersona(Persona persona) {
        Map<String, Object> newPersona = new HashMap<>();

        newPersona.put("id_persona",persona.getId_persona());
        newPersona.put("nombre_persona",persona.getNombre_persona());
        newPersona.put("apellido_persona",persona.getApellido_persona());
        newPersona.put("fecha_nacimiento_persona",persona.getFecha_nacimiento_persona());
        newPersona.put("imagen_persona",String.valueOf(persona.getImagen_persona()));
        newPersona.put("tipo_persona",persona.getTipo_persona());

        dbFire.collection("persona")
                .add(newPersona)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Persona agregada correctamente: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error agregando persona", e);
                    }
                });
    }

    private void subirPaciente(Paciente paciente) {
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_UP_PACIENTE, "SI");
        db.update(Utilidades.TABLA_PACIENTE,values,Utilidades.CAMPO_ID_PACIENTE+"="+paciente.getId_paciente(),null);
        paciente.setUp_paciente("SI");

        Map<String, Object> newPaciente = new HashMap<>();
        newPaciente.put("id_paciente",paciente.getId_paciente());
        newPaciente.put("motivo_consulta_paciente",paciente.getMotivoConsulta_paciente());
        newPaciente.put("antecedentes_paciente",paciente.getAntecedentes_paciente());
        newPaciente.put("up_paciente",paciente.getUp_paciente());
        newPaciente.put("id_persona",paciente.getId_persona());
        newPaciente.put("id_usuario",paciente.getId_usuario());

        dbFire.collection("paciente")
                .add(newPaciente)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Paciente agregado correctamente: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error agregando paciente", e);
                    }
                });



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
}
