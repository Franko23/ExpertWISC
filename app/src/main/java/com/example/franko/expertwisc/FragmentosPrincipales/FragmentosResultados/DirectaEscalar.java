package com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
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

    String[] sbt = {"cc","s","rd","co","cl","v","ln","m","c","bs","cf","a","i","ar","ad"};

    List<String> values;
    List<Integer> icv, irp, imo, ivp, cit;

    TextView puntos_cc, puntos_s, puntos_rd, puntos_co, puntos_cl, puntos_v, puntos_ln, puntos_m, puntos_c, puntos_bs, puntos_cf, puntos_a, puntos_i, puntos_ar, puntos_ad,
            puntos_cc_e, puntos_s_e, puntos_rd_e, puntos_co_e, puntos_cl_e, puntos_v_e, puntos_ln_e, puntos_m_e, puntos_c_e, puntos_bs_e, puntos_cf_e, puntos_a_e, puntos_i_e, puntos_ar_e, puntos_ad_e,
            result_cc_final, result_s_final,result_rd_final, result_co_final, result_cl_final, result_v_final, result_ln_final, result_m_final, result_c_final, result_bs_final, result_cf_final, result_a_final, result_i_final, result_ar_final, result_ad_final,
           result_icv, result_irp, result_imo, result_ivp, result_cit;
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

        //Puntos E
        puntos_cc_e = view.findViewById(R.id.puntos_cc_e);
        puntos_s_e = view.findViewById(R.id.puntos_s_e);
        puntos_rd_e = view.findViewById(R.id.puntos_rd_e);
        puntos_co_e = view.findViewById(R.id.puntos_co_e);
        puntos_cl_e = view.findViewById(R.id.puntos_cl_e);
        puntos_v_e = view.findViewById(R.id.puntos_v_e);
        puntos_ln_e = view.findViewById(R.id.puntos_ln_e);
        puntos_m_e = view.findViewById(R.id.puntos_m_e);
        puntos_c_e = view.findViewById(R.id.puntos_c_e);
        puntos_bs_e = view.findViewById(R.id.puntos_bs_e);
        puntos_cf_e = view.findViewById(R.id.puntos_cf_e);
        puntos_a_e = view.findViewById(R.id.puntos_a_e);
        puntos_i_e = view.findViewById(R.id.puntos_i_e);
        puntos_ar_e = view.findViewById(R.id.puntos_ar_e);
        puntos_ad_e = view.findViewById(R.id.puntos_ad_e);

        //Puntos Final
        result_cc_final = view.findViewById(R.id.result_cc_final);
        result_s_final = view.findViewById(R.id.result_s_final);
        result_rd_final = view.findViewById(R.id.result_rd_final);
        result_co_final = view.findViewById(R.id.result_co_final);
        result_cl_final = view.findViewById(R.id.result_cl_final);
        result_v_final = view.findViewById(R.id.result_v_final);
        result_ln_final = view.findViewById(R.id.result_ln_final);
        result_m_final = view.findViewById(R.id.result_m_final);
        result_c_final = view.findViewById(R.id.result_c_final);
        result_bs_final = view.findViewById(R.id.result_bs_final);
        result_cf_final = view.findViewById(R.id.result_cf_final);
        result_a_final = view.findViewById(R.id.result_a_final);
        result_i_final = view.findViewById(R.id.result_i_final);
        result_ar_final = view.findViewById(R.id.result_ar_final);
        result_ad_final = view.findViewById(R.id.result_ad_final);

        //Puntos Sumativa
        result_icv = view.findViewById(R.id.result_icv);
        result_irp = view.findViewById(R.id.result_irp);
        result_imo = view.findViewById(R.id.result_imo);
        result_ivp = view.findViewById(R.id.result_ivp);
        result_cit = view.findViewById(R.id.result_cit);

        //Setteamos los puntos desde Utilidades
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
        puntos_cf.setText(Utilidades.R_cf);
        puntos_a.setText(Utilidades.R_a);
        puntos_i.setText(Utilidades.R_i);
        puntos_ar.setText(Utilidades.R_ar);
        puntos_ad.setText(Utilidades.R_ad);

        List<String> values0 = new ArrayList<>();

        values0.add(Utilidades.R_cc);
        values0.add(Utilidades.R_s);
        values0.add(Utilidades.R_rd);
        values0.add(Utilidades.R_co);
        values0.add(Utilidades.R_cl);
        values0.add(Utilidades.R_v);
        values0.add(Utilidades.R_ln);
        values0.add(Utilidades.R_m);
        values0.add(Utilidades.R_c);
        values0.add(Utilidades.R_bs);
        values0.add(Utilidades.R_cf);
        values0.add(Utilidades.R_a);
        values0.add(Utilidades.R_i);
        values0.add(Utilidades.R_ar);
        values0.add(Utilidades.R_ad);

        PuntuacionEscalar puntuacionEscalar = new PuntuacionEscalar();
        values = puntuacionEscalar.Punto(getContext(), values0);

        Utilidades.listResultEscalar = values;

            icv = new ArrayList<>();
            irp = new ArrayList<>();
            imo = new ArrayList<>();
            ivp = new ArrayList<>();
            cit = new ArrayList<>();

        setResult();


        int ResICV =0 ;
        for (int i=0; i<icv.size();i++){
            ResICV = ResICV + icv.get(i);
        }
        result_icv.setText(""+ResICV);
        Utilidades.icv = ""+ResICV;

        int ResIRP =0 ;
        for (int i=0; i<irp.size();i++){
            ResIRP = ResIRP + irp.get(i);
        }
        result_irp.setText(""+ResIRP);
        Utilidades.irp = ""+ResIRP;


        int ResIMO =0 ;
        for (int i=0; i<imo.size();i++){
            ResIMO = ResIMO + imo.get(i);
        }
        result_imo.setText(""+ResIMO);
        Utilidades.imo = ""+ResIMO;


        int ResIVP =0 ;
        for (int i=0; i<ivp.size();i++){
            ResIVP = ResIVP + ivp.get(i);
        }
        result_ivp.setText(""+ResIVP);
        Utilidades.ivp = ""+ResIVP;

        int ResCIT =0 ;
        for (int i=0; i<cit.size();i++){
            ResCIT = ResCIT + cit.get(i);
        }
        result_cit.setText(""+ResCIT);
        Utilidades.cit= ""+ResCIT;


        return view;
    }

    private void setResult() {
        //Setteamos en los TextView de cada respuesta
        //ICV 2,6,9,13, 15
        //IRP 1,4,8,11
        //IMO 3,7,14
        //IPV 5,10,12
        if (values.get(0).equals("0")||values.get(0).contains("r")){
            if (values.get(0).contains("r")){
                puntos_cc_e.setText(values.get(0));
                puntos_cc_e.setTextColor(Color.WHITE);
                puntos_cc_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_cc_final.setText(values.get(0));
                result_cc_final.setTextColor(Color.WHITE);
                result_cc_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_cc_e.setText("");
                result_cc_final.setText("");
            }

        }else{
            puntos_cc_e.setText(values.get(0));
            result_cc_final.setText(values.get(0));
            irp.add(Integer.parseInt(values.get(0))); //IRP
            cit.add(Integer.parseInt(values.get(0))); //CIT
        }
        if (values.get(1).equals("0")||values.get(1).contains("r")){
            if (values.get(1).contains("r")){
                puntos_s_e.setText(values.get(1));
                puntos_s_e.setTextColor(Color.WHITE);
                puntos_s_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_s_final.setText(values.get(1));
                result_s_final.setTextColor(Color.WHITE);
                result_s_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_s_e.setText("");
                result_s_final.setText("");
            }
        }else{
            puntos_s_e.setText(values.get(1));
            result_s_final.setText(values.get(1));
            icv.add(Integer.parseInt(values.get(1))); //ICV
            cit.add(Integer.parseInt(values.get(1))); //CIT
        }
        if (values.get(2).equals("0")||values.get(2).contains("r")){
            if (values.get(2).contains("r")){
                puntos_rd_e.setText(values.get(2));
                puntos_rd_e.setTextColor(Color.WHITE);
                puntos_rd_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_rd_final.setText(values.get(2));
                result_rd_final.setTextColor(Color.WHITE);
                result_rd_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_rd_e.setText("");
                result_rd_final.setText("");
            }
        }else{
            puntos_rd_e.setText(values.get(2));
            result_rd_final.setText(values.get(2));
            imo.add(Integer.parseInt(values.get(2))); //IMO
            cit.add(Integer.parseInt(values.get(2))); //CIT
        }
        if (values.get(3).equals("0")||values.get(3).contains("r")){
            if (values.get(3).contains("r")){
                puntos_co_e.setText(values.get(3));
                puntos_co_e.setTextColor(Color.WHITE);
                puntos_co_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_co_final.setText(values.get(3));
                result_co_final.setTextColor(Color.WHITE);
                result_co_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_co_e.setText("");
                result_co_final.setText("");
            }
        }else{
            puntos_co_e.setText(values.get(3));
            result_co_final.setText(values.get(3));
            irp.add(Integer.parseInt(values.get(3))); //IRP
            cit.add(Integer.parseInt(values.get(3))); //CIT
        }
        if (values.get(4).equals("0")||values.get(4).contains("r")){
            if (values.get(4).contains("r")){
                puntos_cl_e.setText(values.get(4));
                puntos_cl_e.setTextColor(Color.WHITE);
                puntos_cl_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_cl_final.setText(values.get(4));
                result_cl_final.setTextColor(Color.WHITE);
                result_cl_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_cl_e.setText("");
                result_cl_final.setText("");
            }
        }else{
            puntos_cl_e.setText(values.get(4));
            result_cl_final.setText(values.get(4));
            ivp.add(Integer.parseInt(values.get(4))); //IVP
            cit.add(Integer.parseInt(values.get(4))); //CIT
        }
        if (values.get(5).equals("0")||values.get(5).contains("r")){
            if (values.get(5).contains("r")){
                puntos_v_e.setText(values.get(5));
                puntos_v_e.setTextColor(Color.WHITE);
                puntos_v_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_v_final.setText(values.get(5));
                result_v_final.setTextColor(Color.WHITE);
                result_v_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_v_e.setText("");
                result_v_final.setText("");
            }
        }else{
            puntos_v_e.setText(values.get(5));
            result_v_final.setText(values.get(5));
            icv.add(Integer.parseInt(values.get(5))); //ICV
            cit.add(Integer.parseInt(values.get(5))); //CIT
        }
        if (values.get(6).equals("0")||values.get(6).contains("r")){
            if (values.get(6).contains("r")){
                puntos_ln_e.setText(values.get(6));
                puntos_ln_e.setTextColor(Color.WHITE);
                puntos_ln_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_ln_final.setText(values.get(6));
                result_ln_final.setTextColor(Color.WHITE);
                result_ln_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_ln_e.setText("");
                result_ln_final.setText("");
            }
        }else{
            puntos_ln_e.setText(values.get(6));
            result_ln_final.setText(values.get(6));
            imo.add(Integer.parseInt(values.get(6))); //IMO
            cit.add(Integer.parseInt(values.get(6))); //CIT
        }
        if (values.get(7).equals("0")||values.get(7).contains("r")){
            if (values.get(7).contains("r")){
                puntos_m_e.setText(values.get(7));
                puntos_m_e.setTextColor(Color.WHITE);
                puntos_m_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_m_final.setText(values.get(7));
                result_m_final.setTextColor(Color.WHITE);
                result_m_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_m_e.setText("");
                result_m_final.setText("");
            }
        }else{
            puntos_m_e.setText(values.get(7));
            result_m_final.setText(values.get(7));
            irp.add(Integer.parseInt(values.get(7))); //IRP
            cit.add(Integer.parseInt(values.get(7))); //CIT
        }
        if (values.get(8).equals("0")||values.get(8).contains("r")){
            if (values.get(8).contains("r")){
                puntos_c_e.setText(values.get(8));
                puntos_c_e.setTextColor(Color.WHITE);
                puntos_c_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_c_final.setText(values.get(8));
                result_c_final.setTextColor(Color.WHITE);
                result_c_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_c_e.setText("");
                result_c_final.setText("");
            }
        }else{
            puntos_c_e.setText(values.get(8));
            result_c_final.setText(values.get(8));
            icv.add(Integer.parseInt(values.get(8))); //ICV
            cit.add(Integer.parseInt(values.get(8))); //CIT
        }
        if (values.get(9).equals("0")||values.get(9).contains("r")){
            if (values.get(9).contains("r")){
                puntos_bs_e.setText(values.get(9));
                puntos_bs_e.setTextColor(Color.WHITE);
                puntos_bs_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_bs_final.setText(values.get(9));
                result_bs_final.setTextColor(Color.WHITE);
                result_bs_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_bs_e.setText("");
                result_bs_final.setText("");
            }
        }else{
            puntos_bs_e.setText(values.get(9));
            result_bs_final.setText(values.get(9));
            ivp.add(Integer.parseInt(values.get(9))); //IVP
            cit.add(Integer.parseInt(values.get(9))); //CIT
        }
        if (values.get(10).equals("0")||values.get(10).contains("r")){
            if (values.get(10).contains("r")){
                puntos_cf_e.setText(values.get(10));
                puntos_cf_e.setTextColor(Color.WHITE);
                puntos_cf_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_cf_final.setText(values.get(10));
                result_cf_final.setTextColor(Color.WHITE);
                result_cf_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_cf_e.setText("");
                result_cf_final.setText("");
            }
        }else{
            puntos_cf_e.setText(values.get(10));
            result_cf_final.setText(values.get(10));
            irp.add(Integer.parseInt(values.get(10))); //IRP
            cit.add(Integer.parseInt(values.get(10))); //CIT
        }
        if (values.get(11).equals("0")||values.get(11).contains("r")){
            if (values.get(11).contains("r")){
                puntos_a_e.setText(values.get(11));
                puntos_a_e.setTextColor(Color.WHITE);
                puntos_a_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_a_final.setText(values.get(11));
                result_a_final.setTextColor(Color.WHITE);
                result_a_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_a_e.setText("");
                result_a_final.setText("");
            }
        }else{
            puntos_a_e.setText(values.get(11));
            result_a_final.setText(values.get(11));
            ivp.add(Integer.parseInt(values.get(11))); //IVP
            cit.add(Integer.parseInt(values.get(11))); //CIT
        }
        if (values.get(12).equals("0")||values.get(12).contains("r")){
            if (values.get(12).contains("r")){
                puntos_i_e.setText(values.get(12));
                puntos_i_e.setTextColor(Color.WHITE);
                puntos_i_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_i_final.setText(values.get(12));
                result_i_final.setTextColor(Color.WHITE);
                result_i_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_i_e.setText("");
                result_i_final.setText("");
            }
        }else{
            puntos_i_e.setText(values.get(12));
            result_i_final.setText(values.get(12));
            icv.add(Integer.parseInt(values.get(12))); //ICV
            cit.add(Integer.parseInt(values.get(12))); //CIT
        }
        if (values.get(13).equals("0")||values.get(13).contains("r")){
            if (values.get(13).contains("r")){
                puntos_ar_e.setText(values.get(13));
                puntos_ar_e.setTextColor(Color.WHITE);
                puntos_ar_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_ar_final.setText(values.get(13));
                result_ar_final.setTextColor(Color.WHITE);
                result_ar_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_ar_e.setText("");
                result_ar_final.setText("");
            }
        }else{
            puntos_ar_e.setText(values.get(13));
            result_ar_final.setText(values.get(13));
            imo.add(Integer.parseInt(values.get(13))); //IMO
            cit.add(Integer.parseInt(values.get(13))); //CIT
        }
        if (values.get(14).equals("0")||values.get(14).contains("r")){
            if (values.get(14).contains("r")){
                puntos_ad_e.setText(values.get(14));
                puntos_ad_e.setTextColor(Color.WHITE);
                puntos_ad_e.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
                result_ad_final.setText(values.get(14));
                result_ad_final.setTextColor(Color.WHITE);
                result_ad_final.setBackgroundColor(getResources().getColor(R.color.colorInProgress));
            }else{
                puntos_ad_e.setText("");
                result_ad_final.setText("");
            }
        }else{
            puntos_ad_e.setText(values.get(14));
            result_ad_final.setText(values.get(14));
            icv.add(Integer.parseInt(values.get(14))); //ICV
            cit.add(Integer.parseInt(values.get(14))); //CIT
        }
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
