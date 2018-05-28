package com.example.franko.expertwisc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.io.File;

/**
 * Created by FRANKO on 14/11/2017.
 */

public class ConexionHelper extends SQLiteOpenHelper {
    //The Android's default system path of your application database.
//    private static String DB_PATH = "/data/data/example/franko/expertwisc";
//    private static String DB_NAME = "bd_wisc";
//    private static Context myContext;
    public ConexionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
//        myContext = context;

//        boolean b = myContext.deleteDatabase(DB_NAME); // true if deleted

//        // DEPRECATED
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            SQLiteDatabase.deleteDatabase(new File(DB_PATH + DB_NAME));
//        }
//
//        if (b){
//
//        }
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_USUARIO);
//        sqLiteDatabase.execSQL(Utilidades.INSERTAR_USUARIO_MASTER);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PACIENTE);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CC);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_S);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_RD);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_Co);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CL);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_V);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_LN);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_M);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_C);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_BS);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_CF);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_A);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_I);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_Ar);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PUNTUACIONES_Ad);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_INTERVALO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_ESCALAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pacientes");
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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS intervalos");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS escalars");
        onCreate(sqLiteDatabase);
    }


}
