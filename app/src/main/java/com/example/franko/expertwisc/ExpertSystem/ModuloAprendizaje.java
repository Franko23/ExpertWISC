package com.example.franko.expertwisc.ExpertSystem;

import com.example.franko.expertwisc.Utilidades.Utilidades;

public class ModuloAprendizaje {

    String Area, Antecedentes, Motivo;


    public String getResultado(String area){
        this.Area = area;
        this.Antecedentes = Utilidades.antecedentes;
        this.Motivo = Utilidades.motivo;

        String Respuesta;

        Respuesta = getDataBase(Area, Antecedentes, Motivo);


        return Respuesta;
    }

    private String getDataBase(String area, String antecedentes, String motivo) {
        String respusta = "";

        //Llamada a la base de datos de Aprndizaje

        return respusta;
    }


    public void insertDataBase(){
        //Llenado de nueva información
    }

}
