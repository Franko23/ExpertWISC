package com.example.franko.expertwisc.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;

public class Test {
    private Integer Id_test;
    private String Fecha_test;
    private String Evaluador_test;
    private String Estado_test;
    private String Intervalo_confianza;
    private String Edad_test;
    private String Up_test;

    ConexionHelper con;
    Context context;

    public Test(Integer id_test, String fecha_test, String evaluador_test, String estado_test, String intervalo_confianza, String edad_test, String up_test) {
        Id_test = id_test;
        Fecha_test = fecha_test;
        Evaluador_test = evaluador_test;
        Estado_test = estado_test;
        Intervalo_confianza = intervalo_confianza;
        Edad_test = edad_test;
        Up_test = up_test;
    }

    public Test() {
    }

    public Integer getId_test() {
        return Id_test;
    }

    public void setId_test(Integer id_test) {
        this.Id_test = id_test;
    }

    public String getFecha_test() {
        return Fecha_test;
    }

    public void setFecha_test(String fecha_test) {
        Fecha_test = fecha_test;
    }

    public String getEvaluador_test() {
        return Evaluador_test;
    }

    public void setEvaluador_test(String evaluador_test) {
        Evaluador_test = evaluador_test;
    }

    public String getEstado_test() {
        return Estado_test;
    }

    public void setEstado_test(String estado_test) {
        Estado_test = estado_test;
    }

    public String getIntervalo_confianza() {
        return Intervalo_confianza;
    }

    public void setIntervalo_confianza(String intervalo_confianza) {
        Intervalo_confianza = intervalo_confianza;
    }

    public String getEdad_test() {
        return Edad_test;
    }

    public void setEdad_test(String edad_test) {
        Edad_test = edad_test;
    }


    public String getUp_test() {
        return Up_test;
    }

    public void setUp_test(String up_test) {
        Up_test = up_test;
    }



    public void UpdateTestState(Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues test = new ContentValues();
        test.put(Utilidades.CAMPO_ESTADO_TEST, "FINALIZADO");
        int id = db.update(Utilidades.TABLA_TEST,test,Utilidades.CAMPO_ID_TEST+"="+Utilidades.currentTest,null);
//        Toast.makeText(context,"Cambio de estado = "+id,Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void UpdateTestUp(Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues test = new ContentValues();
        test.put(Utilidades.CAMPO_UP_TEST, "NO");


        int id = db.update(Utilidades.TABLA_TEST,test,Utilidades.CAMPO_ID_TEST+"="+Utilidades.currentTest,null);
        if (id==1){
            Log.d("Mensaje","Campo UP actualizado");
        }else {
            Log.d("Mensaje","Error al actualizar campo UP");
        }
//        Toast.makeText(context,"Cambio de estado = "+id,Toast.LENGTH_SHORT).show();
        db.close();
    }

    public ArrayList<Test> consultarTablaTest(Integer id_paciente, Context context) {
        this.context = context;
        Utilidades.TestUp=0;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        ArrayList<Test> listaTest = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM test WHERE id_paciente"+"="+id_paciente,null);

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                Test test = new Test();

                test.setId_test(cursor.getInt(0));
                test.setFecha_test(cursor.getString(1));
                test.setEvaluador_test(cursor.getString(2));
                test.setEstado_test(cursor.getString(3));
                test.setIntervalo_confianza(cursor.getString(4));
                test.setEdad_test(cursor.getString(5));
                test.setUp_test(cursor.getString(6));
                if (test.getUp_test().equals("NO")){
                    Utilidades.TestUp++;
                }
                listaTest.add(test);
            }
        }
        db.close();
        return listaTest;
    }

    public void ConsultaIntervalo(Context context, int id_test){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_TEST+" WHERE " + Utilidades.CAMPO_ID_TEST+ "=" + id_test,null);
        while (cursor.moveToNext()){
            setIntervalo_confianza(cursor.getString(1));
            Utilidades.intervalo_confianza = getIntervalo_confianza();
        }

        db.close();
    }

    public void Valores(){
        Utilidades.R_cc = "";
        Utilidades.R_s = "";
        Utilidades.R_rd = "";
        Utilidades.R_co = "";
        Utilidades.R_cl = "";
        Utilidades.R_ln = "";
        Utilidades.R_v = "";
        Utilidades.R_m = "";
        Utilidades.R_c = "";
        Utilidades.R_bs = "";
        Utilidades.R_cf = "";
        Utilidades.R_a = "";
        Utilidades.R_i = "";
        Utilidades.R_ar = "";
        Utilidades.R_ad = "";
    }

}
