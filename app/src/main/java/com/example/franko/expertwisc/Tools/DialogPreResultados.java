package com.example.franko.expertwisc.Tools;

import android.app.Dialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
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
                        UpdateTest(Utilidades.intervalo_confianza);
//                        Toast.makeText(getContext(), Utilidades.intervalo_confianza, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_95:
                        Utilidades.intervalo_confianza = "95";
                        UpdateTest(Utilidades.intervalo_confianza);
//                        Toast.makeText(getContext(), Utilidades.intervalo_confianza, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        if (Utilidades.R_cc.isEmpty()){
            result_cc.setTextColor(getResources().getColor(R.color.colorAccent));
            result_cc.setText("Sin valor");
        }
        if (Utilidades.R_s.isEmpty()){
            result_s.setTextColor(getResources().getColor(R.color.colorAccent));
            result_s.setText("Sin valor");
        }
        if (Utilidades.R_rd.isEmpty()){
            result_rd.setTextColor(getResources().getColor(R.color.colorAccent));
            result_rd.setText("Sin valor");
        }
        if (Utilidades.R_co.isEmpty()){
            result_co.setTextColor(getResources().getColor(R.color.colorAccent));
            result_co.setText("Sin valor");
        }
        if (Utilidades.R_cl.isEmpty()){
            result_cl.setTextColor(getResources().getColor(R.color.colorAccent));
            result_cl.setText("Sin valor");
        }
        if (Utilidades.R_v.isEmpty()){
            result_v.setTextColor(getResources().getColor(R.color.colorAccent));
            result_v.setText("Sin valor");
        }
        if (Utilidades.R_ln.isEmpty()){
            result_ln.setTextColor(getResources().getColor(R.color.colorAccent));
            result_ln.setText("Sin valor");
        }
        if (Utilidades.R_m.isEmpty()){
            result_m.setTextColor(getResources().getColor(R.color.colorAccent));
            result_m.setText("Sin valor");
        }
        if (Utilidades.R_c.isEmpty()){
            result_c.setTextColor(getResources().getColor(R.color.colorAccent));
            result_c.setText("Sin valor");
        }
        if (Utilidades.R_bs.isEmpty()){
            result_bs.setTextColor(getResources().getColor(R.color.colorAccent));
            result_bs.setText("Sin valor");
        }

        if (
            Utilidades.R_cc.isEmpty() ||
            Utilidades.R_s.isEmpty() ||
            Utilidades.R_rd.isEmpty() ||
            Utilidades.R_co.isEmpty() ||
            Utilidades.R_cl.isEmpty() ||
            Utilidades.R_v.isEmpty() ||
            Utilidades.R_ln.isEmpty() ||
            Utilidades.R_m.isEmpty() ||
            Utilidades.R_c.isEmpty() ||
            Utilidades.R_bs.isEmpty()
                ){

            rGroup.setVisibility(View.GONE);
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

                getDialog().dismiss();

                Fragment fragment = new Resultados();
                getFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();

            }
        });

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Utilidades.pages=5;
                Utilidades.disable=false;
                Fragment fragment = new GeneralSubPruebas();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();

            }
        });

        return alertLayout;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;

    }

    private void UpdateTest(String intervalo) {
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues test = new ContentValues();
        test.put(Utilidades.CAMPO_INTERVALO, intervalo);
        int ok = db.update(Utilidades.TABLA_TEST,test,Utilidades.CAMPO_ID_TEST+"="+Utilidades.currentTest,null);
//        Toast.makeText(getContext(),"Intervalo "+intervalo+" = "+ok,Toast.LENGTH_SHORT).show();
        db.close();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
