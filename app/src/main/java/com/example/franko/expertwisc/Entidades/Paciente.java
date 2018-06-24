package com.example.franko.expertwisc.Entidades;

import java.io.Serializable;

/**
 * Created by FRANKO on 15/11/2017.
 */

public class Paciente implements Serializable {
    private Integer Id_paciente;
    private String MotivoConsulta_paciente;
    private String Antecedentes_paciente;
    private String Up_paciente;
    private Integer Id_persona;
    private Integer Id_usuario;

    public Paciente(Integer id_paciente, String motivoConsulta_paciente, String antecedentes_paciente, String up_paciente, Integer id_persona, Integer id_usuario) {
        Id_paciente = id_paciente;
        MotivoConsulta_paciente = motivoConsulta_paciente;
        Antecedentes_paciente = antecedentes_paciente;
        Up_paciente = up_paciente;
        Id_persona = id_persona;
        Id_usuario = id_usuario;
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

    public void setAntecedentes_paciente(String antecedentes_paciente) {
        Antecedentes_paciente = antecedentes_paciente;
    }

    public String getUp_paciente() {
        return Up_paciente;
    }

    public void setUp_paciente(String up_paciente) {
        Up_paciente = up_paciente;
    }



    public Integer getId_persona() {
        return Id_persona;
    }

    public void setId_persona(Integer id_persona) {
        Id_persona = id_persona;
    }

    public Integer getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        Id_usuario = id_usuario;
    }
}
