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

    private List<Usuario> usuarios = new ArrayList<Usuario>();

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

    public void creaUsuarios(){
        Usuario u1 = new Usuario("lverdugo", "Lucas", "Verdugo", "123456", "lverdugo@gmail.com", 22222222);
        Usuario u2 = new Usuario("rfalcon", "Ramon", "Falcon", "123456", "rfalcon@gmail.com", 33333333);
        Usuario u3 = new Usuario("jbjusto", "Juan", "Justo", "123456", "jbjusto@gmail.com", 44444444);
        Usuario u4 = new Usuario("vmartinez", "Victor", "Martinez", "123456", "vmartinez@gmail.com", 44444444);
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
    }

    public List<Usuario> listarUsuarios(){
        creaUsuarios();
        return usuarios;
    }

    public boolean registrarUsuario(String usuario, String nombre, String apellido, String password, String mail, int dni){
        for (Usuario u: usuarios){
            if (u.usuario == usuario || u.dni == dni){
                return false;
            }
        }
        Usuario u1 = new Usuario(usuario, nombre, apellido, password, mail, dni);
        usuarios.add(u1);
        return true;
    }

    public boolean validarUsuario(String usuario, String password){
        for(Usuario u: usuarios){
            if(u.usuario == usuario && u.password == password){
                return true;
            }
        }
        return false;
    }
}
