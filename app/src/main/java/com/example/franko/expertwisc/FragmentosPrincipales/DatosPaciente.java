package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Adapters.ListViewAdapter;
import com.example.franko.expertwisc.Entidades.Paciente;
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
    ArrayList<Paciente> listaPacientes;
    SwitchCompat switchCompat = null;
    View view;
    CircleImageView imgDatospaciente;
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;
    TextView  nombrePrincipal;
    Button btn_guardar;
    ListView listView;
    ListViewAdapter listViewAdapter;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_datos_paciente, container, false);

        imgDatospaciente = view.findViewById(R.id.imgDatospaciente);
        switchCompat = view.findViewById(R.id.swicth_profile);
        nombrePrincipal = view.findViewById(R.id.nombrePrincipal);
        editText1 = view.findViewById(R.id.EditUno);
        editText2 = view.findViewById(R.id.EditDos);
        editText3 = view.findViewById(R.id.EditTres);
        editText4 = view.findViewById(R.id.EditCuatro);
        editText5 = view.findViewById(R.id.EditCinco);
        editText6 = view.findViewById(R.id.EditSeis);
        editText7 = view.findViewById(R.id.EditSiete);
        editText8 = view.findViewById(R.id.EditOcho);
        btn_guardar = view.findViewById(R.id.btn_guardar);
        listView = view.findViewById(R.id.listv_pruebas);


        String[] items={"1","2","3","4","5"};
        listViewAdapter =new ListViewAdapter(getContext(),R.layout.list_item,R.id.fecha_prueba,items);
        // Cargamos los datos al ListView
        listView.setAdapter(listViewAdapter);


        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchCompat.isChecked()){
                    editText1.setEnabled(true);
                    editText2.setEnabled(true);
                    editText3.setEnabled(true);
                    editText4.setEnabled(true);
                    editText5.setEnabled(true);
                    editText6.setEnabled(true);
                    editText7.setEnabled(true);
                    editText8.setEnabled(true);
                    btn_guardar.setVisibility(View.VISIBLE);
                }else{
                    editText1.setEnabled(false);
                    editText2.setEnabled(false);
                    editText3.setEnabled(false);
                    editText4.setEnabled(false);
                    editText5.setEnabled(false);
                    editText6.setEnabled(false);
                    editText7.setEnabled(false);
                    editText8.setEnabled(false);
                    btn_guardar.setVisibility(View.GONE);
                }
            }
        });

        bundle = getArguments();

        Paciente paciente = null;

        if (bundle!= null){
            paciente = (Paciente) bundle.getSerializable("paciente");
            nombrePrincipal.setText(paciente.getNombres().toString()+" "+paciente.getApellidos().toString());
            editText1.setText(paciente.getNombres().toString());
            editText2.setText(paciente.getApellidos().toString());
            byte[] image = paciente.getImagen();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
            imgDatospaciente.setImageBitmap(bitmap);
        }

        return view;
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
