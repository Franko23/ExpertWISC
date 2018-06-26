package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestV {

    private Integer Id_V;
    private String PuntuacionDirectaTotalV;
    private String Up_V;

    Context context;
    ConexionHelper con;

    public SubTestV() {

    }

    public SubTestV(String puntuacionDirectaTotalV) {
        PuntuacionDirectaTotalV = puntuacionDirectaTotalV;
    }


    public Integer getId_V() {
        return Id_V;
    }

    public void setId_V(Integer id_V) {
        Id_V = id_V;
    }

    public String getPuntuacionDirectaTotalV() {
        return PuntuacionDirectaTotalV;
    }

    public void setPuntuacionDirectaTotalV(String puntuacionDirectaTotalV) {
        PuntuacionDirectaTotalV = puntuacionDirectaTotalV;
    }

    public String getUp_V() {
        return Up_V;
    }

    public void setUp_V(String up_V) {
        Up_V = up_V;
    }


    public void RegistrarV (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_V, "NO");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_V = db.insert(Utilidades.TABLA_PUNTUACIONES_V, Utilidades.CAMPO_ID_PUNTUACION_V, contentValues);
            Utilidades.currentV = Integer.parseInt(id_V.toString());
//            Toast.makeText(context,"Inserción de puntuacion V correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion V ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateV(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_V,getPuntuacionDirectaTotalV());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_V,contentValues,Utilidades.CAMPO_ID_PUNTUACION_V+"="+Utilidades.currentV,null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestV actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestV", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaV(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_V+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_V(cursor.getInt(0));
            setPuntuacionDirectaTotalV(cursor.getString(1));
            setUp_V(cursor.getString(2));

            Utilidades.currentV = getId_V();
            Utilidades.R_v = getPuntuacionDirectaTotalV();
        }

        db.close();
    }

}
