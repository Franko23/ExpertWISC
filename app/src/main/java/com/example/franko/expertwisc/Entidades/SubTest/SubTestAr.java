package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestAr {

    private Integer Id_Ar;
    private String PuntuacionDirectaTotalAr;
    private String Up_Ar;

    Context context;
    ConexionHelper con;

    public SubTestAr() {

    }

    public SubTestAr(String puntuacionDirectaTotalAr) {
        PuntuacionDirectaTotalAr = puntuacionDirectaTotalAr;
    }

    public Integer getId_Ar() {
        return Id_Ar;
    }

    public void setId_Ar(Integer id_Ar) {
        Id_Ar = id_Ar;
    }

    public String getPuntuacionDirectaTotalAr() {
        return PuntuacionDirectaTotalAr;
    }

    public void setPuntuacionDirectaTotalAr(String puntuacionDirectaTotalAr) {
        PuntuacionDirectaTotalAr = puntuacionDirectaTotalAr;
    }

    public String getUp_Ar() {
        return Up_Ar;
    }

    public void setUp_Ar(String up_Ar) {
        Up_Ar = up_Ar;
    }


    public void RegistrarAr (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_AR, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Ar = db.insert(Utilidades.TABLA_PUNTUACIONES_AR, Utilidades.CAMPO_ID_PUNTUACION_AR, contentValues);
            Utilidades.currentAr = Integer.parseInt(id_Ar.toString());
//            Toast.makeText(context,"Inserción de puntuacion Ar correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Ar ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateAr(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_AR,getPuntuacionDirectaTotalAr());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_AR,contentValues,Utilidades.CAMPO_ID_PUNTUACION_AR+"="+Utilidades.currentAr,null);
            if (okTest==1){
                Log.d("Mensaje", "SubTestAr actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestAr", Toast.LENGTH_SHORT).show();
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
            setId_Ar(cursor.getInt(0));
            setPuntuacionDirectaTotalAr(cursor.getString(1));
            setUp_Ar(cursor.getString(2));

            Utilidades.currentAr = getId_Ar();
            Utilidades.R_ar = getPuntuacionDirectaTotalAr();
        }

        db.close();
    }

}
