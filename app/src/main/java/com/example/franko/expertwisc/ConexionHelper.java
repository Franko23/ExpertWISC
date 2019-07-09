package com.example.franko.expertwisc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.franko.expertwisc.Utilidades.Utilidades;

/**
 * Created by FRANKO on 14/11/2017.
 */

public class ConexionHelper extends SQLiteOpenHelper {

    public ConexionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PERSONA);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PACIENTE);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_TEST);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CC);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_S);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_RD);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CL);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_V);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_LN);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_M);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_C);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_BS);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CF);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_A);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_I);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_AR);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_AD);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_ICV);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_IRP);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_IMO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_IVP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS personas");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pacientes");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS test");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_ccs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_ss");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_rds");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_cos");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_cls");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_vs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_lns");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_ms");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_cs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_bss");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_cfs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_as");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_is");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_ars");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS puntuacion_ads");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS icv");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS irp");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS imo");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ivp");
        onCreate(sqLiteDatabase);
    }


}