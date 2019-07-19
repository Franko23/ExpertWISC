package com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.franko.expertwisc.ExpertSystem.Aprendizaje;
import com.example.franko.expertwisc.ExpertSystem.MotorInferencia;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Tools.CalcularEdad;
import com.example.franko.expertwisc.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Sugerencias.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Sugerencias#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sugerencias extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    View view;
    TextView nombre, motivo, antecedentes, puntuaciones, cit, intervalo, sugerencias, conclusiones;
    String resPuntuaciones="", signal=", ";
    String[] grupo = {"ICV", "IRP", "IMO", "IVP"};
    Button guardar;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Sugerencias() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sugerencias.
     */
    // TODO: Rename and change types and number of parameters
    public static Sugerencias newInstance(String param1, String param2) {
        Sugerencias fragment = new Sugerencias();
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
        view = inflater.inflate(R.layout.fragment_sugerencias, container, false);

        nombre = view.findViewById(R.id.nombre);
        motivo = view.findViewById(R.id.motivo);
        antecedentes = view.findViewById(R.id.antecedentes);
        puntuaciones = view.findViewById(R.id.puntuaciones);
        cit = view.findViewById(R.id.cit);
        intervalo = view.findViewById(R.id.intervalo);
        conclusiones = view.findViewById(R.id.conclusiones);
        sugerencias = view.findViewById(R.id.sugerencias);

        guardar = view.findViewById(R.id.aceptar);

        //Setteamos la vista con las respuestas
        CalcularEdad calcularEdad = new CalcularEdad(Utilidades.fechaNacimiento,Utilidades.fechaEvaluacion);
        String edadFinal = calcularEdad.CalcularEdad();

        String [] nAge = edadFinal.split(" ");
        String edad= nAge[0];

        //Ejecución del Sistema Experto mediante el motor de inferencia
        MotorInferencia motor = new MotorInferencia();
        motor.getResultado(edad,grupo, getContext());

        nombre.setText(Utilidades.currentPacienteName +", "+ edadFinal);
        if (Utilidades.motivo.equals("")){
            motivo.setText("Sin motivo para esta evaluación.");
        }else {
            motivo.setText(Utilidades.motivo);
        }
        if (Utilidades.antecedentes.equals("")){
            antecedentes.setText("Sin antecedentes para esta evaluación.");
        }else {
            antecedentes.setText(Utilidades.antecedentes);
        }

        for (int i = 0; i<Utilidades.listResultCompuesta.size()-1; i++){
            if (i==Utilidades.listResultCompuesta.size()-2){
                signal = ".";
            }
            resPuntuaciones += grupo[i]+": "+Utilidades.listResultCompuesta.get(i)+signal;
        }
        puntuaciones.setText(resPuntuaciones);
        cit.setText(Utilidades.cit);
        intervalo.setText(Utilidades.intervalo_confianza + "%");
        conclusiones.setText(Utilidades.Conclusiones);
        sugerencias.setText(Utilidades.Sugerencias);


        sugerencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
                View mView = layoutInflaterAndroid.inflate(R.layout.input, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext());
                alertDialogBuilderUserInput.setView(mView);

                final EditText input = mView.findViewById(R.id.key);
                input.setText(Utilidades.Sugerencias_key);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Listo", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                Utilidades.Sugerencias_key = input.getText().toString();
                            }
                        })

                        .setNegativeButton("Cancelar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });
        conclusiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
                View mView = layoutInflaterAndroid.inflate(R.layout.input, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext());
                alertDialogBuilderUserInput.setView(mView);

                final EditText input = mView.findViewById(R.id.key);
                input.setText(Utilidades.Conclusiones_key);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Listo", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                Utilidades.Conclusiones_key = input.getText().toString();
                            }
                        })

                        .setNegativeButton("Cancelar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });


        //Almacenamos nueva información
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                Aprendizaje aprendizaje = new Aprendizaje();
                                aprendizaje.insertDataBase(edad, motivo.getText().toString(), antecedentes.getText().toString(), grupo, getContext());
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Se almacenará un nuevo registro").setPositiveButton("Si", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });

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
