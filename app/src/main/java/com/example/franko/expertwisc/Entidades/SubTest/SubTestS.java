package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestS {
    private String PuntuacionDirectaTotalS;
    Context context;
    ConexionHelper con;

    public SubTestS() {

    }

    public SubTestS(String puntuacionDirectaTotalS) {
        PuntuacionDirectaTotalS = puntuacionDirectaTotalS;
    }

    public String getPuntuacionDirectaTotalS() {
        return PuntuacionDirectaTotalS;
    }

    public void setPuntuacionDirectaTotalS(String puntuacionDirectaTotalS) {
        PuntuacionDirectaTotalS = puntuacionDirectaTotalS;
    }

    public void RegistrarS (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_S,getPuntuacionDirectaTotalS());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_S = db.insert(Utilidades.TABLA_PUNTUACIONES_S, Utilidades.CAMPO_ID_PUNTUACION_S, contentValues);
            Toast.makeText(context,"Inserción de puntuacion S correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion S",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaS(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_S+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalS(cursor.getString(1));
            Utilidades.R_s = getPuntuacionDirectaTotalS();
        }

        db.close();
    }
}
