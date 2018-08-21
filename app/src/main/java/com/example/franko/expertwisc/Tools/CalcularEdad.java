package com.example.franko.expertwisc.Tools;

import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalcularEdad {

    private int AñoTotal;
    private int AñoEva;
    private int AñoNac;
    private int MesEva;
    private int MesNac;
    private int MesTotal;
    private int DiaEva;
    private int DiaNac;
    private String EdadFinal;
    String EdadPersona, fechaEvaluacion;

    public CalcularEdad(String edadPersona, String fechaEva) {

        EdadPersona = edadPersona;
        fechaEvaluacion = fechaEva;

    }

    public String CalcularEdad() {

        //Dividimos la Edad de la Persona
        String [] fechaPersona;
        String [] fechaEva;

        fechaPersona = EdadPersona.split("-",3);
        AñoNac = Integer.parseInt(fechaPersona[2]);
        MesNac = Integer.parseInt(fechaPersona[1]);
        DiaNac = Integer.parseInt(fechaPersona[0]);


        fechaEva = fechaEvaluacion.split("-",3);
        AñoEva = Integer.parseInt(fechaEva[2]);
        MesEva = Integer.parseInt(fechaEva[1]);
        DiaEva = Integer.parseInt(fechaEva[0]);

        AñoTotal = AñoEva - AñoNac;
        if(MesEva>=MesNac){
            MesTotal = MesEva - MesNac;
            if (MesEva==MesNac){
                if (DiaEva<DiaNac){
                    AñoTotal--;
                    MesTotal = 12 - ((MesNac+1) - MesEva);
                }
            }

        }else{
            AñoTotal--;
            MesTotal = 12 - (MesNac - MesEva);
        }

        Utilidades.edadActual = AñoTotal+"."+MesTotal; //Setteamos el formato de la edad en Integer

        String mes = "meses";
        if (MesTotal == 1){
            mes = "mes";
        }
        //Devolvemos la Argentino en Texto
        EdadFinal = AñoTotal+" años y "+MesTotal+" "+mes;


        return EdadFinal;
    }

}
