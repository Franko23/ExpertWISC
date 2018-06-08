package com.example.franko.expertwisc.Tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class Consultas {
    ConexionHelper con;
    Context context;

    public Consultas() {
        con = new ConexionHelper(context, "bd_wisc", null, 1);

    }

    public void RegistrarCC (Context context){
        this.context = context;

        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues cc = new ContentValues();
        cc.put(Utilidades.CAMPO_CC,Utilidades.R_cc);
        cc.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_CC = db.insert(Utilidades.TABLA_PUNTUACIONES_CC, Utilidades.CAMPO_ID_PUNTUACION_CC, cc);
            Toast.makeText(context,"Inserción de puntuacion CC correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion CC",Toast.LENGTH_SHORT).show();
        }
    }
}
