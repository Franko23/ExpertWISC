package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestBS {

    private Integer Id_BS;
    private String PuntuacionDirectaTotalBS;
    Context context;
    ConexionHelper con;

    public SubTestBS() {

    }

    public SubTestBS(String puntuacionDirectaTotalBS) {
        PuntuacionDirectaTotalBS = puntuacionDirectaTotalBS;
    }

    public Integer getId_BS() {
        return Id_BS;
    }

    public void setId_BS(Integer id_BS) {
        Id_BS = id_BS;
    }

    public String getPuntuacionDirectaTotalBS() {
        return PuntuacionDirectaTotalBS;
    }

    public void setPuntuacionDirectaTotalBS(String puntuacionDirectaTotalBS) {
        PuntuacionDirectaTotalBS = puntuacionDirectaTotalBS;
    }

    public void RegistrarBS (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_BS, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_BS = db.insert(Utilidades.TABLA_PUNTUACIONES_BS, Utilidades.CAMPO_ID_PUNTUACION_BS, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion BS correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion BS ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateBS(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_BS,getPuntuacionDirectaTotalBS());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_BS,contentValues,Utilidades.CAMPO_ID_PUNTUACION_BS+"="+getId_BS(),null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestBS actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestBS", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaBS(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_BS+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_BS(cursor.getInt(0));
            setPuntuacionDirectaTotalBS(cursor.getString(1));

            Utilidades.R_bs = getPuntuacionDirectaTotalBS();
        }

        db.close();
    }

}
