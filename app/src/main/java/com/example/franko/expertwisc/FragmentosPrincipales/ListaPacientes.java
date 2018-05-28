package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.franko.expertwisc.Adapters.AdapterPacientes;
import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

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

    ArrayList<String> listaInformacion;

    ArrayList<Paciente> listaPacientes;
    RecyclerView recyclerViewPacientes;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_lista_pacientes, container, false);

        con = new ConexionHelper(getContext(), "bd_wisc", null, 1);

//        lista = vista.findViewById(R.id.listaPacientes);

        consultarListaPacientes();
        recyclerViewPacientes = vista.findViewById(R.id.listaPacientes);
        recyclerViewPacientes.setLayoutManager(new LinearLayoutManager(getContext()));

        AdapterPacientes adapterPacientes = new AdapterPacientes(listaPacientes);

        adapterPacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment =  new DatosPaciente();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                Paciente paciente = new Paciente();
                paciente.setNombres(listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getNombres());
                paciente.setApellidos(listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getApellidos());
                paciente.setImagen(listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getImagen());

                Bundle bundle = new Bundle();
                bundle.putSerializable("paciente",paciente);

                fragment.setArguments(bundle);

                transaction.replace(R.id.content_main, fragment);
                transaction.addToBackStack(null);


                // Commit the transaction
                transaction.commit();

                Toast.makeText(getContext(),"Id: "+listaPacientes.get(recyclerViewPacientes.getChildAdapterPosition(v)).getId(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerViewPacientes.setAdapter(adapterPacientes);

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
        Paciente paciente = null;

        listaPacientes = new ArrayList<>();

        //SELECT * FROM PACIENTES
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PACIENTE,null);

        while (cursor.moveToNext()) {

            paciente = new Paciente();

            paciente.setId(cursor.getInt(0));
            paciente.setNombres(cursor.getString(1));
            paciente.setApellidos(cursor.getString(2));
            paciente.setEdad(cursor.getString(5));
            paciente.setImagen(cursor.getBlob(6));

            listaPacientes.add(paciente);
        }

        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        for (int i = 0; i<listaPacientes.size();i++){
            listaInformacion.add(listaPacientes.get(i).getNombres()+ "  "+listaPacientes.get(i).getApellidos()+ " "+listaPacientes.get(i).getEdad()+" "+listaPacientes.get(i).getImagen());
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
