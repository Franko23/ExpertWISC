package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.franko.expertwisc.Adapters.AdapterPacientes;
import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaPacientes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaPacientes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPacientes extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    View vista;

    ArrayList<Paciente> listaPacientes;
    ArrayList<Persona> listaPersonas;
    RecyclerView recyclerViewPacientes;
    TextView txt_mensaje_lista_paciente;

    ConexionHelper con;

    public ListaPacientes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPacientes.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPacientes newInstance(String param1, String param2) {
        ListaPacientes fragment = new ListaPacientes();
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
        vista = inflater.inflate(R.layout.flp, container, false);
        txt_mensaje_lista_paciente = vista.findViewById(R.id.txt_mensaje_lista_paciente);

        consultarListaPacientes();

        //Mostramos el FloatIconButton de Nuevo Paciente


        recyclerViewPacientes = vista.findViewById(R.id.listaPacientes);
        recyclerViewPacientes.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterPacientes adapterPacientes = new AdapterPacientes(listaPersonas,listaPacientes);

        if (listaPersonas.isEmpty()){
            txt_mensaje_lista_paciente.setVisibility(View.VISIBLE);
        }

        adapterPacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Persona persona = new Persona();
                persona.setId_persona(listaPersonas.get(recyclerViewPacientes.getChildAdapterPosition(v)).getId_persona());
                persona.setNombre_persona(listaPersonas.get(recyclerViewPacientes.getChildAdapterPosition(v)).getNombre_persona());
                persona.setApellido_persona(listaPersonas.get(recyclerViewPacientes.getChildAdapterPosition(v)).getApellido_persona());
                persona.setFecha_nacimiento_persona(listaPersonas.get(recyclerViewPacientes.getChildAdapterPosition(v)).getFecha_nacimiento_persona());
                persona.setImagen_persona(listaPersonas.get(recyclerViewPacientes.getChildAdapterPosition(v)).getImagen_persona());
                persona.setUp_persona(listaPersonas.get(recyclerViewPacientes.getChildAdapterPosition(v)).getUp_persona());

                Paciente paciente = new Paciente();
                paciente.setId_paciente(listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getId_paciente());
                paciente.setMotivoConsulta_paciente(listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getMotivoConsulta_paciente());
                paciente.setAntecedentes_paciente(listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getAntecedentes_paciente());

                //Creamos un BundleMaster
                Bundle bundleMaster = new Bundle();

                //Serializamos los Datos del paciente en bundlePaciente
                Bundle bundlePaciente = new Bundle();
                bundlePaciente.putSerializable("paciente",paciente);

                Utilidades.currentPacienteName = persona.getNombre_persona();

                //Serializamos los Datos de la persona en bundlePersona
                Bundle bundlePersona = new Bundle();
                bundlePersona.putSerializable("persona",persona);


                bundleMaster.putBundle("Paciente",bundlePaciente);
                bundleMaster.putBundle("Persona",bundlePersona);

                Fragment fragment =  new DatosPaciente();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
                fragment.setArguments(bundleMaster);
//
                transaction.replace(R.id.content_main, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

                View view = vista.getRootView();
                FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);
                floatingActionButton.hide();

//                Toast.makeText(getContext(),"Id: "+listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getId_persona(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerViewPacientes.setAdapter(adapterPacientes);

//        View view = vista.getRootView();
//        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);
//        floatingActionButton.hide();

        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private void consultarListaPacientes() {
        SQLiteDatabase db = con.getReadableDatabase();

        Paciente paciente;
        Persona persona;

        listaPacientes = new ArrayList<>();
        listaPersonas = new ArrayList<>();

        //SELECT * FROM PACIENTES
        Cursor pac = db.rawQuery("SELECT * FROM paciente WHERE id_usuario"+"="+Utilidades.currentUserIdUsuario,null);

        while (pac.moveToNext()){
            paciente = new Paciente();
            paciente.setId_paciente(pac.getInt(0));
            paciente.setMotivoConsulta_paciente(pac.getString(1));
            paciente.setAntecedentes_paciente(pac.getString(2));
            paciente.setId_persona(pac.getInt(3));

            Test test = new Test();
            test.consultarTablaTest(paciente.getId_paciente(), getContext());
            if (Utilidades.TestUp>0){
                paciente.setUp_paciente("NO");
            }else {
                paciente.setUp_paciente("SI");
            }

            listaPacientes.add(paciente);
        }

        for (int i = 0; i < listaPacientes.size(); i++) {

//            int id_persona = ;
            Cursor cursor = db.rawQuery("SELECT * FROM persona WHERE id_persona"+"="+listaPacientes.get(i).getId_persona(),null);
            while (cursor.moveToNext()) {

                persona = new Persona();

                persona.setId_persona(cursor.getInt(0));
                persona.setNombre_persona(cursor.getString(1));
                persona.setApellido_persona(cursor.getString(2));
                persona.setFecha_nacimiento_persona(cursor.getString(3));
                persona.setImagen_persona(cursor.getBlob(4));
                persona.setUp_persona(cursor.getString(5));

                listaPersonas.add(persona);
            }
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
