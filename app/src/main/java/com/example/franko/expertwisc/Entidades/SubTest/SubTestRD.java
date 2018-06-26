package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestRD {
    private Integer Id_RD;
    private String PuntuacionDirectaTotalRD;
    private String Up_RD;

    Context context;
    ConexionHelper con;

    public SubTestRD() {

    }

    public SubTestRD(String puntuacionDirectaTotalRD) {
        PuntuacionDirectaTotalRD = puntuacionDirectaTotalRD;
    }


    public Integer getId_RD() {
        return Id_RD;
    }

    public void setId_RD(Integer id_RD) {
        Id_RD = id_RD;
    }

    public String getPuntuacionDirectaTotalRD() {
        return PuntuacionDirectaTotalRD;
    }

    public void setPuntuacionDirectaTotalRD(String puntuacionDirectaTotalRD) {
        PuntuacionDirectaTotalRD = puntuacionDirectaTotalRD;
    }

    public String getUp_RD() {
        return Up_RD;
    }

    public void setUp_RD(String up_RD) {
        Up_RD = up_RD;
    }




    public void RegistrarRD (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_RDT,"");
        contentValues.put(Utilidades.CAMPO_UP_RD,"NO");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_RD = db.insert(Utilidades.TABLA_PUNTUACIONES_RD, Utilidades.CAMPO_ID_PUNTUACION_RD, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion RD correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion RD ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateRD(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_RDT,getPuntuacionDirectaTotalRD());
        contentValues.put(Utilidades.CAMPO_UP_RD,"NO");

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_RD,contentValues,Utilidades.CAMPO_ID_PUNTUACION_RD+"="+getId_RD(),null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestRD actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestRD", Toast.LENGTH_SHORT).show();
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
            setId_RD(cursor.getInt(0));
            setPuntuacionDirectaTotalRD(cursor.getString(3));
            setUp_RD(cursor.getString(4));

            Utilidades.R_rd = getPuntuacionDirectaTotalRD();
        }

        db.close();
    }

}
