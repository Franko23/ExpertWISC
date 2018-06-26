package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCl {

    private Integer Id_Cl;
    private String PuntuacionDirectaTotalCl;
    private String Up_Cl;

    Context context;
    ConexionHelper con;

    public SubTestCl() {

    }

    public SubTestCl(String puntuacionDirectaTotalCl) {
        PuntuacionDirectaTotalCl = puntuacionDirectaTotalCl;
    }

    public Integer getId_Cl() {
        return Id_Cl;
    }

    public void setId_Cl(Integer id_Cl) {
        Id_Cl = id_Cl;
    }

    public String getPuntuacionDirectaTotalCl() {
        return PuntuacionDirectaTotalCl;
    }

    public void setPuntuacionDirectaTotalCl(String puntuacionDirectaTotalCl) {
        PuntuacionDirectaTotalCl = puntuacionDirectaTotalCl;
    }

    public String getUp_Cl() {
        return Up_Cl;
    }

    public void setUp_Cl(String up_Cl) {
        Up_Cl = up_Cl;
    }


    public void RegistrarCl (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CL,"");
        contentValues.put(Utilidades.CAMPO_UP_CL,"NO");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Cl = db.insert(Utilidades.TABLA_PUNTUACIONES_CL, Utilidades.CAMPO_ID_PUNTUACION_CL, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion Cl correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Cl ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateCl(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CL,getPuntuacionDirectaTotalCl());
        contentValues.put(Utilidades.CAMPO_UP_CL,"NO");

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CL,contentValues,Utilidades.CAMPO_ID_PUNTUACION_CL+"="+getId_Cl(),null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestCl actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestCl", Toast.LENGTH_SHORT).show();
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
            setId_Cl(cursor.getInt(0));
            setPuntuacionDirectaTotalCl(cursor.getString(1));
            setUp_Cl(cursor.getString(2));

            Utilidades.R_cl = getPuntuacionDirectaTotalCl();
        }

        db.close();
    }

}
