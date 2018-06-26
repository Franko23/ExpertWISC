package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestS {
    private Integer Id_S;
    private String PuntuacionDirectaTotalS;
    private String Up_S;

    Context context;
    ConexionHelper con;

    public SubTestS() {

    }

    public SubTestS(String puntuacionDirectaTotalS) {
        PuntuacionDirectaTotalS = puntuacionDirectaTotalS;
    }

    public Integer getId_S() {
        return Id_S;
    }

    public void setId_S(Integer id_S) {
        Id_S = id_S;
    }

    public String getPuntuacionDirectaTotalS() {
        return PuntuacionDirectaTotalS;
    }

    public void setPuntuacionDirectaTotalS(String puntuacionDirectaTotalS) {
        PuntuacionDirectaTotalS = puntuacionDirectaTotalS;
    }

    public String getUp_S() {
        return Up_S;
    }

    public void setUp_S(String up_S) {
        Up_S = up_S;
    }


    public void RegistrarS (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_S, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_S = db.insert(Utilidades.TABLA_PUNTUACIONES_S, Utilidades.CAMPO_ID_PUNTUACION_S, contentValues);
            Utilidades.currentS = Integer.parseInt(id_S.toString());
//            Toast.makeText(context,"Inserción de puntuacion S correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion S",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateS(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_S,getPuntuacionDirectaTotalS());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_S,contentValues,Utilidades.CAMPO_ID_PUNTUACION_S+"="+Utilidades.currentS,null);
            if (okTest==1){
                Log.d("Mensaje", "SubTestS actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestS", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
    public void ConsultaS(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_S+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_S(cursor.getInt(0));
            setPuntuacionDirectaTotalS(cursor.getString(1));
            setUp_S(cursor.getString(2));

            Utilidades.currentS = getId_S();
            Utilidades.R_s = getPuntuacionDirectaTotalS();
        }

        db.close();
    }

}
