package com.example.franko.expertwisc.ExpertSystem;

import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;

public class MotorInferencia {

    private String Edad, ResultadoFinal;
    private String [] Area;
    int count=0;
    ArrayList<String> ResultadoBase, ResultadoModulo;

    public String getResultado(String edad, String [] area){
        this.Edad = edad;
        this.Area = area;

        //Llamada a la base de conocimientos
        BaseConocimiento base = new BaseConocimiento();
        ResultadoBase = new ArrayList<>();
        for (int i=0; i < 4; i++){
            if (Integer.parseInt(Utilidades.listResultCompuesta.get(i))<100){
                ResultadoBase.add(base.getResultado(Edad, Area[i])); //Recuperamos los resultados
                count++;
            }
        }

        //Llamada al módulo de aprendizaje
        ModuloAprendizaje modulo = new ModuloAprendizaje();
        ResultadoModulo = new ArrayList<>();
        for (int i=0; i < 4; i++){
            if (Integer.parseInt(Utilidades.listResultCompuesta.get(i))<100){
                ResultadoModulo.add(modulo.getResultado(Area[i])); //Recuperamos los resultados
                count++;
            }
        }

        //Estructuramos los datos devuelvos



        return ResultadoFinal;
    }

}
