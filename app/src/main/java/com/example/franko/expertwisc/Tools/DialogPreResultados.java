package com.example.franko.expertwisc.Tools;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
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

import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
import com.example.franko.expertwisc.FragmentosPrincipales.RegistroPaciente;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class DialogPreResultados extends DialogFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        final TextView result_cf = alertLayout.findViewById(R.id.result_cf);
        final TextView result_a = alertLayout.findViewById(R.id.result_a);
        final TextView result_i = alertLayout.findViewById(R.id.result_i);
        final TextView result_ar = alertLayout.findViewById(R.id.result_ar);
        final TextView result_ad = alertLayout.findViewById(R.id.result_ad);

        final Button si = alertLayout.findViewById(R.id.btn_si);
        final Button no = alertLayout.findViewById(R.id.btn_no);

        final SwitchCompat sw_cc = alertLayout.findViewById(R.id.sw_cc);
        final SwitchCompat sw_s = alertLayout.findViewById(R.id.sw_s);
        final SwitchCompat sw_rd = alertLayout.findViewById(R.id.sw_rd);
        final SwitchCompat sw_co = alertLayout.findViewById(R.id.sw_co);
        final SwitchCompat sw_cl = alertLayout.findViewById(R.id.sw_cl);
        final SwitchCompat sw_v = alertLayout.findViewById(R.id.sw_v);
        final SwitchCompat sw_ln = alertLayout.findViewById(R.id.sw_ln);
        final SwitchCompat sw_m = alertLayout.findViewById(R.id.sw_m);
        final SwitchCompat sw_c = alertLayout.findViewById(R.id.sw_c);
        final SwitchCompat sw_bs = alertLayout.findViewById(R.id.sw_bs);

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
        result_cf.setText(Utilidades.R_cf);
        result_a.setText(Utilidades.R_a);
        result_i.setText(Utilidades.R_i);
        result_ar.setText(Utilidades.R_ar);
        result_ad.setText(Utilidades.R_ad);

        String texto= "¿DESEA CONTINUAR CON LOS SUBTEST OPCIONALES?";

        if (Utilidades.R_cf != "Sin valor"){
            sw_cc.setVisibility(View.VISIBLE);
            sw_co.setVisibility(View.VISIBLE);
            sw_m.setVisibility(View.VISIBLE);
            texto = "SELECCIONA LA PRUEBA QUE REEMPLAZARÁ CF";
        }
        if (Utilidades.R_a != "Sin valor"){
            sw_cl.setVisibility(View.VISIBLE);
            sw_bs.setVisibility(View.VISIBLE);
            texto = "SELECCIONA LA PRUEBA QUE REEMPLAZARÁ A";
        }

        if (Utilidades.R_i != "Sin valor"){
            sw_s.setVisibility(View.VISIBLE);
            sw_v.setVisibility(View.VISIBLE);
            sw_c.setVisibility(View.VISIBLE);
            texto = "SELECCIONA LA PRUEBA QUE REEMPLAZARÁ I";
        }

        if (Utilidades.R_ar != "Sin valor"){
            sw_rd.setVisibility(View.VISIBLE);
            sw_ln.setVisibility(View.VISIBLE);
            texto = "SELECCIONA LA PRUEBA QUE REEMPLAZARÁ AR";
        }

        if (Utilidades.R_ad != "Sin valor"){
            sw_s.setVisibility(View.VISIBLE);
            sw_v.setVisibility(View.VISIBLE);
            sw_c.setVisibility(View.VISIBLE);
            texto = "SELECCIONA LA PRUEBA QUE REEMPLAZARÁ AD";
        }

        mensaje.setText(texto);


        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Utilidades.pages=5;
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
