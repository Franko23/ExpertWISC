package com.example.franko.expertwisc.ExpertSystem;

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
        BaseDeConocimiento();
        Edad.setValue(edad);
        Area.setValue(area);

        baseDeReglas.forwardChain();

        resultado = Resultado.getValue();

        return resultado;
    }

    private void BaseDeConocimiento() {
        Edad = new RuleVariable(baseDeReglas, "");
        Area = new RuleVariable(baseDeReglas,"");
        Resultado = new RuleVariable(baseDeReglas,"");

        Condition igual = new Condition("=");
        Condition mayor = new Condition(">");
        Condition menor = new Condition("<");

        Rule reglaUno = new Rule(baseDeReglas, "reglaUno",
                new Clause[]{
                    new Clause(Area,igual,"ICV"),
                        new Clause(Edad,menor,"10")
                },
                    new Clause(Resultado,igual,"LEE")
        );

        Rule reglaDos = new Rule(baseDeReglas, "reglaDos",
                new Clause[]{
                    new Clause(Area,igual,"ICV"),
                        new Clause(Edad,mayor,"9")
                },
                    new Clause(Resultado,igual,"PROLEC")
        );

        Rule reglaTres = new Rule(baseDeReglas, "reglaTres",
                new Clause[]{
                    new Clause(Area,igual,"IRP"),
                        new Clause(Edad,menor,"7")
                },
                    new Clause(Resultado,igual,"BENDER")
        );

        Rule reglaCuatro = new Rule(baseDeReglas, "reglaCuatro",
                new Clause[]{
                    new Clause(Area,igual,"IRP"),
                        new Clause(Edad,mayor,"6")
                },
                    new Clause(Resultado,igual,"TEPSI")
        );

        Rule reglaCinco = new Rule(baseDeReglas, "reglaCinco",
                new Clause[]{
                    new Clause(Area,igual,"IMO"),
                        new Clause(Edad,menor,"7")
                },
                    new Clause(Resultado,igual,"Pre-Cálculo")
        );

        Rule reglaSeis = new Rule(baseDeReglas, "reglaSeis",
                new Clause[]{
                    new Clause(Area,igual,"IMO"),
                        new Clause(Edad,mayor,"6")
                },
                    new Clause(Resultado,igual,"Pro-Cálculo")
        );

        Rule reglaSiete = new Rule(baseDeReglas, "reglaCinco",
                new Clause[]{
                    new Clause(Area,igual,"IVP"),
                        new Clause(Edad,menor,"7")
                },
                    new Clause(Resultado,igual,"Pre-Cálculo")
        );

        Rule reglaOcho = new Rule(baseDeReglas, "reglaSeis",
                new Clause[]{
                    new Clause(Area,igual,"IVP"),
                        new Clause(Edad,mayor,"6")
                },
                    new Clause(Resultado,igual,"Pro-Cálculo")
        );



    }
}
