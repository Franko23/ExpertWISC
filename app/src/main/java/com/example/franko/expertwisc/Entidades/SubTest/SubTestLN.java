package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestLN {
    private String PuntuacionDirectaTotalLN;
    Context context;
    ConexionHelper con;

    public SubTestLN() {

    }

    public SubTestLN(String puntuacionDirectaTotalLN) {
        PuntuacionDirectaTotalLN = puntuacionDirectaTotalLN;
    }

    public String getPuntuacionDirectaTotalLN() {
        return PuntuacionDirectaTotalLN;
    }

    public void setPuntuacionDirectaTotalLN(String puntuacionDirectaTotalLN) {
        PuntuacionDirectaTotalLN = puntuacionDirectaTotalLN;
    }

    public void RegistrarLN (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_LN,getPuntuacionDirectaTotalLN());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_LN = db.insert(Utilidades.TABLA_PUNTUACIONES_LN, Utilidades.CAMPO_ID_PUNTUACION_LN, contentValues);
            Toast.makeText(context,"Inserción de puntuacion LN correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion LN ",Toast.LENGTH_SHORT).show();
        }
    }
}
