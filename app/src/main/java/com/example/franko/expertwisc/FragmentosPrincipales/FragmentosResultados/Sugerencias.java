package com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.expertwisc.Adapters.AdapterSugerencias;
import com.example.franko.expertwisc.ExpertSystem.SistemaExperto;
import com.example.franko.expertwisc.FragmentosSubTest.S;
import com.example.franko.expertwisc.FragmentosSubTest.V;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;

import io.grpc.okhttp.internal.Util;

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
    RecyclerView recyclerViewSugerenciaTest;
    View view;
    TextView txt_sugerencia, iq;
    String area;
    int count=0;
    String[] grupo = {"ICV", "IRP", "IMO", "IVP"};
    ArrayList<String> resultado, result;
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

        txt_sugerencia = view.findViewById(R.id.txt_sugerencia);
        iq = view.findViewById(R.id.result_iq);

        iq.setText(""+Utilidades.listResultCompuesta.get(4));

        //Invocación al Sistema Experto
        SistemaExperto sistemaExperto = new SistemaExperto();
        resultado = new ArrayList<>();
        result = new ArrayList<>();
        for (int i=0; i < 4; i++){
            if (Integer.parseInt(Utilidades.listResultCompuesta.get(i))<100){
                resultado.add(sistemaExperto.getResultado(Utilidades.edadActual,grupo[i]));
                result.add(grupo[i]);
                count++;
            }
        }

        //Ordenamos los srting de resultados de áreas a ser mostradas
        if (result.size()>1){
            if (result.size()==2){
                area = result.get(0)+" y "+result.get(1);
            }
            if (result.size()==3){
                area = result.get(0)+","+result.get(1)+" y "+result.get(2);
            }
            if (result.size()==4){
                area = result.get(0)+", "+result.get(1)+", "+result.get(2)+" y "+result.get(3);
            }
        }else if(result.size()==1){
            area = result.get(0);
        }


        recyclerViewSugerenciaTest = view.findViewById(R.id.rec_test);
        recyclerViewSugerenciaTest.setLayoutManager(new LinearLayoutManager(getContext()));

        Utilidades.LEE = getString(R.string.LEE);
        Utilidades.PROLEC = getString(R.string.PROLEC);
        Utilidades.BENDER = getString(R.string.BENDER);
        Utilidades.TEPSI = getString(R.string.TEPSI);
        Utilidades.PRECALCULO = getString(R.string.PreCalculo);
        Utilidades.PROCALCULO = getString(R.string.ProCalculo);
        Utilidades.RAVEN_G = getString(R.string.Raven_G);


        if (count>0){
           AdapterSugerencias adapterSugerencias = new AdapterSugerencias(resultado);
            recyclerViewSugerenciaTest.setAdapter(adapterSugerencias);
            txt_sugerencia.setText("Estimado "+Utilidades.currentUserName+", hemos notado que "+
                    Utilidades.currentPacienteName+
                    " tiene algunas dificultades en "+
                    area+
                    ", por lo tanto te recomendamos aplicar las siguientes pruebas:");
        }else
        {
            txt_sugerencia.setText("Estimado "+Utilidades.currentUserName+", hemos notado que "+
                    Utilidades.currentPacienteName+" NO tiene dificultades significativas en el " +
                    "test realizado. Pero aún así puedes fortalecer todas las áreas en las que sobresale.");
        }



//
//        adapterSugerencias.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = recyclerViewSugerenciaTest.getChildAdapterPosition(view);
//            }
//        });







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
