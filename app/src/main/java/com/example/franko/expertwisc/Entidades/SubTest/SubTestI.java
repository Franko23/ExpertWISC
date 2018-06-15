package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestI {
    private String PuntuacionDirectaTotalI;
    Context context;
    ConexionHelper con;

    public SubTestI() {

    }

    public SubTestI(String puntuacionDirectaTotalI) {
        PuntuacionDirectaTotalI = puntuacionDirectaTotalI;
    }

    public String getPuntuacionDirectaTotalI() {
        return PuntuacionDirectaTotalI;
    }

    public void setPuntuacionDirectaTotalI(String puntuacionDirectaTotalI) {
        PuntuacionDirectaTotalI = puntuacionDirectaTotalI;
    }

    public void RegistrarI (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_I,getPuntuacionDirectaTotalI());
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_I = db.insert(Utilidades.TABLA_PUNTUACIONES_I, Utilidades.CAMPO_ID_PUNTUACION_I, contentValues);
            Toast.makeText(context,"Inserción de puntuacion I correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion I ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void ConsultaI(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_I+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setPuntuacionDirectaTotalI(cursor.getString(1));
            Utilidades.R_i = getPuntuacionDirectaTotalI();
        }

        db.close();
    }
}
