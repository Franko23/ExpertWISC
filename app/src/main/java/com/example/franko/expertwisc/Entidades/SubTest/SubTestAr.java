package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestAr {
    private String PuntuacionDirectaTotalAr;
    Context context;
    ConexionHelper con;

    public SubTestAr() {

    }

    public SubTestAr(String puntuacionDirectaTotalAr) {
        PuntuacionDirectaTotalAr = puntuacionDirectaTotalAr;
    }

    public String getPuntuacionDirectaTotalAr() {
        return PuntuacionDirectaTotalAr;
    }

    public void setPuntuacionDirectaTotalAr(String puntuacionDirectaTotalAr) {
        PuntuacionDirectaTotalAr = puntuacionDirectaTotalAr;
    }

    public void RegistrarAr (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_AR,getPuntuacionDirectaTotalAr());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Ar = db.insert(Utilidades.TABLA_PUNTUACIONES_AR, Utilidades.CAMPO_ID_PUNTUACION_AR, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion Ar correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Ar ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaAr(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_AR+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalAr(cursor.getString(1));
            Utilidades.R_ar = getPuntuacionDirectaTotalAr();
        }

        db.close();
    }
}
