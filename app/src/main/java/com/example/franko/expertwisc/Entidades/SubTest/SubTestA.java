package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestA {

    private Integer Id_A;
    private String PuntuacionDirectaTotalA;
    private String Up_A;

    Context context;
    ConexionHelper con;

    public SubTestA() {

    }

    public SubTestA(String puntuacionDirectaTotalA) {
        PuntuacionDirectaTotalA = puntuacionDirectaTotalA;
    }

    public Integer getId_A() {
        return Id_A;
    }

    public void setId_A(Integer id_A) {
        Id_A = id_A;
    }

    public String getPuntuacionDirectaTotalA() {
        return PuntuacionDirectaTotalA;
    }

    public void setPuntuacionDirectaTotalA(String puntuacionDirectaTotalA) {
        PuntuacionDirectaTotalA = puntuacionDirectaTotalA;
    }

    public String getUp_A() {
        return Up_A;
    }

    public void setUp_A(String up_A) {
        Up_A = up_A;
    }


    public void RegistrarA (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_A, "");
        contentValues.put(Utilidades.CAMPO_UP_A,"NO");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_A = db.insert(Utilidades.TABLA_PUNTUACIONES_A, Utilidades.CAMPO_ID_PUNTUACION_A, contentValues);
//            Toast.makeText(context,"Inserción de puntuacion A correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion A ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateA(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_A,getPuntuacionDirectaTotalA());
        contentValues.put(Utilidades.CAMPO_UP_A,"NO");

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_A,contentValues,Utilidades.CAMPO_ID_PUNTUACION_A+"="+getId_A(),null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestA actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestA", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaA(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_A+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_A(cursor.getInt(0));
            setPuntuacionDirectaTotalA(cursor.getString(1));
            setUp_A(cursor.getString(2));

            Utilidades.R_a = getPuntuacionDirectaTotalA();
        }

        db.close();
    }
}
