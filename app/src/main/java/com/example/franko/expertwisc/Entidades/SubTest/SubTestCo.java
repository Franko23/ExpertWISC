package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCo {
    private String PuntuacionDirectaTotalCo;
    Context context;
    ConexionHelper con;

    public SubTestCo() {

    }

    public SubTestCo(String puntuacionDirectaTotalCo) {
        PuntuacionDirectaTotalCo = puntuacionDirectaTotalCo;
    }

    public String getPuntuacionDirectaTotalCo() {
        return PuntuacionDirectaTotalCo;
    }

    public void setPuntuacionDirectaTotalCo(String puntuacionDirectaTotalCo) {
        PuntuacionDirectaTotalCo = puntuacionDirectaTotalCo;
    }

    public void RegistrarCo (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CO,getPuntuacionDirectaTotalCo());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Co = db.insert(Utilidades.TABLA_PUNTUACIONES_CO, Utilidades.CAMPO_ID_PUNTUACION_CO, contentValues);
            Toast.makeText(context,"Inserción de puntuacion Co correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Co ",Toast.LENGTH_SHORT).show();
        }
    }
}
