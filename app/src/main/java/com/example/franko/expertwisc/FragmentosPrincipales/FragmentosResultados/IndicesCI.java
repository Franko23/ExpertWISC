package com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Tools.PuntuacionCI;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IndicesCI.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IndicesCI#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndicesCI extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView result_icv, result_irp, result_imo, result_ivp, result_cit,
            result_icv_compuesto, result_irp_compuesto, result_imo_compuesto, result_ivp_compuesto, result_cit_compuesto,
            result_icv_percentil, result_irp_percentil, result_imo_percentil, result_ivp_percentil, result_cit_percentil,
            result_icv_intervalo, result_irp_intervalo, result_imo_intervalo, result_ivp_intervalo, result_cit_intervalo;
    View view;

    private OnFragmentInteractionListener mListener;

    public IndicesCI() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndicesCI.
     */
    // TODO: Rename and change types and number of parameters
    public static IndicesCI newInstance(String param1, String param2) {
        IndicesCI fragment = new IndicesCI();
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
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//
//        getActivity().setRequestedOrientation(
//                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        view = inflater.inflate(R.layout.fragment_indices_ci, container, false);

        result_icv = view.findViewById(R.id.result_icv);
        result_icv_compuesto = view.findViewById(R.id.result_icv_compuesto);
        result_icv_percentil = view.findViewById(R.id.result_icv_percentil);
        result_icv_intervalo = view.findViewById(R.id.result_icv_intervalo);
        result_irp = view.findViewById(R.id.result_irp);
        result_irp_compuesto = view.findViewById(R.id.result_irp_compuesto);
        result_irp_percentil = view.findViewById(R.id.result_irp_percentil);
        result_irp_intervalo = view.findViewById(R.id.result_irp_intervalo);
        result_imo = view.findViewById(R.id.result_imo);
        result_imo_compuesto = view.findViewById(R.id.result_imo_compuesto);
        result_imo_percentil = view.findViewById(R.id.result_imo_percentil);
        result_imo_intervalo = view.findViewById(R.id.result_imo_intervalo);
        result_ivp = view.findViewById(R.id.result_ivp);
        result_ivp_compuesto = view.findViewById(R.id.result_ivp_compuesto);
        result_ivp_percentil = view.findViewById(R.id.result_ivp_percentil);
        result_ivp_intervalo = view.findViewById(R.id.result_ivp_intervalo);
        result_cit = view.findViewById(R.id.result_cit);
        result_cit_compuesto = view.findViewById(R.id.result_cit_compuesto);
        result_cit_percentil = view.findViewById(R.id.result_cit_percentil);
        result_cit_intervalo = view.findViewById(R.id.result_cit_intervalo);


        PuntuacionCI puntuacionCI = new PuntuacionCI();

        List<String> list = new ArrayList<>();
        List<String> listCompuestas = new ArrayList<>();

        result_icv.setText(Utilidades.icv);
        list = puntuacionCI.PuntoCI(getContext(),Utilidades.icv, "ICV");
        result_icv_compuesto.setText(list.get(0));
        listCompuestas.add(list.get(0));
        result_icv_percentil.setText(list.get(1));
        result_icv_intervalo.setText(list.get(2));

        result_irp.setText(Utilidades.irp);
        list = puntuacionCI.PuntoCI(getContext(),Utilidades.irp, "IRP");
        result_irp_compuesto.setText(list.get(0));
        listCompuestas.add(list.get(0));
        result_irp_percentil.setText(list.get(1));
        result_irp_intervalo.setText(list.get(2));

        result_imo.setText(Utilidades.imo);
        list = puntuacionCI.PuntoCI(getContext(),Utilidades.imo, "IMO");
        result_imo_compuesto.setText(list.get(0));
        listCompuestas.add(list.get(0));
        result_imo_percentil.setText(list.get(1));
        result_imo_intervalo.setText(list.get(2));

        result_ivp.setText(Utilidades.ivp);
        list = puntuacionCI.PuntoCI(getContext(),Utilidades.ivp, "IVP");
        result_ivp_compuesto.setText(list.get(0));
        listCompuestas.add(list.get(0));
        result_ivp_percentil.setText(list.get(1));
        result_ivp_intervalo.setText(list.get(2));

        result_cit.setText(Utilidades.cit);
        list = puntuacionCI.PuntoCI(getContext(),Utilidades.cit, "CIT");
        result_cit_compuesto.setText(list.get(0));
        listCompuestas.add(list.get(0));
        result_cit_percentil.setText(list.get(1));
        result_cit_intervalo.setText(list.get(2));

        Utilidades.listResultCompuesta = listCompuestas;

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
