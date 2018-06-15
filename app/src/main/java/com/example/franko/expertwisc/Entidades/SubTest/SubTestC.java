package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestC {
    private String PuntuacionDirectaTotalC;
    Context context;
    ConexionHelper con;

    public SubTestC() {

    }

    public SubTestC(String puntuacionDirectaTotalC) {
        PuntuacionDirectaTotalC = puntuacionDirectaTotalC;
    }

    public String getPuntuacionDirectaTotalC() {
        return PuntuacionDirectaTotalC;
    }

    public void setPuntuacionDirectaTotalC(String puntuacionDirectaTotalC) {
        PuntuacionDirectaTotalC = puntuacionDirectaTotalC;
    }

    public void RegistrarC (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_C,getPuntuacionDirectaTotalC());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_C = db.insert(Utilidades.TABLA_PUNTUACIONES_C, Utilidades.CAMPO_ID_PUNTUACION_C, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion C correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion C ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaC(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_C+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalC(cursor.getString(1));
            Utilidades.R_c = getPuntuacionDirectaTotalC();
        }

        db.close();
    }
}
