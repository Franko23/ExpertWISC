package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestAd {
    private String PuntuacionDirectaTotalAd;
    Context context;
    ConexionHelper con;

    public SubTestAd() {

    }

    public SubTestAd(String puntuacionDirectaTotalAd) {
        PuntuacionDirectaTotalAd = puntuacionDirectaTotalAd;
    }

    public String getPuntuacionDirectaTotalAd() {
        return PuntuacionDirectaTotalAd;
    }

    public void setPuntuacionDirectaTotalAd(String puntuacionDirectaTotalAd) {
        PuntuacionDirectaTotalAd = puntuacionDirectaTotalAd;
    }

    public void RegistrarAd (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_AD,getPuntuacionDirectaTotalAd());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Ad = db.insert(Utilidades.TABLA_PUNTUACIONES_AD, Utilidades.CAMPO_ID_PUNTUACION_AD, contentValues);
            Toast.makeText(context,"Inserción de puntuacion Ad correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Ad ",Toast.LENGTH_SHORT).show();
        }
    }
}
