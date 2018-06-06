package com.example.franko.expertwisc.Entidades;

import java.io.Serializable;

/**
 * Created by FRANKO on 15/11/2017.
 */

public class Paciente implements Serializable {
    private Integer Id_paciente;
    private String MotivoConsulta_paciente;
    private String Antecedentes_paciente;
    private Integer Id_persona;
    private Integer Id_test;

    public Paciente(Integer id_paciente, String motivoConsulta_paciente, String antecedentes_paciente, String edad_paciente, Integer id_persona, Integer id_test) {
        Id_paciente = id_paciente;
        MotivoConsulta_paciente = motivoConsulta_paciente;
        Antecedentes_paciente = antecedentes_paciente;
        Id_persona = id_persona;
        Id_test = id_test;
    }

    public Paciente() {
    }

    public Integer getId_paciente() {
        return Id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        Id_paciente = id_paciente;
    }

    public String getMotivoConsulta_paciente() {
        return MotivoConsulta_paciente;
    }

    public void setMotivoConsulta_paciente(String motivoConsulta_paciente) {
        MotivoConsulta_paciente = motivoConsulta_paciente;
    }

    public String getAntecedentes_paciente() {
        return Antecedentes_paciente;
    }

    public void setAntecedentes(String antecedentes_paciente) {
        Antecedentes_paciente = antecedentes_paciente;
    }


    public Integer getId_persona() {
        return Id_persona;
    }

    public void setId_persona(Integer id_persona) {
        Id_persona = id_persona;
    }

    public Integer getId_test() {
        return Id_test;
    }

    public void setId_test(Integer id_test) {
        Id_test = id_test;
    }
}
