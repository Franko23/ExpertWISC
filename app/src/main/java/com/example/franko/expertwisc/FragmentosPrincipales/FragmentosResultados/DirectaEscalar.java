package com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Tools.PuntuacionEscalar;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DirectaEscalar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DirectaEscalar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DirectaEscalar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView puntos_cc, puntos_s, puntos_rd, puntos_co, puntos_cl, puntos_v, puntos_ln, puntos_m, puntos_c, puntos_bs, puntos_cf, puntos_a, puntos_i, puntos_ar, puntos_ad;
    View view;

    private OnFragmentInteractionListener mListener;

    public DirectaEscalar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DirectaEscalar.
     */
    // TODO: Rename and change types and number of parameters
    public static DirectaEscalar newInstance(String param1, String param2) {
        DirectaEscalar fragment = new DirectaEscalar();
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
        view = inflater.inflate(R.layout.fragment_directa_escalar, container, false);

        puntos_cc = view.findViewById(R.id.puntos_cc);
        puntos_s = view.findViewById(R.id.puntos_s);
        puntos_rd = view.findViewById(R.id.puntos_rd);
        puntos_co = view.findViewById(R.id.puntos_co);
        puntos_cl = view.findViewById(R.id.puntos_cl);
        puntos_v = view.findViewById(R.id.puntos_v);
        puntos_ln = view.findViewById(R.id.puntos_ln);
        puntos_m = view.findViewById(R.id.puntos_m);
        puntos_c = view.findViewById(R.id.puntos_c);
        puntos_bs = view.findViewById(R.id.puntos_bs);
        puntos_cf = view.findViewById(R.id.puntos_cf);
        puntos_a = view.findViewById(R.id.puntos_a);
        puntos_i = view.findViewById(R.id.puntos_i);
        puntos_ar = view.findViewById(R.id.puntos_ar);
        puntos_ad = view.findViewById(R.id.puntos_ad);


        puntos_cc.setText(Utilidades.R_cc);
        puntos_s.setText(Utilidades.R_s);
        puntos_rd.setText(Utilidades.R_rd);
        puntos_co.setText(Utilidades.R_co);
        puntos_cl.setText(Utilidades.R_cl);
        puntos_v.setText(Utilidades.R_v);
        puntos_ln.setText(Utilidades.R_ln);
        puntos_m.setText(Utilidades.R_m);
        puntos_c.setText(Utilidades.R_c);
        puntos_bs.setText(Utilidades.R_bs);

        if (!Utilidades.R_cf.equals("Sin valor")){
            puntos_cf.setText(Utilidades.R_cf);
        }
        if (!Utilidades.R_a.equals("Sin valor")){
            puntos_a.setText(Utilidades.R_a);
        }
        if (!Utilidades.R_i.equals("Sin valor")){
            puntos_i.setText(Utilidades.R_i);
        }
        if (!Utilidades.R_ar.equals("Sin valor")){
            puntos_ar.setText(Utilidades.R_ar);
        }
        if (!Utilidades.R_ad.equals("Sin valor")){
            puntos_ad.setText(Utilidades.R_ad);
        }

        List<String> values = new ArrayList<>();
        values.add(Utilidades.R_cc);
        values.add(Utilidades.R_s);
        values.add(Utilidades.R_rd);
        values.add(Utilidades.R_co);
        values.add(Utilidades.R_cl);
        values.add(Utilidades.R_v);
        values.add(Utilidades.R_ln);
        values.add(Utilidades.R_m);
        values.add(Utilidades.R_c);
        values.add(Utilidades.R_bs);
        values.add(Utilidades.R_cf);
        values.add(Utilidades.R_a);
        values.add(Utilidades.R_i);
        values.add(Utilidades.R_ar);
        values.add(Utilidades.R_ad);

        PuntuacionEscalar puntuacionEscalar = new PuntuacionEscalar();
        values = puntuacionEscalar.Punto(getContext(), values);

        //Seteamos en los TextView de cada respuesta


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
