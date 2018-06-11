package com.example.franko.expertwisc.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class Test {
    private int Id_test;
    private String Fecha_test;
    private String Evaluador_test;
    private String Estado_test;
    private String Intervalo_confianza;
    private String Edad_test;

    ConexionHelper con;
    Context context;

    public Test(int id_test, String fecha_test, String evaluador_test, String estado_test, String intervalo_confianza, String edad_test) {
        this.Id_test = id_test;
        Fecha_test = fecha_test;
        Evaluador_test = evaluador_test;
        Estado_test = estado_test;
        Intervalo_confianza = intervalo_confianza;
        Edad_test = edad_test;
    }

    public Test() {
    }

    public int getId_test() {
        return Id_test;
    }

    public void setId_test(int id_test) {
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

    public void UpdateTestState(Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues test = new ContentValues();
        test.put(Utilidades.CAMPO_ESTADO_TEST, "FINALIZADO");
        int id = db.update(Utilidades.TABLA_TEST,test,Utilidades.CAMPO_ID_TEST+"="+Utilidades.currentTest,null);
        Toast.makeText(context,"Cambio de estado = "+id,Toast.LENGTH_SHORT).show();
        db.close();
    }

}
