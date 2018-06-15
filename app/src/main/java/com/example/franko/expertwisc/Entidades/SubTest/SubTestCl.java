package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCl {
    private String PuntuacionDirectaTotalCl;
    Context context;
    ConexionHelper con;

    public SubTestCl() {

    }

    public SubTestCl(String puntuacionDirectaTotalCl) {
        PuntuacionDirectaTotalCl = puntuacionDirectaTotalCl;
    }

    public String getPuntuacionDirectaTotalCl() {
        return PuntuacionDirectaTotalCl;
    }

    public void setPuntuacionDirectaTotalCl(String puntuacionDirectaTotalCl) {
        PuntuacionDirectaTotalCl = puntuacionDirectaTotalCl;
    }

    public void RegistrarCl (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CL,getPuntuacionDirectaTotalCl());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Cl = db.insert(Utilidades.TABLA_PUNTUACIONES_CL, Utilidades.CAMPO_ID_PUNTUACION_CL, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion Cl correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Cl ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaCl(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_CL+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalCl(cursor.getString(1));
            Utilidades.R_cl = getPuntuacionDirectaTotalCl();
        }

        db.close();
    }
}
