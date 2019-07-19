package com.example.franko.expertwisc.ExpertSystem;

import android.content.Context;

import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;

public class MotorInferencia {

    private String Edad, ResultadoFinal;
    private String [] Area;
    int count=0;
    ArrayList<String> ResultadoBase, ResultadoModulo;

    public String getResultado(String edad, String [] area, Context context){
        this.Edad = edad;
        this.Area = area;

        //Llamada a la base de conocimientos
        BaseConocimiento base = new BaseConocimiento();
        ResultadoBase = new ArrayList<>();
        for (int i=0; i < 4; i++){
            //Si el valor del 1er índice es menor a 90
            if (Integer.parseInt(Utilidades.listResultCompuesta.get(i))<90){
                ResultadoBase.add(base.getResultado(Edad, Area[i], context)); //Recuperamos los resultados
                count++;
            }
        }


        //Estructuramos la información obtenida
        for (int i = 0; i<ResultadoBase.size(); i++){
            String [] resp = ResultadoBase.get(0).split("/");
            Utilidades.Sugerencias = resp[0];
            Utilidades.Conclusiones = resp[1];
        }

        return ResultadoFinal;
    }

}
