package com.example.franko.expertwisc.Entidades;

import java.io.Serializable;

public class Persona implements Serializable {
    private Integer Id_persona;
    private String Nombre_persona;
    private String Apellido_persona;
    private String Fecha_nacimiento_persona;
    private byte[] Imagen_persona;

    public Persona(Integer id_persona, String nombre_persona, String apellido_persona, String fecha_nacimiento_persona, byte[] imagen_persona) {
        Id_persona = id_persona;
        Nombre_persona = nombre_persona;
        Apellido_persona = apellido_persona;
        Fecha_nacimiento_persona = fecha_nacimiento_persona;
        Imagen_persona = imagen_persona;
    }

    public Persona() {
    }

    public Integer getId_persona() {
        return Id_persona;
    }

    public void setId_persona(Integer id_persona) {
        Id_persona = id_persona;
    }

    public String getNombre_persona() {
        return Nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        Nombre_persona = nombre_persona;
    }

    public String getApellido_persona() {
        return Apellido_persona;
    }

    public void setApellido_persona(String apellido_persona) {
        Apellido_persona = apellido_persona;
    }

    public String getFecha_nacimiento_persona() {
        return Fecha_nacimiento_persona;
    }

    public void setFecha_nacimiento_persona(String fecha_nacimiento_persona) {
        Fecha_nacimiento_persona = fecha_nacimiento_persona;
    }

    public byte[] getImagen_persona() {
        return Imagen_persona;
    }

    public void setImagen_persona(byte[] imagen_persona) {
        Imagen_persona = imagen_persona;
    }
}
