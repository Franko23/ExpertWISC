package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestLN {

    private Integer Id_LN;
    private String PuntuacionDirectaTotalLN;
    private String Up_LN;

    Context context;
    ConexionHelper con;

    public SubTestLN() {

    }

    public SubTestLN(String puntuacionDirectaTotalLN) {
        PuntuacionDirectaTotalLN = puntuacionDirectaTotalLN;
    }

    public Integer getId_LN() {
        return Id_LN;
    }

    public void setId_LN(Integer id_LN) {
        Id_LN = id_LN;
    }

    public String getPuntuacionDirectaTotalLN() {
        return PuntuacionDirectaTotalLN;
    }

    public void setPuntuacionDirectaTotalLN(String puntuacionDirectaTotalLN) {
        PuntuacionDirectaTotalLN = puntuacionDirectaTotalLN;
    }

    public String getUp_LN() {
        return Up_LN;
    }

    public void setUp_LN(String up_LN) {
        Up_LN = up_LN;
    }


    public void RegistrarLN (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_LN, "");
        contentValues.put(Utilidades.CAMPO_UP_LN,"NO");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_LN = db.insert(Utilidades.TABLA_PUNTUACIONES_LN, Utilidades.CAMPO_ID_PUNTUACION_LN, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion LN correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion LN ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateLN(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_LN,getPuntuacionDirectaTotalLN());
        contentValues.put(Utilidades.CAMPO_UP_LN,"NO");

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_LN,contentValues,Utilidades.CAMPO_ID_PUNTUACION_LN+"="+getId_LN(),null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestLN actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestLN", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaLN(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_LN+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_LN(cursor.getInt(0));
            setPuntuacionDirectaTotalLN(cursor.getString(1));
            setUp_LN(cursor.getString(2));

            Utilidades.R_ln = getPuntuacionDirectaTotalLN();
        }

        db.close();
    }

}
