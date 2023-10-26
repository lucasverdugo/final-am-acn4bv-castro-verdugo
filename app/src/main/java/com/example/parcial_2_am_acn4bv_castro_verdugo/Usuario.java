package com.example.parcial_2_am_acn4bv_castro_verdugo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String usuario;
    private String nombre;
    private String apellido;
    private String password;
    private String mail;
    private int dni;

    public Usuario(){

    }
    public Usuario(String usuario, String nombre, String apellido, String password, String mail, int dni){
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.mail =  mail;
        this.dni = dni;
    };

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
