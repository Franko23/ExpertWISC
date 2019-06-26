package com.example.franko.expertwisc.Entidades;
import java.io.Serializable;

public class Usuario implements Serializable{
    private Integer Id_usuario;
    private String Nombre_usuario;
    private String Contrasena_usuario;
    private boolean Activo_usuario;
    private Integer Id_persona;
    private String Free_usuario;

    public Usuario(Integer id_usuario, String nombre_usuario, String contraseña_usuario, boolean activo_usuario, Integer id_persona, String free_usuario) {
        this.Id_usuario = id_usuario;
        this.Nombre_usuario = nombre_usuario;
        this.Contrasena_usuario = contraseña_usuario;
        Activo_usuario = activo_usuario;
        this.Id_persona = id_persona;
        this.Free_usuario = free_usuario;
    }

    public Usuario(){
    }

    public Integer getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        Id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        Nombre_usuario = nombre_usuario;
    }

    public String getContrasena_usuario() {
        return Contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        Contrasena_usuario = contrasena_usuario;
    }

    public boolean getActivo_usuario() {
        return Activo_usuario;
    }

    public void setActivo_usuario(boolean activo_usuario) {
        Activo_usuario = activo_usuario;
    }

    public Integer getId_persona() {
        return Id_persona;
    }

    public void setId_persona(Integer id_Persona) {
        Id_persona = id_Persona;
    }

    public boolean isActivo_usuario() {
        return Activo_usuario;
    }

    public String getFree_usuario() {
        return Free_usuario;
    }

    public void setFree_usuario(String free_usuario) {
        Free_usuario = free_usuario;
    }


}
