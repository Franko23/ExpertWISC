package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestA {
    private String PuntuacionDirectaTotalA;
    Context context;
    ConexionHelper con;

    public SubTestA() {

    }

    public SubTestA(String puntuacionDirectaTotalA) {
        PuntuacionDirectaTotalA = puntuacionDirectaTotalA;
    }

    public String getPuntuacionDirectaTotalA() {
        return PuntuacionDirectaTotalA;
    }

    public void setPuntuacionDirectaTotalA(String puntuacionDirectaTotalA) {
        PuntuacionDirectaTotalA = puntuacionDirectaTotalA;
    }

    public void RegistrarA (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_A,getPuntuacionDirectaTotalA());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_A = db.insert(Utilidades.TABLA_PUNTUACIONES_A, Utilidades.CAMPO_ID_PUNTUACION_A, contentValues);
            Toast.makeText(context,"Inserción de puntuacion A correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion A ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaA(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_A+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalA(cursor.getString(1));
            Utilidades.R_a = getPuntuacionDirectaTotalA();
        }

        db.close();
    }
}
