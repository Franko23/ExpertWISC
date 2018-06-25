package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestAd {

    private Integer Id_Ad;
    private String PuntuacionDirectaTotalAd;
    Context context;
    ConexionHelper con;

    public SubTestAd() {

    }

    public SubTestAd(String puntuacionDirectaTotalAd) {
        PuntuacionDirectaTotalAd = puntuacionDirectaTotalAd;
    }

    public Integer getId_Ad() {
        return Id_Ad;
    }

    public void setId_Ad(Integer id_Ad) {
        Id_Ad = id_Ad;
    }

    public String getPuntuacionDirectaTotalAd() {
        return PuntuacionDirectaTotalAd;
    }

    public void setPuntuacionDirectaTotalAd(String puntuacionDirectaTotalAd) {
        PuntuacionDirectaTotalAd = puntuacionDirectaTotalAd;
    }

    public void RegistrarAd (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_AD, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Ad = db.insert(Utilidades.TABLA_PUNTUACIONES_AD, Utilidades.CAMPO_ID_PUNTUACION_AD, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion Ad correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Ad ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateAd(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_AD,getPuntuacionDirectaTotalAd());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_AD,contentValues,Utilidades.CAMPO_ID_PUNTUACION_AD+"="+getId_Ad(),null);
            if (okTest==1){
                Log.d("Mensaje", "SubTestAd actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestAd", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaAd(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db =con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_AD+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_Ad(cursor.getInt(0));
            setPuntuacionDirectaTotalAd(cursor.getString(1));

            Utilidades.R_ad = getPuntuacionDirectaTotalAd();
        }

        db.close();
    }

}
