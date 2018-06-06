package com.example.franko.expertwisc.Entidades;

public class Test {
    private int Id_test;
    private String Fecha_test;
    private String Evaluador_test;
    private String Estado_test;

    public Test(int id_test, String fecha_test, String evaluador_test, String estado_test) {
        this.Id_test = id_test;
        Fecha_test = fecha_test;
        Evaluador_test = evaluador_test;
        Estado_test = estado_test;
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
}
