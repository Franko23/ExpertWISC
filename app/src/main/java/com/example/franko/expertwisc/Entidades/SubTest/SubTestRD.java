package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestRD {
    private String PuntuacionDirectaTotalRD;
    Context context;
    ConexionHelper con;

    public SubTestRD() {

    }

    public SubTestRD(String puntuacionDirectaTotalRD) {
        PuntuacionDirectaTotalRD = puntuacionDirectaTotalRD;
    }

    public String getPuntuacionDirectaTotalRD() {
        return PuntuacionDirectaTotalRD;
    }

    public void setPuntuacionDirectaTotalRD(String puntuacionDirectaTotalRD) {
        PuntuacionDirectaTotalRD = puntuacionDirectaTotalRD;
    }

    public void RegistrarRD (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_RDT,getPuntuacionDirectaTotalRD());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_RD = db.insert(Utilidades.TABLA_PUNTUACIONES_RD, Utilidades.CAMPO_ID_PUNTUACION_RD, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion RD correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion RD ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaRD(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_RD+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalRD(cursor.getString(3));
            Utilidades.R_rd = getPuntuacionDirectaTotalRD();
        }

        db.close();
    }
}
