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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
import com.example.franko.expertwisc.FragmentosPrincipales.RegistroPaciente;
import com.example.franko.expertwisc.FragmentosPrincipales.Resultados;
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

        final RadioButton radio_90 = alertLayout.findViewById(R.id.radio_90);
        final RadioButton radio_95 = alertLayout.findViewById(R.id.radio_95);

        // This will get the radiogroup
        RadioGroup rGroup = (RadioGroup)alertLayout.findViewById(R.id.radioGroup);

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

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                mensaje.setText(getResources().getString(R.string.mensajeContinuar));
                no.setVisibility(View.VISIBLE);
                si.setVisibility(View.VISIBLE);

                switch (checkedId) {
                    case R.id.radio_90:
                        Utilidades.intervalo_confianza = "90";
                        Toast.makeText(getContext(), Utilidades.intervalo_confianza, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_95:
                        Utilidades.intervalo_confianza = "95";
                        Toast.makeText(getContext(), Utilidades.intervalo_confianza, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


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
        }else {
            rGroup.setVisibility(View.VISIBLE);
            mensaje.setText(R.string.mensajeIntervalo);
            mensaje.setTextColor(getResources().getColor(R.color.colorAccent));
        }


        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Verificamos si el intervalo de confianza está seleccionados

                getDialog().dismiss();

                android.support.v4.app.Fragment fragment = new Resultados();
                getFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();

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

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
