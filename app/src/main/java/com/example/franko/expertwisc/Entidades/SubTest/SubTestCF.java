package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCF {

    private Integer Id_CF;
    private String PuntuacionDirectaTotalCF;
    private String Up_CF;

    Context context;
    ConexionHelper con;

    public SubTestCF() {

    }

    public SubTestCF(String puntuacionDirectaTotalCF) {
        PuntuacionDirectaTotalCF = puntuacionDirectaTotalCF;
    }


    public Integer getId_CF() {
        return Id_CF;
    }

    public void setId_CF(Integer id_CF) {
        Id_CF = id_CF;
    }

    public String getPuntuacionDirectaTotalCF() {
        return PuntuacionDirectaTotalCF;
    }

    public void setPuntuacionDirectaTotalCF(String puntuacionDirectaTotalCF) {
        PuntuacionDirectaTotalCF = puntuacionDirectaTotalCF;
    }

    public String getUp_CF() {
        return Up_CF;
    }

    public void setUp_CF(String up_CF) {
        Up_CF = up_CF;
    }


    public void RegistrarCF (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CF, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_CF = db.insert(Utilidades.TABLA_PUNTUACIONES_CF, Utilidades.CAMPO_ID_PUNTUACION_CF, contentValues);
            Utilidades.currentCF = Integer.parseInt(id_CF.toString());
//            Toast.makeText(context,"Inserción de puntuacion CF correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion CF ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateCF(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CF,getPuntuacionDirectaTotalCF());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CF,contentValues,Utilidades.CAMPO_ID_PUNTUACION_CF+"="+Utilidades.currentCF,null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestCF actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestCF", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaCF(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_CF+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_CF(cursor.getInt(0));
            setPuntuacionDirectaTotalCF(cursor.getString(1));
            setUp_CF(cursor.getString(2));

            Utilidades.currentCF = getId_CF();
            Utilidades.R_cf = getPuntuacionDirectaTotalCF();
        }

        db.close();
    }

}
