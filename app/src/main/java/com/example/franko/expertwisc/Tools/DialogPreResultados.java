package com.example.franko.expertwisc.Tools;

import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
import com.example.franko.expertwisc.FragmentosPrincipales.RegistroPaciente;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class DialogPreResultados extends DialogFragment{
    ConexionHelper con;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        con = new ConexionHelper(getContext(), "bd_wisc", null, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View alertLayout = inflater.inflate(R.layout.layout_pre_resultados, container, false);

        final TextView mensaje = alertLayout.findViewById(R.id.txt_mensaje);

        final TextView result_cc = alertLayout.findViewById(R.id.result_cc);
        final TextView result_s = alertLayout.findViewById(R.id.result_s);
        final TextView result_rd = alertLayout.findViewById(R.id.result_rd);
        final TextView result_co = alertLayout.findViewById(R.id.result_co);
        final TextView result_cl = alertLayout.findViewById(R.id.result_cl);
        final TextView result_v= alertLayout.findViewById(R.id.result_v);
        final TextView result_ln = alertLayout.findViewById(R.id.result_ln);
        final TextView result_m = alertLayout.findViewById(R.id.result_m);
        final TextView result_c = alertLayout.findViewById(R.id.result_c);
        final TextView result_bs = alertLayout.findViewById(R.id.result_bs);
//        final TextView result_cf = alertLayout.findViewById(R.id.result_cf);
//        final TextView result_a = alertLayout.findViewById(R.id.result_a);
//        final TextView result_i = alertLayout.findViewById(R.id.result_i);
//        final TextView result_ar = alertLayout.findViewById(R.id.result_ar);
//        final TextView result_ad = alertLayout.findViewById(R.id.result_ad);

        final Button si = alertLayout.findViewById(R.id.btn_si);
        final Button no = alertLayout.findViewById(R.id.btn_no);

        result_cc.setText(Utilidades.R_cc);
        result_s.setText(Utilidades.R_s);
        result_rd.setText(Utilidades.R_rd);
        result_co.setText(Utilidades.R_co);
        result_cl.setText(Utilidades.R_cl);
        result_v.setText(Utilidades.R_v);
        result_ln.setText(Utilidades.R_ln);
        result_m.setText(Utilidades.R_m);
        result_c.setText(Utilidades.R_c);
        result_bs.setText(Utilidades.R_bs);
//        result_cf.setText(Utilidades.R_cf);
//        result_a.setText(Utilidades.R_a);
//        result_i.setText(Utilidades.R_i);
//        result_ar.setText(Utilidades.R_ar);
//        result_ad.setText(Utilidades.R_ad);


        if (Utilidades.R_cc.equals("Sin valor")){
            result_cc.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_s.equals("Sin valor")){
            result_s.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_rd.equals("Sin valor")){
            result_rd.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_co.equals("Sin valor")){
            result_co.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_cl.equals("Sin valor")){
            result_cl.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_v.equals("Sin valor")){
            result_v.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_ln.equals("Sin valor")){
            result_ln.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_m.equals("Sin valor")){
            result_m.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_c.equals("Sin valor")){
            result_c.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        if (Utilidades.R_bs.equals("Sin valor")){
            result_bs.setTextColor(getResources().getColor(R.color.colorAccent));
        }
//        if (Utilidades.R_cf.equals("Sin valor")){
//            result_cf.setTextColor(getResources().getColor(R.color.colorAccent));
//        }
//        if (Utilidades.R_a.equals("Sin valor")){
//            result_a.setTextColor(getResources().getColor(R.color.colorAccent));
//        }
//        if (Utilidades.R_i.equals("Sin valor")){
//            result_i.setTextColor(getResources().getColor(R.color.colorAccent));
//        }
//        if (Utilidades.R_ar.equals("Sin valor")){
//            result_ar.setTextColor(getResources().getColor(R.color.colorAccent));
//        }
//        if (Utilidades.R_ad.equals("Sin valor")){
//            result_ad.setTextColor(getResources().getColor(R.color.colorAccent));
//        }

        if (
            Utilidades.R_cc.equals("Sin valor") ||
            Utilidades.R_s.equals("Sin valor") ||
            Utilidades.R_rd.equals("Sin valor") ||
            Utilidades.R_co.equals("Sin valor") ||
            Utilidades.R_cl.equals("Sin valor") ||
            Utilidades.R_v.equals("Sin valor") ||
            Utilidades.R_ln.equals("Sin valor") ||
            Utilidades.R_m.equals("Sin valor") ||
            Utilidades.R_c.equals("Sin valor") ||
            Utilidades.R_bs.equals("Sin valor")
//            Utilidades.R_cf.equals("Sin valor") &&
//            Utilidades.R_a.equals("Sin valor") &&
//            Utilidades.R_i.equals("Sin valor") &&
//            Utilidades.R_ar.equals("Sin valor") &&
//            Utilidades.R_ad.equals("Sin valor")
                ){
            mensaje.setText(getResources().getString(R.string.mensajeCompletar));
            mensaje.setTextColor(getResources().getColor(R.color.colorAccent));
            no.setVisibility(View.GONE);
            si.setVisibility(View.GONE);
        }else{
            mensaje.setText(getResources().getString(R.string.mensajeContinuar));
        }


        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Almacenamos en la base de datos los 10 primeros resultados
                RegistrarPuntos();
            }
        });

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Utilidades.pages=5;
                Utilidades.disable=false;
                android.support.v4.app.Fragment fragment = new GeneralSubPruebas();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();

            }
        });

        return alertLayout;
    }

    private void RegistrarPuntos() {
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues cc = new ContentValues();
        ContentValues s = new ContentValues();
        ContentValues rd = new ContentValues();
        ContentValues co = new ContentValues();
        ContentValues cl = new ContentValues();
        ContentValues v = new ContentValues();
        ContentValues ln = new ContentValues();
        ContentValues m = new ContentValues();
        ContentValues c = new ContentValues();
        ContentValues bs = new ContentValues();
        ContentValues cf = new ContentValues();
        ContentValues a = new ContentValues();
        ContentValues i = new ContentValues();
        ContentValues ar = new ContentValues();
        ContentValues ad = new ContentValues();

        cc.put(Utilidades.CAMPO_CC,Utilidades.R_cc);
        cc.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        s.put(Utilidades.CAMPO_S,Utilidades.R_s);
        s.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        rd.put(Utilidades.CAMPO_RDT,Utilidades.R_rd);
        rd.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        co.put(Utilidades.CAMPO_CO,Utilidades.R_co);
        co.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        cl.put(Utilidades.CAMPO_CL,Utilidades.R_cl);
        cl.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        v.put(Utilidades.CAMPO_V,Utilidades.R_v);
        v.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        ln.put(Utilidades.CAMPO_LN,Utilidades.R_ln);
        ln.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        s.put(Utilidades.CAMPO_S,Utilidades.R_s);
        s.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        m.put(Utilidades.CAMPO_M,Utilidades.R_m);
        m.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        c.put(Utilidades.CAMPO_C,Utilidades.R_c);
        c.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        bs.put(Utilidades.CAMPO_BS,Utilidades.R_bs);
        bs.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        cf.put(Utilidades.CAMPO_CF,Utilidades.R_cf);
        cf.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        a.put(Utilidades.CAMPO_A,Utilidades.R_a);
        a.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        i.put(Utilidades.CAMPO_I,Utilidades.R_i);
        i.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        ar.put(Utilidades.CAMPO_AR,Utilidades.R_ar);
        ar.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        ad.put(Utilidades.CAMPO_AD,Utilidades.R_ad);
        ad.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try{
            Long id_CC = db.insert(Utilidades.TABLA_PUNTUACIONES_CC, Utilidades.CAMPO_ID_PUNTUACION_CC, cc);
            Long id_S = db.insert(Utilidades.TABLA_PUNTUACIONES_S, Utilidades.CAMPO_ID_PUNTUACION_S, s);
            Long id_RD = db.insert(Utilidades.TABLA_PUNTUACIONES_RD, Utilidades.CAMPO_ID_PUNTUACION_RD, rd);
            Long id_Co = db.insert(Utilidades.TABLA_PUNTUACIONES_CO, Utilidades.CAMPO_ID_PUNTUACION_CO, co);
            Long id_Cl = db.insert(Utilidades.TABLA_PUNTUACIONES_CL, Utilidades.CAMPO_ID_PUNTUACION_CL, cl);
            Long id_V = db.insert(Utilidades.TABLA_PUNTUACIONES_V, Utilidades.CAMPO_ID_PUNTUACION_V, v);
            Long id_LN = db.insert(Utilidades.TABLA_PUNTUACIONES_LN, Utilidades.CAMPO_ID_PUNTUACION_LN, ln);
            Long id_M = db.insert(Utilidades.TABLA_PUNTUACIONES_M, Utilidades.CAMPO_ID_PUNTUACION_M, m);
            Long id_C = db.insert(Utilidades.TABLA_PUNTUACIONES_C, Utilidades.CAMPO_ID_PUNTUACION_C, c);
            Long id_BS = db.insert(Utilidades.TABLA_PUNTUACIONES_BS, Utilidades.CAMPO_ID_PUNTUACION_BS, bs);
            Long id_CF = db.insert(Utilidades.TABLA_PUNTUACIONES_CF, Utilidades.CAMPO_ID_PUNTUACION_CF, cf);
            Long id_A = db.insert(Utilidades.TABLA_PUNTUACIONES_A, Utilidades.CAMPO_ID_PUNTUACION_A, a);
            Long id_I = db.insert(Utilidades.TABLA_PUNTUACIONES_I, Utilidades.CAMPO_ID_PUNTUACION_I, i);
            Long id_Ar = db.insert(Utilidades.TABLA_PUNTUACIONES_AR, Utilidades.CAMPO_ID_PUNTUACION_AR, ar);
            Long id_Ad = db.insert(Utilidades.TABLA_PUNTUACIONES_AD, Utilidades.CAMPO_ID_PUNTUACION_AD, ad);

            Toast.makeText(getContext(),"Inserción de puntuaciones correcta",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
         Toast.makeText(getContext(),"Error al insertar puntuaciones",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
