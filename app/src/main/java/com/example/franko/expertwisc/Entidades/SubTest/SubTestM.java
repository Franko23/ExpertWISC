package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestM {

    private Integer Id_M;
    private String PuntuacionDirectaTotalM;
    Context context;
    ConexionHelper con;

    public SubTestM() {

    }

    public SubTestM(String puntuacionDirectaTotalM) {
        PuntuacionDirectaTotalM = puntuacionDirectaTotalM;
    }

    public Integer getId_M() {
        return Id_M;
    }

    public void setId_M(Integer id_M) {
        Id_M = id_M;
    }

    public String getPuntuacionDirectaTotalM() {
        return PuntuacionDirectaTotalM;
    }

    public void setPuntuacionDirectaTotalM(String puntuacionDirectaTotalM) {
        PuntuacionDirectaTotalM = puntuacionDirectaTotalM;
    }

    public void RegistrarM (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_M, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_M = db.insert(Utilidades.TABLA_PUNTUACIONES_M, Utilidades.CAMPO_ID_PUNTUACION_M, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion M correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion M ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateM(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_M,getPuntuacionDirectaTotalM());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_M,contentValues,Utilidades.CAMPO_ID_PUNTUACION_M+"="+getId_M(),null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestM actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestM", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaM(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_M+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_M(cursor.getInt(0));
            setPuntuacionDirectaTotalM(cursor.getString(1));

            Utilidades.R_m = getPuntuacionDirectaTotalM();
        }

        db.close();
    }

}
