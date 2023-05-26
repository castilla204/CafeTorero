/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class Usuario {
    private int codigoUsuario;
    private String usuario;
    private String email;
    private String contraseña;
    private String ciudad;
    private String direccion;
    
    public Usuario(String usuario, String email, String contraseña, String ciudad, String direccion) {
        this.codigoUsuario = 0;
        this.usuario = usuario;
        this.email = email;
        this.contraseña = contraseña;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Usuario(int codigoUsuario, String usuario, String email, String contraseña, String ciudad, String direccion) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.email = email;
        this.contraseña = contraseña;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }
}
