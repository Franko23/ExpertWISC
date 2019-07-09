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

    String resultado;

    public String getResultado(String edad, String area, Context context) {
        con = new ConexionHelper(context,"bd_wisc", null, 1);
        Reglas();

        //Base de Hechos
        Edad.setValue(edad);
        Area.setValue(area);

        baseDeReglas.forwardChain();

        resultado = Resultado.getValue();

        return resultado;
    }

    //Motor de Inferencia
    private void Reglas() {

        Edad = new RuleVariable(baseDeReglas, "");
        Area = new RuleVariable(baseDeReglas,"");
        Resultado = new RuleVariable(baseDeReglas,"");

        Condition igual = new Condition("=");
        Condition mayor = new Condition(">");
        Condition menor = new Condition("<");

        Resultado = BaseDeConocimiento(Edad,Area, Resultado, igual, mayor, menor);

    }

    //Base de Conocimiento
    private RuleVariable BaseDeConocimiento(
            RuleVariable Edad,
            RuleVariable Area,
            RuleVariable Resultado,
            Condition igual,
            Condition mayor,
            Condition menor
    ){

        //ICV
        Rule UnoICV = new Rule(baseDeReglas, "UnoICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"8") //Edad del paciente
                },
                new Clause(Resultado,igual,getDataBaseRes("Psicogénesis de la lectoescritura, Prolec, VADS")) //Respuesta de la base de datos
        );
        Rule DosICV = new Rule(baseDeReglas, "DosICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"10") //Edad del paciente
                },
                new Clause(Resultado,igual,getDataBaseRes("Prolec, LEE")) //Respuesta de la base de datos
        );
        Rule TresICV = new Rule(baseDeReglas, "TresICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"12") //Edad del paciente
                },
                new Clause(Resultado,igual,getDataBaseRes("LEE, VADS")) //Respuesta de la base de datos
        );
        Rule CuatroICV = new Rule(baseDeReglas, "CuatroICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"14") //Edad del paciente
                },
                new Clause(Resultado,igual,getDataBaseRes("Prolec-se, VADS")) //Respuesta de la base de datos
        );
        Rule CincoICV = new Rule(baseDeReglas, "CincoICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"15") //Edad del paciente
                },
                new Clause(Resultado,igual,getDataBaseRes("Prolec-se")) //Respuesta de la base de datos
        );
        Rule SeisICV = new Rule(baseDeReglas, "SeisICV",
                new Clause[]{
                        new Clause(Area,igual,"ICV"), //Nombre del área
                        new Clause(Edad,menor,"16") //Edad del paciente
                },
                new Clause(Resultado,igual,getDataBaseRes("Prolec-se")) //Respuesta de la base de datos
        );

        return Resultado;
    }

    private String getDataBaseRes(String test){
        String sugerencia="", conclusiones="", area, respuesta;
        SQLiteDatabase db = con.getWritableDatabase();
    //Llamada a la base de datos de conocimiento
        area = String.valueOf(Area);
        String[] campos = new String[] {"sugerencia","recomendaciones"};
        String[] args = new String[] {String.valueOf(Edad), test, Utilidades.motivo, Utilidades.antecedentes};

        Cursor c = db.query(area, campos, "edad=?, test=?, motivo=?, antecedentes=?", args, null, null, null);

            //Nos aseguramos de que existe al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    sugerencia = c.getString(0);
                    conclusiones = c.getString(0);
                } while (c.moveToNext());
            }

            respuesta = sugerencia + "/" + conclusiones;
        return respuesta;
    }


    public void insertDataAprendizaje(){
        //Llenado de nueva información

    }

}
