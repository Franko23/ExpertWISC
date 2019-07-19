package com.example.franko.expertwisc.ExpertSystem;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import Rule.BooleanRuleBase;
import Rule.Clause;
import Rule.Condition;
import Rule.Rule;
import Rule.RuleVariable;

public class BaseConocimiento {

    BooleanRuleBase baseDeReglas = new BooleanRuleBase("baseDeReglas");
    RuleVariable Edad;
    RuleVariable Area;
    RuleVariable Resultado;
    ConexionHelper con;

    String resultado="";

    public String getResultado(String edad, String area, Context context) {
        con = new ConexionHelper(context,"bd_wisc", null, 1);
        BaseDeConocimiento();

        Edad.setValue(edad);
        Area.setValue(area);

        baseDeReglas.forwardChain(); // Tipo de encadenamiento

        resultado = getDataBaseRes(Resultado.getValue(),edad,area); //Justo aquí

        return resultado;
    }

    //Base de Reglas
    public void BaseDeConocimiento(){

        Edad = new RuleVariable(baseDeReglas, "");
        Area = new RuleVariable(baseDeReglas,"");
        Resultado = new RuleVariable(baseDeReglas,"");

        //Condicionales
        Condition igual = new Condition("=");
        Condition mayor = new Condition(">");
        Condition menor = new Condition("<");

        //ICV
        Rule UnoICV = new Rule(baseDeReglas, "UnoICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"8") //Edad del paciente
                },
                new Clause(Resultado,igual,"Psicogénesis de la lectoescritura, Prolec, VADS") //Respuesta de la base de datos
        );
        Rule DosICV = new Rule(baseDeReglas, "DosICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"10") //Edad del paciente
                },
                new Clause(Resultado,igual,"Prolec, LEE") //Respuesta de la base de datos
        );
        Rule TresICV = new Rule(baseDeReglas, "TresICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"12") //Edad del paciente
                },
                new Clause(Resultado,igual,"LEE, VADS") //Respuesta de la base de datos
        );
        Rule CuatroICV = new Rule(baseDeReglas, "CuatroICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"14") //Edad del paciente
                },
                new Clause(Resultado,igual,"Prolec-se, VADS") //Respuesta de la base de datos
        );
        Rule CincoICV = new Rule(baseDeReglas, "CincoICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"15") //Edad del paciente
                },
                new Clause(Resultado,igual,"Prolec-se") //Respuesta de la base de datos
        );
        Rule SeisICV = new Rule(baseDeReglas, "SeisICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"16") //Edad del paciente
                },
                new Clause(Resultado,igual,"Prolec-se") //Respuesta de la base de datos
        );

        //IRP
        Rule UnoIRP = new Rule(baseDeReglas, "UnoIRP",
                new Clause[]{
                        new Clause(Area,igual,"IRP"), //Nombre del área
                        new Clause(Edad,menor,"8") //Edad del paciente
                },
                new Clause(Resultado,igual,"Pro cálculo, Bender, DFH") //Respuesta de la base de datos
        );
        Rule DosIRP = new Rule(baseDeReglas, "DosIRP",
                new Clause[]{
                        new Clause(Area,igual,"IRP"), //Nombre del área
                        new Clause(Edad,menor,"10") //Edad del paciente
                },
                new Clause(Resultado,igual,"Pro cálculo, Bender, DFH") //Respuesta de la base de datos
        );
        Rule TresIRP = new Rule(baseDeReglas, "TresIRP",
                new Clause[]{
                        new Clause(Area,igual,"IRP"), //Nombre del área
                        new Clause(Edad,menor,"12") //Edad del paciente
                },
                new Clause(Resultado,igual,"Bender, DFH") //Respuesta de la base de datos
        );
        Rule CuatroIRP = new Rule(baseDeReglas, "CuatroIRP",
                new Clause[]{
                        new Clause(Area,igual,"IRP"), //Nombre del área
                        new Clause(Edad,menor,"14") //Edad del paciente
                },
                new Clause(Resultado,igual,"Bender, DFH") //Respuesta de la base de datos
        );
        Rule CincoIRP = new Rule(baseDeReglas, "CincoIRP",
                new Clause[]{
                        new Clause(Area,igual,"IRP"), //Nombre del área
                        new Clause(Edad,menor,"15") //Edad del paciente
                },
                new Clause(Resultado,igual,"P.M.A.") //Respuesta de la base de datos
        );
        Rule SeisIRP = new Rule(baseDeReglas, "SeisIRP",
                new Clause[]{
                        new Clause(Area,igual,"IRP"), //Nombre del área
                        new Clause(Edad,menor,"16") //Edad del paciente
                },
                new Clause(Resultado,igual,"P.M.A.") //Respuesta de la base de datos
        );


        //IMO
        Rule UnoIMO = new Rule(baseDeReglas, "UnoIMO",
                new Clause[]{
                        new Clause(Area,igual,"IMO"), //Nombre del área
                        new Clause(Edad,menor,"8") //Edad del paciente
                },
                new Clause(Resultado,igual,"A.B.C, VADS") //Respuesta de la base de datos
        );
        Rule DosIMO = new Rule(baseDeReglas, "DosIMO",
                new Clause[]{
                        new Clause(Area,igual,"IMO"), //Nombre del área
                        new Clause(Edad,menor,"10") //Edad del paciente
                },
                new Clause(Resultado,igual,"VADS") //Respuesta de la base de datos
        );
        Rule TresIMO = new Rule(baseDeReglas, "TresIMO",
                new Clause[]{
                        new Clause(Area,igual,"IMO"), //Nombre del área
                        new Clause(Edad,menor,"12") //Edad del paciente
                },
                new Clause(Resultado,igual,"VADS") //Respuesta de la base de datos
        );
        Rule CuatroIMO = new Rule(baseDeReglas, "CuatroIMO",
                new Clause[]{
                        new Clause(Area,igual,"IMO"), //Nombre del área
                        new Clause(Edad,menor,"14") //Edad del paciente
                },
                new Clause(Resultado,igual,"VADS") //Respuesta de la base de datos
        );
        Rule CincoIMO = new Rule(baseDeReglas, "CincoIMO",
                new Clause[]{
                        new Clause(Area,igual,"IMO"), //Nombre del área
                        new Clause(Edad,menor,"15") //Edad del paciente
                },
                new Clause(Resultado,igual,"P.M.A.") //Respuesta de la base de datos
        );
        Rule SeisIMO = new Rule(baseDeReglas, "SeisIMO",
                new Clause[]{
                        new Clause(Area,igual,"IMO"), //Nombre del área
                        new Clause(Edad,menor,"16") //Edad del paciente
                },
                new Clause(Resultado,igual,"VADS") //Respuesta de la base de datos
        );


        //IVP
        Rule UnoIVP = new Rule(baseDeReglas, "UnoIVP",
                new Clause[]{
                        new Clause(Area,igual,"IVP"), //Nombre del área
                        new Clause(Edad,menor,"8") //Edad del paciente
                },
                new Clause(Resultado,igual,"Pro cálculo, BENDER") //Respuesta de la base de datos
        );
        Rule DosIVP = new Rule(baseDeReglas, "DosIVP",
                new Clause[]{
                        new Clause(Area,igual,"IVP"), //Nombre del área
                        new Clause(Edad,menor,"10") //Edad del paciente
                },
                new Clause(Resultado,igual,"Raven, Pro cálculo, BENDER") //Respuesta de la base de datos
        );
        Rule TresIVP = new Rule(baseDeReglas, "TresIVP",
                new Clause[]{
                        new Clause(Area,igual,"IVP"), //Nombre del área
                        new Clause(Edad,menor,"12") //Edad del paciente
                },
                new Clause(Resultado,igual,"Raven, Bender") //Respuesta de la base de datos
        );
        Rule CuatroIVP = new Rule(baseDeReglas, "CuatroIVP",
                new Clause[]{
                        new Clause(Area,igual,"IVP"), //Nombre del área
                        new Clause(Edad,menor,"14") //Edad del paciente
                },
                new Clause(Resultado,igual,"Raven, Bender") //Respuesta de la base de datos
        );
        Rule CincoIVP = new Rule(baseDeReglas, "CincoIMO",
                new Clause[]{
                        new Clause(Area,igual,"IVP"), //Nombre del área
                        new Clause(Edad,menor,"15") //Edad del paciente
                },
                new Clause(Resultado,igual,"Raven, P.M.A.") //Respuesta de la base de datos
        );
        Rule SeisIVP = new Rule(baseDeReglas, "SeisIVP",
                new Clause[]{
                        new Clause(Area,igual,"IVP"), //Nombre del área
                        new Clause(Edad,menor,"16") //Edad del paciente
                },
                new Clause(Resultado,igual,"Raven, P.M.A.") //Respuesta de la base de datos
        );


    }

    //Llamada a la base de datos
    private String getDataBaseRes(String test, String edad, String area){
        String sugerencias="", conclusiones="", respuesta;
        SQLiteDatabase db = con.getWritableDatabase();

        //Llamada a la base de datos
        area =  area.toLowerCase();

        String[] args = new String[] {edad, test, Utilidades.motivo, Utilidades.antecedentes};
        String arg = "edad_"+area+"=? AND sugerencias_key_"+area+"=? AND motivo_"+area+"=? AND antecedentes_"+area+"=?";

        //Edad, área, sugerencias, motivo y antecedentes


        Cursor c;
        c = db.rawQuery("SELECT sugerencias_"+area+", conclusiones_"+area+ ", sugerencias_key_"+area+", conclusiones_key_"+area+" FROM "+area+" WHERE "+arg, args );

            //Nos aseguramos de que exista al menos un registro coincidente
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    sugerencias = c.getString(0);
                    conclusiones = c.getString(1);
                    Utilidades.Sugerencias_key = c.getString(2);
                    Utilidades.Conclusiones_key = c.getString(3);
                } while (c.moveToNext());
            }else{ //Si no se encuentran registros, devolvemos el primero
                c = db.rawQuery("SELECT conclusiones_"+area+", conclusiones_key_"+area+" FROM "+area, null);
                if (c.moveToFirst()) {
                    do {
                        conclusiones = c.getString(0);
                        Utilidades.Conclusiones_key = c.getString(1);
                    } while (c.moveToNext());
                }
            }
            if (sugerencias == ""){
                sugerencias = "Se recomienda el uso de las siguientes pruebas: "+test;
                Utilidades.Sugerencias_key = test;
            }

            respuesta = sugerencias + "/" + conclusiones;
        return respuesta;
    }

}
