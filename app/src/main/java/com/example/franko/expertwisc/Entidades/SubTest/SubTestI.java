package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestI {

    private Integer Id_I;
    private String PuntuacionDirectaTotalI;
    private String Up_I;

    Context context;
    ConexionHelper con;

    public SubTestI() {

    }

    public SubTestI(String puntuacionDirectaTotalI) {
        PuntuacionDirectaTotalI = puntuacionDirectaTotalI;
    }

    public Integer getId_I() {
        return Id_I;
    }

    public void setId_I(Integer id_I) {
        Id_I = id_I;
    }

    public String getPuntuacionDirectaTotalI() {
        return PuntuacionDirectaTotalI;
    }

    public void setPuntuacionDirectaTotalI(String puntuacionDirectaTotalI) {
        PuntuacionDirectaTotalI = puntuacionDirectaTotalI;
    }

    public String getUp_I() {
        return Up_I;
    }

    public void setUp_I(String up_I) {
        Up_I = up_I;
    }


    public void RegistrarI (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_I, "");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_I = db.insert(Utilidades.TABLA_PUNTUACIONES_I, Utilidades.CAMPO_ID_PUNTUACION_I, contentValues);
            Utilidades.currentI = Integer.parseInt(id_I.toString());
//            Toast.makeText(context,"Inserción de puntuacion I correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion I ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateI(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_I,getPuntuacionDirectaTotalI());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_I,contentValues,Utilidades.CAMPO_ID_PUNTUACION_I+"="+Utilidades.currentI,null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestI actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestI", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaI(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_I+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_I(cursor.getInt(0));
            setPuntuacionDirectaTotalI(cursor.getString(1));
            setUp_I(cursor.getString(2));

            Utilidades.currentI = getId_I();
            Utilidades.R_i = getPuntuacionDirectaTotalI();
        }

        db.close();
    }
}
