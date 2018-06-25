package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCC {
    private int Id_CC;
    private String PuntuacionDirectaTotalCC;
    private String PuntuacionDirectaTotalCCS;
    private String Up_CC;

    Context context;
    ConexionHelper con;

    public SubTestCC() {

    }

    public SubTestCC(String puntuacionDirectaTotalCC, String puntuacionDirectaTotalCCS) {
        PuntuacionDirectaTotalCC = puntuacionDirectaTotalCC;
        PuntuacionDirectaTotalCCS = puntuacionDirectaTotalCCS;
    }

    public int getId_CC() {
        return Id_CC;
    }

    public void setId_CC(int id_CC) {
        Id_CC = id_CC;
    }

    public String getPuntuacionDirectaTotalCC() {
        return PuntuacionDirectaTotalCC;
    }

    public void setPuntuacionDirectaTotalCC(String puntuacionDirectaTotalCC) {
        PuntuacionDirectaTotalCC = puntuacionDirectaTotalCC;
    }

    public String getPuntuacionDirectaTotalCCS() {
        return PuntuacionDirectaTotalCCS;
    }

    public void setPuntuacionDirectaTotalCCS(String puntuacionDirectaTotalCCS) {
        PuntuacionDirectaTotalCCS = puntuacionDirectaTotalCCS;
    }


    public String getUp_CC() {
        return Up_CC;
    }

    public void setUp_CC(String up_CC) {
        Up_CC = up_CC;
    }





    public void RegistrarCC (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CC, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_CC = db.insert(Utilidades.TABLA_PUNTUACIONES_CC, Utilidades.CAMPO_ID_PUNTUACION_CC, contentValues);
            this.Id_CC = Integer.parseInt(id_CC.toString());
//            Toast.makeText(context,"Inserción de puntuacion CC correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion CC",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateCC(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CC,getPuntuacionDirectaTotalCC());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CC,contentValues,Utilidades.CAMPO_ID_PUNTUACION_CC+"="+getId_CC(),null);
            if (okTest==1){
                Log.d("Mensaje", "SubTestCC actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestCC", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaCC(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_CC+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_CC(cursor.getInt(0));
            setPuntuacionDirectaTotalCC(cursor.getString(1));
            setUp_CC(cursor.getString(3));

            Utilidades.R_cc = getPuntuacionDirectaTotalCC();
        }

        db.close();
    }

}
