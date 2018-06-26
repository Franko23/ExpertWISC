package com.example.franko.expertwisc.Entidades.SubTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class SubTestCo {

    private Integer Id_Co;
    private String PuntuacionDirectaTotalCo;
    private String Up_Co;

    Context context;
    ConexionHelper con;

    public SubTestCo() {

    }

    public SubTestCo(String puntuacionDirectaTotalCo) {
        PuntuacionDirectaTotalCo = puntuacionDirectaTotalCo;
    }
    public Integer getId_Co() {
        return Id_Co;
    }

    public void setId_Co(Integer id_Co) {
        Id_Co = id_Co;
    }

    public String getPuntuacionDirectaTotalCo() {
        return PuntuacionDirectaTotalCo;
    }

    public void setPuntuacionDirectaTotalCo(String puntuacionDirectaTotalCo) {
        PuntuacionDirectaTotalCo = puntuacionDirectaTotalCo;
    }

    public String getUp_Co() {
        return Up_Co;
    }

    public void setUp_Co(String up_Co) {
        Up_Co = up_Co;
    }



    public void RegistrarCo (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CO,"");
        contentValues.put(Utilidades.CAMPO_ID_TEST, Utilidades.currentTest);

        try {
            Long id_Co = db.insert(Utilidades.TABLA_PUNTUACIONES_CO, Utilidades.CAMPO_ID_PUNTUACION_CO, contentValues);
            Utilidades.currentCo = Integer.parseInt(id_Co.toString());
//            Toast.makeText(context,"Inserción de puntuacion Co correcta",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar puntuacion Co ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void UpdateCo(Context context){
        this.context = context;

        con = new ConexionHelper(context,"bd_wisc",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.CAMPO_CO,getPuntuacionDirectaTotalCo());

        try {
            int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CO,contentValues,Utilidades.CAMPO_ID_PUNTUACION_CO+"="+Utilidades.currentCl,null);
            if (okTest==1){
                Log.d("Mensaje:", "SubTestCo actualizado corectamente");
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al actualizar SubTestCo", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void ConsultaCo(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PUNTUACIONES_CO+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setId_Co(cursor.getInt(0));
            setPuntuacionDirectaTotalCo(cursor.getString(1));
            setUp_Co(cursor.getString(2));

            Utilidades.currentCo = getId_Co();
            Utilidades.R_co = getPuntuacionDirectaTotalCo();
        }

        db.close();
    }

}
