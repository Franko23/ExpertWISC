package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.franko.expertwisc.Adapters.AdapterTest;
import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DatosPaciente.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DatosPaciente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatosPaciente extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Bundle bundle;
    ArrayList<Test> listaTest;
    SwitchCompat switchCompat = null;
    View view;
    CircleImageView imgDatospaciente;
    EditText editNombres, editApellidos, editEdad, editMotivo, editAntecedentes;
    TextView  nombrePrincipal, txt_mensaje_test;
    Button btn_guardar;
    ListView listView;
    AdapterTest adapterTest;
    ConexionHelper con;

    RecyclerView recyclerViewTest;

    private OnFragmentInteractionListener mListener;

    public DatosPaciente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatosPaciente.
     */
    // TODO: Rename and change types and number of parameters
    public static DatosPaciente newInstance(String param1, String param2) {
        DatosPaciente fragment = new DatosPaciente();
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
        view = inflater.inflate(R.layout.fragment_datos_paciente, container, false);

        imgDatospaciente = view.findViewById(R.id.imgDatospaciente);
        switchCompat = view.findViewById(R.id.swicth_profile);
        nombrePrincipal = view.findViewById(R.id.nombrePrincipal);
        editNombres = view.findViewById(R.id.EditNombres);
        editApellidos= view.findViewById(R.id.EditApellido);
        editEdad = view.findViewById(R.id.EditEdad);
        editMotivo = view.findViewById(R.id.EditMotivo);
        editAntecedentes = view.findViewById(R.id.EditAntecedentes);

        btn_guardar = view.findViewById(R.id.btn_guardar);
//        listView = view.findViewById(R.id.listv_pruebas);
        txt_mensaje_test = view.findViewById(R.id.txt_mensaje_test);


        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchCompat.isChecked()){
                    editNombres.setEnabled(true);
                    editApellidos.setEnabled(true);
                    editEdad.setEnabled(true);
                    editMotivo.setEnabled(true);
                    editAntecedentes.setEnabled(true);

                    btn_guardar.setVisibility(View.VISIBLE);
                }else{
                    editNombres.setEnabled(false);
                    editApellidos.setEnabled(false);
                    editEdad.setEnabled(false);
                    editMotivo.setEnabled(false);
                    editAntecedentes.setEnabled(false);

                    btn_guardar.setVisibility(View.GONE);
                }
            }
        });

        bundle = getArguments();

        Paciente paciente = null;
        Persona persona = null;

        if (bundle!= null){

            paciente = (Paciente) bundle.getBundle("Paciente").getSerializable("paciente");
            persona = (Persona) bundle.getBundle("Persona").getSerializable("persona");

            nombrePrincipal.setText(persona.getNombre_persona() + " "+persona.getApellido_persona());

            editNombres.setText(persona.getNombre_persona());
            editApellidos.setText(persona.getApellido_persona());
            editEdad.setText(persona.getEdad_persona());
            byte[] image = persona.getImagen_persona();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
            imgDatospaciente.setImageBitmap(bitmap);
            editMotivo.setText(paciente.getMotivoConsulta_paciente());
            editAntecedentes.setText(paciente.getAntecedentes_paciente());
        }

        recyclerViewTest = view.findViewById(R.id.recv_pruebas);
        recyclerViewTest.setLayoutManager(new LinearLayoutManager(getContext()));
        //Enviamos fecha de prueba y el estado
        //Consultamos desde la tabla test la fecha y el estado de acuerdo al id paciente
        Test test = new Test();
        listaTest = consultarTablaTest(paciente.getId_paciente());

        if (listaTest.isEmpty()){
            recyclerViewTest.setVisibility(View.INVISIBLE);
        }else{
            txt_mensaje_test.setVisibility(View.GONE);
//            adapterTest =new AdapterTest(getContext(),R.layout.list_test,listaTest);

            AdapterTest adapterTest = new AdapterTest(listaTest);
            // Cargamos los datos al ListView

            recyclerViewTest.setAdapter(adapterTest);
//            listView.setAdapter(adapterTest);
        }

        return view;
    }

    private ArrayList<Test> consultarTablaTest(Integer id_paciente) {
        SQLiteDatabase db = con.getReadableDatabase();
        Test test = null;
        listaTest = new ArrayList<>();


        Cursor cursor = db.rawQuery("SELECT * FROM test WHERE id_paciente"+"="+id_paciente,null);

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                test = new Test();

                test.setId_test(cursor.getInt(0));
                test.setFecha_test(cursor.getString(1));
                test.setEvaluador_test(cursor.getString(2));
                test.setEstado_test(cursor.getString(3));

                listaTest.add(test);
            }
        }

        return listaTest;
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
