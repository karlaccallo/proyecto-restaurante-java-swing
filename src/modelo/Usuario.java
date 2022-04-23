/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Usuario {

//Atributos
    private int usuarioId;
    private String usuario;
    private String password;
    private String rol;
    private String habilitado;
    private int empleadoId;
    private String empleadoName;

    //Constructor
    public Usuario() {
    }

    public Usuario(int usuarioId, String usuario, String password, String rol, String habilitado, int empleadoId, String empleadoName) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.habilitado = habilitado;
        this.empleadoId = empleadoId;
        this.empleadoName = empleadoName;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getEmpleadoName() {
        return empleadoName;
    }

    public void setEmpleadoName(String empleadoName) {
        this.empleadoName = empleadoName;
    }

}
