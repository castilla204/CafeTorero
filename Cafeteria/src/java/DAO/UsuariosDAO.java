/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexiones.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author PC
 */
public class UsuariosDAO implements DAO<Usuario>{
    
    private ConexionOracle conn;

    public UsuariosDAO() {
        this.conn = new ConexionOracle();
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Usuario t) {
        Connection con = conn.conectar();
        String sql = "INSERT INTO Usuarios (Usuario, Email, Contraseña, "+
                "Ciudad, Direccion) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getUsuario());
            ps.setString(2, t.getEmail());
            ps.setString(3, t.getContraseña());
            ps.setString(4, t.getCiudad());
            ps.setString(5, t.getDireccion());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn.desconectar();
    }
    
    
    public Usuario getByUserName(String userName){
        Connection con = conn.conectar();
        String sql = "SELECT * FROM Usuarios WHERE usuario = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Usuario(rs.getInt("CodUsuario"),
                    rs.getString("Usuario"),
                     rs.getString("Email"),
                rs.getString("Contraseña"),
                rs.getString("Ciudad"),
                rs.getString("Direccion"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn.desconectar();
        return null;
    }
}
