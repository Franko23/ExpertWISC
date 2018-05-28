package com.example.franko.expertwisc.Entidades;
import java.io.Serializable;
import java.sql.Blob;

public class Usuario implements Serializable{
    private Integer id;
    private String Nombre;
    private String Apellido;
    private String Usuario;
    private  String Contraseña;
    private byte[] Imagen;

    public Usuario(Integer id, String nombre, String apellido, String usuario, String contraseña, byte[] imagen) {
        this.id = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Usuario = usuario;
        this.Contraseña = contraseña;
        this.Imagen = imagen;
    }

    public Usuario(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] imagen) {
        Imagen = imagen;
    }
}
