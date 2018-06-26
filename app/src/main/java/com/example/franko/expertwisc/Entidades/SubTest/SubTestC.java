package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestC {
    private Integer Id_C;
    private String PuntuacionDirectaTotalC;
    private String Up_C;

    Context context;
    ConexionHelper con;

    public SubTestC() {

    }

    public SubTestC(String puntuacionDirectaTotalC) {
        PuntuacionDirectaTotalC = puntuacionDirectaTotalC;
    }

    public Integer getId_C() {
        return Id_C;
    }

    public void setId_C(Integer id_C) {
        Id_C = id_C;
    }

    public String getPuntuacionDirectaTotalC() {
        return PuntuacionDirectaTotalC;
    }

    public void setPuntuacionDirectaTotalC(String puntuacionDirectaTotalC) {
        PuntuacionDirectaTotalC = puntuacionDirectaTotalC;
    }

    public String getUp_C() {
        return Up_C;
    }

    public void setUp_C(String up_C) {
        Up_C = up_C;
    }


    public void RegistrarC (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_C, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_C = db.insert(Utilidades.TABLA_PUNTUACIONES_C, Utilidades.CAMPO_ID_PUNTUACION_C, contentValues);
            Utilidades.currentC = Integer.parseInt(id_C.toString());
//            Toast.makeText(context,"Inserción de puntuacion C correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion C ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateC(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_C,getPuntuacionDirectaTotalC());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_C,contentValues,Utilidades.CAMPO_ID_PUNTUACION_C+"="+Utilidades.currentC,null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestC actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestC", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaC(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_C+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_C(cursor.getInt(0));
            setPuntuacionDirectaTotalC(cursor.getString(1));
            setUp_C(cursor.getString(2));

            Utilidades.currentC = getId_C();
            Utilidades.R_c = getPuntuacionDirectaTotalC();
        }

        db.close();
    }

}
