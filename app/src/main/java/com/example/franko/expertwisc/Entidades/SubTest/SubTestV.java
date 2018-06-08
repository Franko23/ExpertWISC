package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestV {
    private String PuntuacionDirectaTotalV;
    Context context;
    ConexionHelper con;

    public SubTestV() {

    }

    public SubTestV(String puntuacionDirectaTotalV) {
        PuntuacionDirectaTotalV = puntuacionDirectaTotalV;
    }

    public String getPuntuacionDirectaTotalV() {
        return PuntuacionDirectaTotalV;
    }

    public void setPuntuacionDirectaTotalV(String puntuacionDirectaTotalV) {
        PuntuacionDirectaTotalV = puntuacionDirectaTotalV;
    }

    public void RegistrarV (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_V,getPuntuacionDirectaTotalV());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_V = db.insert(Utilidades.TABLA_PUNTUACIONES_V, Utilidades.CAMPO_ID_PUNTUACION_V, contentValues);
            Toast.makeText(context,"Inserción de puntuacion V correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion V ",Toast.LENGTH_SHORT).show();
        }
    }
}
