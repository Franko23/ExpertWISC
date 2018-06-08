package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestM {
    private String PuntuacionDirectaTotalM;
    Context context;
    ConexionHelper con;

    public SubTestM() {

    }

    public SubTestM(String puntuacionDirectaTotalM) {
        PuntuacionDirectaTotalM = puntuacionDirectaTotalM;
    }

    public String getPuntuacionDirectaTotalM() {
        return PuntuacionDirectaTotalM;
    }

    public void setPuntuacionDirectaTotalM(String puntuacionDirectaTotalM) {
        PuntuacionDirectaTotalM = puntuacionDirectaTotalM;
    }

    public void RegistrarM (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_M,getPuntuacionDirectaTotalM());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_M = db.insert(Utilidades.TABLA_PUNTUACIONES_M, Utilidades.CAMPO_ID_PUNTUACION_M, contentValues);
            Toast.makeText(context,"Inserción de puntuacion M correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion M ",Toast.LENGTH_SHORT).show();
        }
    }
}
