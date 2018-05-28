package com.example.franko.expertwisc.Entidades;

import java.io.Serializable;

/**
 * Created by FRANKO on 15/11/2017.
 */

public class Paciente implements Serializable {
    private Integer id;
    private String Nombres;
    private String Apellidos;
    private String Edad;
    private String MotivoConsulta;
    private String Antecedentes;
    private byte[] Imagen;



    public Paciente(Integer id, String nombres, String apellidos, String edad, String motivoConsulta, String antecedentes, byte[] imagen) {
        this.id = id;
        this.Nombres = nombres;
        this.Apellidos = apellidos;
        this.Edad = edad;
        this.MotivoConsulta = motivoConsulta;
        this.Antecedentes = antecedentes;
        this.Imagen = imagen;
    }

    public Paciente(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getMotivoConsulta() {
        return MotivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        MotivoConsulta = motivoConsulta;
    }

    public String getAntecedentes() {
        return Antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        Antecedentes = antecedentes;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] imagen) {
        Imagen = imagen;
    }
}
