package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCF {
    private String PuntuacionDirectaTotalCF;
    Context context;
    ConexionHelper con;

    public SubTestCF() {

    }

    public SubTestCF(String puntuacionDirectaTotalCF) {
        PuntuacionDirectaTotalCF = puntuacionDirectaTotalCF;
    }

    public String getPuntuacionDirectaTotalCF() {
        return PuntuacionDirectaTotalCF;
    }

    public void setPuntuacionDirectaTotalCF(String puntuacionDirectaTotalCF) {
        PuntuacionDirectaTotalCF = puntuacionDirectaTotalCF;
    }

    public void RegistrarCF (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CF,getPuntuacionDirectaTotalCF());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_CF = db.insert(Utilidades.TABLA_PUNTUACIONES_CF, Utilidades.CAMPO_ID_PUNTUACION_CF, contentValues);
            Toast.makeText(context,"Inserción de puntuacion CF correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion CF ",Toast.LENGTH_SHORT).show();
        }
    }
}
