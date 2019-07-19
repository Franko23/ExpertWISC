package com.example.franko.expertwisc.Entidades;

public class Base {
    private Integer BaseId;
    private String Edad;
    private String Sugerencias_key;
    private String Conclusiones_key;
    private String Motivo;
    private String Antecedentes;

    private String Sugerencias;
    private String Conclusiones;

    public Base(Integer baseId, String edad, String sugerencias_key, String conclusiones_key, String motivo, String antecedentes, String sugerencias, String conclusiones) {
        BaseId = baseId;
        Edad = edad;
        Sugerencias_key = sugerencias_key;
        Conclusiones_key = conclusiones_key;
        Motivo = motivo;
        Antecedentes = antecedentes;
        Sugerencias = sugerencias;
        Conclusiones = conclusiones;
    }

    public Integer getBaseId() {
        return BaseId;
    }

    public void setBaseId(Integer baseId) {
        BaseId = baseId;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getSugerencias_key() {
        return Sugerencias_key;
    }

    public void setSugerencias_key(String sugerencias_key) {
        Sugerencias_key = sugerencias_key;
    }

    public String getConclusiones_key() {
        return Conclusiones_key;
    }

    public void setConclusiones_key(String conclusiones_key) {
        Conclusiones_key = conclusiones_key;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public String getAntecedentes() {
        return Antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        Antecedentes = antecedentes;
    }

    public String getSugerencias() {
        return Sugerencias;
    }

    public void setSugerencias(String sugerencias) {
        Sugerencias = sugerencias;
    }

    public String getConclusiones() {
        return Conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        Conclusiones = conclusiones;
    }
}
