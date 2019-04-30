package com.example.franko.expertwisc.ExpertSystem;

import android.hardware.ConsumerIrManager;

import java.util.List;

import Rule.BooleanRuleBase;
import Rule.Clause;
import Rule.Condition;
import Rule.Rule;
import Rule.RuleBase;
import Rule.RuleVariable;

public class SistemaExperto {
    BooleanRuleBase baseDeReglas = new BooleanRuleBase("baseDeReglas");
    RuleVariable Edad;
    RuleVariable Area;
    RuleVariable Resultado;

    String resultado;

    public String getResultado(String edad, String area) {

        MotorDeInferencia();

        //Base de Hechos
        Edad.setValue(edad);
        Area.setValue(area);

        baseDeReglas.forwardChain();

        resultado = Resultado.getValue();

        return resultado;
    }

    //Motor de Inferencia
    private void MotorDeInferencia() {

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
        Rule reglaICV6 = new Rule(baseDeReglas, "reglaICV6",
                new Clause[]{
                        new Clause(Area,igual,"ICV"),
                        new Clause(Edad,menor,"8")
                },
                new Clause(Resultado,igual,"PLE, PROLEC, VADS")
        );

        Rule reglaICV8 = new Rule(baseDeReglas, "reglaICV8",
                new Clause[]{
                        new Clause(Area,igual,"ICV"),
                        new Clause(Edad,menor,"10")
                },
                new Clause(Resultado,igual,"PROLEC, LEE")
        );
        Rule reglaICV10 = new Rule(baseDeReglas, "reglaICV10",
                new Clause[]{
                        new Clause(Area,igual,"ICV"),
                        new Clause(Edad,menor,"12")
                },
                new Clause(Resultado,igual,"LEE, VADS")
        );
        Rule reglaICV12 = new Rule(baseDeReglas, "reglaICV12",
                new Clause[]{
                        new Clause(Area,igual,"ICV"),
                        new Clause(Edad,menor,"14")
                },
                new Clause(Resultado,igual,"PROLEC-SE, VADS")
        );
        Rule reglaICV14 = new Rule(baseDeReglas, "reglaICV14",
                new Clause[]{
                        new Clause(Area,igual,"ICV"),
                        new Clause(Edad,menor,"15")
                },
                new Clause(Resultado,igual,"PROLEC-SE")
        );
        Rule reglaICV15 = new Rule(baseDeReglas, "reglaICV15",
                new Clause[]{
                        new Clause(Area,igual,"ICV"),
                        new Clause(Edad,mayor,"14")
                },
                new Clause(Resultado,igual,"PROLEC-SE")
        );


        //IRP
        Rule reglaIRP6 = new Rule(baseDeReglas, "reglaIRP6",
                new Clause[]{
                        new Clause(Area,igual,"IRP"),
                        new Clause(Edad,menor,"8")
                },
                new Clause(Resultado,igual,"PROCALCULO, BENDER, DFH")
        );

        Rule reglaIRP8 = new Rule(baseDeReglas, "reglaIRP8",
                new Clause[]{
                        new Clause(Area,igual,"IRP"),
                        new Clause(Edad,menor,"10")
                },
                new Clause(Resultado,igual,"PROCALCULO, BENDER, DFHE")
        );
        Rule reglaIRP10 = new Rule(baseDeReglas, "reglaIRP10",
                new Clause[]{
                        new Clause(Area,igual,"IRP"),
                        new Clause(Edad,menor,"12")
                },
                new Clause(Resultado,igual,"BENDER, DFH")
        );
        Rule reglaIRP12 = new Rule(baseDeReglas, "reglaIRP12",
                new Clause[]{
                        new Clause(Area,igual,"IRP"),
                        new Clause(Edad,menor,"14")
                },
                new Clause(Resultado,igual,"BENDER, DFH")
        );
        Rule reglaIRP14 = new Rule(baseDeReglas, "reglaIRP14",
                new Clause[]{
                        new Clause(Area,igual,"IRP"),
                        new Clause(Edad,menor,"15")
                },
                new Clause(Resultado,igual,"PMA")
        );
        Rule reglaIRP15 = new Rule(baseDeReglas, "reglaIRP15",
                new Clause[]{
                        new Clause(Area,igual,"IRP"),
                        new Clause(Edad,mayor,"14")
                },
                new Clause(Resultado,igual,"PMA")
        );

        //IMO
        Rule reglaIMO6 = new Rule(baseDeReglas, "reglaIMO6",
                new Clause[]{
                        new Clause(Area,igual,"IMO"),
                        new Clause(Edad,menor,"8")
                },
                new Clause(Resultado,igual,"ABC, VADS")
        );

        Rule reglaIMO8 = new Rule(baseDeReglas, "reglaIMO8",
                new Clause[]{
                        new Clause(Area,igual,"IMO"),
                        new Clause(Edad,menor,"10")
                },
                new Clause(Resultado,igual,"VADS")
        );
        Rule reglaIMO10 = new Rule(baseDeReglas, "reglaIMO10",
                new Clause[]{
                        new Clause(Area,igual,"IMO"),
                        new Clause(Edad,menor,"12")
                },
                new Clause(Resultado,igual,"VADS")
        );
        Rule reglaIMO12 = new Rule(baseDeReglas, "reglaIMO12",
                new Clause[]{
                        new Clause(Area,igual,"IMO"),
                        new Clause(Edad,menor,"14")
                },
                new Clause(Resultado,igual,"VADS")
        );
        Rule reglaIMO14 = new Rule(baseDeReglas, "reglaIMO14",
                new Clause[]{
                        new Clause(Area,igual,"IMO"),
                        new Clause(Edad,menor,"15")
                },
                new Clause(Resultado,igual,"")
        );
        Rule reglaIMO15 = new Rule(baseDeReglas, "reglaIMO15",
                new Clause[]{
                        new Clause(Area,igual,"IMO"),
                        new Clause(Edad,mayor,"14")
                },
                new Clause(Resultado,igual,"")
        );

        //IVP
        Rule reglaIVP6 = new Rule(baseDeReglas, "reglaIVP6",
                new Clause[]{
                        new Clause(Area,igual,"IVP"),
                        new Clause(Edad,menor,"8")
                },
                new Clause(Resultado,igual,"PROCALCULO, BENDER")
        );

        Rule reglaIVP8 = new Rule(baseDeReglas, "reglaIVP8",
                new Clause[]{
                        new Clause(Area,igual,"IVP"),
                        new Clause(Edad,menor,"10")
                },
                new Clause(Resultado,igual,"RAVEN-C, BENDER, PROCALCULO")
        );
        Rule reglaIVP10 = new Rule(baseDeReglas, "reglaIVP10",
                new Clause[]{
                        new Clause(Area,igual,"IVP"),
                        new Clause(Edad,menor,"12")
                },
                new Clause(Resultado,igual,"RAVEN-C, BENDER")
        );
        Rule reglaIVP12 = new Rule(baseDeReglas, "reglaIVP12",
                new Clause[]{
                        new Clause(Area,igual,"IVP"),
                        new Clause(Edad,menor,"14")
                },
                new Clause(Resultado,igual,"RAVEN-G, BENDER")
        );
        Rule reglaIVP14 = new Rule(baseDeReglas, "reglaIVP14",
                new Clause[]{
                        new Clause(Area,igual,"IVP"),
                        new Clause(Edad,menor,"15")
                },
                new Clause(Resultado,igual,"RAVEN-G, PMA")
        );
        Rule reglaIVP15 = new Rule(baseDeReglas, "reglaIVP15",
                new Clause[]{
                        new Clause(Area,igual,"IVP"),
                        new Clause(Edad,mayor,"14")
                },
                new Clause(Resultado,igual,"PMA, RAVEN-C")
        );



        return Resultado;
    }
}
